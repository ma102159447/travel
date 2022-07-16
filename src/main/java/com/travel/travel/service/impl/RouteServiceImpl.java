package com.travel.travel.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.travel.travel.entity.Route;
import com.travel.travel.entity.RouteScenicSpotConfig;
import com.travel.travel.entity.ScenicSpot;
import com.travel.travel.excptionconfig.DataBaseRuntimeException;
import com.travel.travel.mapper.RouteMapper;
import com.travel.travel.mapper.RouteScenicSpotConfigMapper;
import com.travel.travel.mapper.ScenicSpotMapper;
import com.travel.travel.service.RouteScenicSpotConfigService;
import com.travel.travel.service.RouteService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.travel.travel.service.ScenicSpotService;
import com.travel.travel.util.DateFormatUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * <p>
 * InnoDB free: 4096 kB 服务实现类
 * </p>
 *
 * @author Code Duck
 * @since 2022-06-16
 */
@Service
@SuppressWarnings("all")
public class RouteServiceImpl extends ServiceImpl<RouteMapper, Route> implements RouteService {
    @Autowired
    RouteScenicSpotConfigService routeScenicSpotConfigService;
    @Autowired
    ScenicSpotService scenicSpotService;
    ;
    @Autowired
    RouteMapper routeMapper;

    /**
     * 根据参数列表查询路线信息
     *
     * @param route 路线实例（参数列表）
     * @return Route 集合
     */
    @Override
    public List<Route> searchRouteByParams(Route route) {
        QueryWrapper<Route> routeQueryWrapper = new QueryWrapper<>(route);
        return this.list(routeQueryWrapper);
    }

    /**
     * 根据线路id查询线路详细信息以及线路包含的景点详细信息
     *
     * @param routeId 线路id
     * @return JSON查询结果
     */
    @Override
    public Map<String, Object> searchRouteAndScenicSpotByRouteId(String routeId) {
        Map<String, Object> returnMap = new HashMap<>();
        returnMap.put("Route", this.getById(routeId));
        returnMap.put("ScenicSpots", this.routeScenicSpotConfigService.searchRouteScenicSpotConfigByRouteId(routeId));
        return returnMap;
    }

    /**
     * 根据参数列表查询路线数量
     *
     * @param route 路线实例（参数列表）
     * @return int 线路数量
     */
    @Override
    public int routeCountByParams(Route route) {
        QueryWrapper<Route> routeQueryWrapper = new QueryWrapper<>(route);
        return this.count(routeQueryWrapper);
    }


    /**
     * 保存或更新线路信息和线路下所有景点信息如线路里包含id则进行更新操作，如果线路里不包含id则进行增加操作
     *
     * @param route       线路信息
     * @param scenicSpots 线路下所有景点的信息
     * @return int 状态码
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean saveRouteAndScenicSpots(Route route, List<ScenicSpot> scenicSpots) {
        //如果线路对象为空则直接抛出异常，因为此方法所有数据都基于线路存在
        if (route == null) {
            //如果景点对象为空则直接抛出异常，因为此方法所有数据都基于线路存在
            if (scenicSpots == null) {
                throw new DataBaseRuntimeException("参数错误请传入正确参数,错误原因：景点参数为空");
            }
            throw new DataBaseRuntimeException("参数错误请传入正确参数,错误原因：线路参数为空");
        }

        // 如果没有id则进行添加操作，如果有id则进行更新操作
        if (route.getId() == null || ("").equals(route.getId())) {
            //添加操作
            if (!this.save(route)) {
                throw new DataBaseRuntimeException("插入路线时发生异常请稍后再试");
            }
            List<RouteScenicSpotConfig> routeScenicSpotConfigs = new ArrayList<>();
            for (int i = 0; i < scenicSpots.size(); i++) {
                ScenicSpot scenicSpot = scenicSpots.get(i);
                if (scenicSpotService.save(scenicSpot)) {
                    //保存成功则加入景点
                    RouteScenicSpotConfig routeScenicSpotConfig = new RouteScenicSpotConfig();
                    routeScenicSpotConfig.setRouteId(route.getId());
                    routeScenicSpotConfig.setScenicSpotId(scenicSpot.getId());
                    routeScenicSpotConfig.setOrderNum(i + 1);
                } else {
                    throw new DataBaseRuntimeException("插入线路景点时发生异常请稍后再试");
                }
            }
            if (!routeScenicSpotConfigService.saveBatch(routeScenicSpotConfigs)) {
                throw new DataBaseRuntimeException("线路景点配置关联失败请稍后再试");
            }
            return true;
        } else {
            //更新操作
            if (!this.updateById(route)) {
                throw new DataBaseRuntimeException("更新线路信息失败");
            }
            List<RouteScenicSpotConfig> routeScenicSpotConfigs = new ArrayList<>();
            for (int i = 0; i < scenicSpots.size(); i++) {
                ScenicSpot scenicSpot = scenicSpots.get(i);
                //如果景点id为空则进行添加操作否则进行更新操作
                if (scenicSpot.getId() == null || ("").equals(scenicSpot)) {
                    if (!scenicSpotService.save(scenicSpot)) {
                        throw new DataBaseRuntimeException("景点更新异常");
                    }
                } else {
                    if (!scenicSpotService.updateById(scenicSpot)) {
                        throw new DataBaseRuntimeException("景点更新异常");
                    }
                }
                //记录景点配置
                RouteScenicSpotConfig routeScenicSpotConfig = new RouteScenicSpotConfig();
                routeScenicSpotConfig.setRouteId(route.getId());
                routeScenicSpotConfig.setScenicSpotId(scenicSpot.getId());
                routeScenicSpotConfig.setOrderNum(i + 1);
            }
            //执行到这里代表以上操作成功进行景点配置工作
            //清空原有景点配置
            RouteScenicSpotConfig removeConfig = new RouteScenicSpotConfig();
            removeConfig.setRouteId(route.getId());
            QueryWrapper<RouteScenicSpotConfig> deleteWrapper = new QueryWrapper<>(removeConfig);
            if (!routeScenicSpotConfigService.remove(deleteWrapper)) {
                throw new DataBaseRuntimeException("更新景点配置失败");
            }
            //添加新的景点配置
            if (!routeScenicSpotConfigService.saveBatch(routeScenicSpotConfigs)) {
                throw new DataBaseRuntimeException("更新景点配置失败");
            }
            return true;
        }

    }

    /**
     * 添加线路信息同时配置景点
     *
     * @param route
     * @param scenicSpotId
     * @return
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean saveRouteAndConfig(Route route, String[] scenicSpotId) {
        if (route == null) {
            throw new DataBaseRuntimeException("线路信息不能为空");
        }
        if (scenicSpotId == null || scenicSpotId.length == 0) {
            throw new DataBaseRuntimeException("景点信息不能为空");
        }
        route.setCreatetime(new Date());
        route.setFlag(1);
        if (!this.save(route)) {
            throw new DataBaseRuntimeException("添加线路失败");
        }

        List<RouteScenicSpotConfig> routeScenicSpotConfigs = new ArrayList<>();
        for (int i = 0; i < scenicSpotId.length; i++) {
            RouteScenicSpotConfig routeScenicSpotConfig = new RouteScenicSpotConfig();
            routeScenicSpotConfig.setRouteId(route.getId());
            routeScenicSpotConfig.setScenicSpotId(scenicSpotId[i]);
            routeScenicSpotConfig.setOrderNum(i + 1);
            routeScenicSpotConfigs.add(routeScenicSpotConfig);
        }
        if (!routeScenicSpotConfigService.saveBatch(routeScenicSpotConfigs)) {
            throw new DataBaseRuntimeException("配置景点失败");
        }
        return true;
    }


    /**
     * 根据线路id配置线路下的景点
     *
     * @param routeId      线路id
     * @param scenicSpotId 景点id数组
     * @return 是否成功
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean configScenicSpotByRouteId(String routeId, String[] scenicSpotId) {
        if (routeId == null || ("").equals(routeId)) {
            throw new DataBaseRuntimeException("线路id不能为空");
        }
        if (scenicSpotId == null || scenicSpotId.length == 0) {
            throw new DataBaseRuntimeException("配置景点id不能为空");
        }
        RouteScenicSpotConfig routeScenicSpotConfig = new RouteScenicSpotConfig();
        routeScenicSpotConfig.setRouteId(routeId);
        QueryWrapper<RouteScenicSpotConfig> queryWrapper = new QueryWrapper<>(routeScenicSpotConfig);
        //清空原有的配置信息
        if (!routeScenicSpotConfigService.remove(queryWrapper)) {
            throw new DataBaseRuntimeException("配置线路失败");
        }
        //初始化配置信息做批量添加
        List<RouteScenicSpotConfig> routeScenicSpotConfigs = new ArrayList<>();
        for (int i = 0; i < scenicSpotId.length; i++) {
            RouteScenicSpotConfig config = new RouteScenicSpotConfig();
            config.setRouteId(routeId);
            config.setScenicSpotId(scenicSpotId[i]);
            config.setOrderNum(i + 1);
            routeScenicSpotConfigs.add(config);
        }
        //添加景点配置
        if (!routeScenicSpotConfigService.saveBatch(routeScenicSpotConfigs)) {
            throw new DataBaseRuntimeException("配置线路景点失败");
        }
        return true;
    }

    /**
     * 修改线路信息的同时配置景点
     *
     * @param route        线路信息
     * @param scenicSpotId 景点信息
     * @return 是否成功
     */
    @Override
    public boolean updateRouteAndConfigScenicSpot(Route route, String[] scenicSpotId) {
        if (route == null) {
            throw new DataBaseRuntimeException("线路信息不能为空");
        }
        if (route.getId() == null || ("").equals(route.getId())) {
            throw new DataBaseRuntimeException("线路id为空无法进行修改");
        }
        if (scenicSpotId == null || scenicSpotId.length == 0) {
            throw new DataBaseRuntimeException("配置景点id不能为空");
        }
        route.setUpdatetime(new Date());
        if (!this.updateById(route)) {
            throw new DataBaseRuntimeException("线路信息修改失败");
        }
        //初始化配置信息做批量添加
        List<RouteScenicSpotConfig> routeScenicSpotConfigs = new ArrayList<>();
        for (int i = 0; i < scenicSpotId.length; i++) {
            String  scenicSpotIdStr = scenicSpotId[i];
            if(null==scenicSpotIdStr||("null").equals(scenicSpotIdStr)||("NULL").equals(scenicSpotIdStr))
                continue;
            RouteScenicSpotConfig config = new RouteScenicSpotConfig();
            config.setRouteId(route.getId());
            config.setScenicSpotId(scenicSpotIdStr);
            config.setOrderNum(i + 1);
            routeScenicSpotConfigs.add(config);
        }
        //添加景点配置
        if (!routeScenicSpotConfigService.saveBatch(routeScenicSpotConfigs)) {
            throw new DataBaseRuntimeException("配置线路景点失败");
        }
        return true;
    }
}
