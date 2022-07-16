package com.travel.travel.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.travel.travel.entity.Route;
import com.travel.travel.entity.RouteScenicSpotConfig;
import com.travel.travel.entity.ext.RouteScenicSpotConfigExt;
import com.travel.travel.mapper.RouteScenicSpotConfigMapper;
import com.travel.travel.service.RouteScenicSpotConfigService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * InnoDB free: 4096 kB 服务实现类
 * </p>
 *
 * @author Code Duck
 * @since 2022-06-16
 */
@Service
public class RouteScenicSpotConfigServiceImpl extends ServiceImpl<RouteScenicSpotConfigMapper, RouteScenicSpotConfig> implements RouteScenicSpotConfigService {
    @Autowired
    RouteScenicSpotConfigMapper routeScenicSpotConfigMapper;

    /**
     * 修改线路景点配置
     *
     * @param routeScenicSpotConfigs 新的线路景点配置集合
     * @return boolean修改结果
     */
    @Override
    public boolean updateRouteScenicSpotConfigs(List<RouteScenicSpotConfig> routeScenicSpotConfigs) {
        RouteScenicSpotConfig routeScenicSpotConfig = new RouteScenicSpotConfig();
        routeScenicSpotConfig.setRouteId(routeScenicSpotConfigs.get(0).getRouteId());
        QueryWrapper<RouteScenicSpotConfig> queryWrapper = new QueryWrapper<>(routeScenicSpotConfig);
        return this.remove(queryWrapper) && this.saveBatch(routeScenicSpotConfigs);
    }
    /**
     * 根据线路id查询该线路下景点详细信息
     *
     * @param routeId 线路id
     * @return RouteScenicSpotConfigExt 线路下景点详细信息集合
     */
    @Override
    public List<RouteScenicSpotConfigExt> searchRouteScenicSpotConfigByRouteId(String routeId) {
        return routeScenicSpotConfigMapper.searchRouteScenicSpotConfigByRouteId(routeId);
    }

    /**
     * 根据参数列表查询线路景点配置数量
     *
     * @param routeScenicSpotConfig 实例对象（参数列表）
     * @return int 查询数量
     */
    @Override
    public int searchRouteScenicSpotConfigCountByParams(RouteScenicSpotConfig routeScenicSpotConfig) {
        QueryWrapper<RouteScenicSpotConfig> queryWrapper = new QueryWrapper<>(routeScenicSpotConfig);
        return this.count(queryWrapper);
    }


}
