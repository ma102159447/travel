package com.travel.travel.controller;


import com.travel.travel.entity.Route;
import com.travel.travel.entity.RouteScenicSpotConfig;
import com.travel.travel.entity.ScenicSpot;
import com.travel.travel.service.RouteService;
import com.travel.travel.util.ReturnUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * InnoDB free: 4096 kB 前端控制器
 * </p>
 *
 * @author Code Duck
 * @since 2022-06-16
 */
@RestController
@RequestMapping("/route")
public class RouteController {
    @Autowired
    RouteService routeService;

    /**
     * 保存线路信息
     *
     * @param route 线路实例
     * @return <p>JSON保存结果</p><p>code:状态码，200成功，500失败</p> <p>msg:描述信息<p/><p>data:此处为NULL<p/>
     */
    @RequestMapping("saveRoute")
    public ReturnUtil saveRoute(Route route) {
        route.setCreatetime(new Date());
        return routeService.save(route) ? ReturnUtil.createReturnUtil(200, "保存成功", null) : ReturnUtil.createReturnUtil(500, "保存失败", null);
    }
    /**
     * <p>
     * 添加或更新线路信息时同步更新景点信息，和线路下景点配置
     * <p/>
     *
     * @param route       线路对象实例
     * @param scenicSpots 景点对象实例的集合（数组）
     * @return <p>JSON 保存信息</p><p>code:状态码，200成功，500失败</p> <p>msg:描述信息<p/><p>data:此处为NULL<p/>
     */
    @RequestMapping("saveRouteAndScenicSpots")
    public Object saveRouteAndScenicSpots(Route route, List<ScenicSpot> scenicSpots) {
        try {
            return routeService.saveRouteAndScenicSpots(route, scenicSpots) ? ReturnUtil.createReturnUtil(200, "保存成功", null) : ReturnUtil.createReturnUtil(500, "系统异常", null);
        } catch (Exception e) {
            return ReturnUtil.createReturnUtil(500, e.getMessage(), null);
        }
    }

    /**
     * 添加线路信息同时配置景点信息
     * @param route 线路信息
     * @param scenicSpotId 景点信息
     * @return <p>JSON 保存信息</p><p>code:状态码，200成功，500失败</p> <p>msg:描述信息<p/><p>data:此处为NULL<p/>
     */
    @RequestMapping("saveRouteAndConfig")
    public Object saveRouteAndConfig(Route route,String[] scenicSpotId){
        try {
            return routeService.saveRouteAndConfig(route,scenicSpotId)? ReturnUtil.createReturnUtil(200, "保存成功", null) : ReturnUtil.createReturnUtil(500, "系统异常", null);
        } catch (Exception e) {
            e.printStackTrace();
            return ReturnUtil.createReturnUtil(500, e.getMessage(), null);
        }
    }
    /**
     * 根据id修改线路信息
     *
     * @param route 线路实例（参数列表）
     * @return <p>JSON修改结果</p> <p>code:状态码，200成功，500失败</p> <p>msg:描述信息<p/><p>data:此处为NULL<p/>
     */
    @RequestMapping("updateRoute")
    public ReturnUtil updateRoute(Route route) {
        route.setUpdatetime(new Date());
        return routeService.updateById(route) ? ReturnUtil.createReturnUtil(200, "修改成功", null) : ReturnUtil.createReturnUtil(500, "修改失败", null);
    }
    /**
     * 根据线路id配置线路下的景点
     *
     * @param routeId      线路id
     * @param scenicSpotId 景点id数组
     * @return 是否成功
     */
    @RequestMapping("configScenicSpotByRouteId")
    public ReturnUtil configScenicSpotByRouteId(String routeId,String[] scenicSpotId) {
        try {
            return routeService.configScenicSpotByRouteId(routeId,scenicSpotId) ? ReturnUtil.createReturnUtil(200, "配置成功", null) : ReturnUtil.createReturnUtil(500, "配置失败", null);
        } catch (Exception e) {
            return ReturnUtil.createReturnUtil(500, e.getMessage(), null);
        }
    }
    /**
     * 修改线路信息的同时配置景点
     *
     * @param route        线路信息
     * @param scenicSpotId 景点信息
     * @return 是否成功
     */
    @RequestMapping("updateRouteAndConfigScenicSpot")
    public ReturnUtil updateRouteAndConfigScenicSpot(Route route, String[] scenicSpotId){
        try {
            return routeService.updateRouteAndConfigScenicSpot(route,scenicSpotId) ? ReturnUtil.createReturnUtil(200, "配置成功", null) : ReturnUtil.createReturnUtil(500, "配置失败", null);
        } catch (Exception e) {
            return ReturnUtil.createReturnUtil(500, e.getMessage(), null);
        }
    }
    /**
     * 根据参数列表查询线路信息
     *
     * @param route 线路实例（参数列表）
     * @return JSON查询结果
     */
    @RequestMapping("searchRouteByParams")
    public Object searchRouteByParams(Route route) {
        return ReturnUtil.createReturnUtil(200, "查询成功", routeService.searchRouteByParams(route));
    }
    @RequestMapping("searchRouteByParamsPaging")
    public Object searchRouteByParamsPaging(int currentPage,int pageNum,Route route) {
        return ReturnUtil.createReturnUtil(200, "查询成功", routeService.searchRouteByParamsPaging(currentPage,pageNum,route));
    }

    /**
     * 根据线路id查询线路详细信息以及线路包含的景点详细信息
     *
     * @param routeId 线路id
     * @return JSON查询结果
     */
    @RequestMapping("searchRouteAndScenicSpotByRouteId")
    public Object searchRouteAndScenicSpotByRouteId(String routeId) {
        return ReturnUtil.createReturnUtil(200, "查询成功", routeService.searchRouteAndScenicSpotByRouteId(routeId));

    }


    /**
     * 根据参数列表查询线路数量
     *
     * @param route 线路实例（参数列表）
     * @return 线路数量，直接返回数量
     */
    @RequestMapping("routeCountByParams")
    public Object routeCountByParams(Route route) {
        return routeService.routeCountByParams(route);
    }

    /**
     * 根据id删除线路信息
     *
     * @param id 主键
     * @return <p>JSON 删除结果</p><p>code:状态码，200成功，500失败</p> <p>msg:描述信息<p/><p>data:此处为NULL<p/>
     */
    @RequestMapping("removeRouteById")
    public Object removeRouteById(String id) {
        return routeService.removeById(id) ? ReturnUtil.createReturnUtil(200, "删除成功", null) : ReturnUtil.createReturnUtil(500, "删除失败", null);
    }


}
