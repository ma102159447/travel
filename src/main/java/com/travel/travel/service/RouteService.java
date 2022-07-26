package com.travel.travel.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.travel.travel.entity.Route;
import com.baomidou.mybatisplus.extension.service.IService;
import com.travel.travel.entity.ScenicSpot;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * InnoDB free: 4096 kB 服务类
 * </p>
 *
 * @author Code Duck
 * @since 2022-06-16
 */
public interface RouteService extends IService<Route> {
    /**
     * 根据参数列表查询路线信息
     *
     * @param route 路线实例（参数列表）
     * @return Route 集合
     */
    List<Route> searchRouteByParams(Route route);
    Page<Route> searchRouteByParamsPaging(int currentPage, int pageNum, Route route);
    /**
     * 根据线路id查询线路详细信息以及线路包含的景点详细信息
     * @param routeId 线路id
     * @return JSON查询结果
     */
    Map<String,Object> searchRouteAndScenicSpotByRouteId(String routeId);
    /**
     * 根据参数列表查询路线数量
     *
     * @param route 路线实例（参数列表）
     * @return int 线路数量
     */
    int routeCountByParams(Route route);


    boolean saveRouteAndScenicSpots(Route route, List<ScenicSpot> scenicSpots);

    boolean saveRouteAndConfig(Route route, String[] scenicSpotId);

    boolean configScenicSpotByRouteId(String routeId,String[] scenicSpotId);

    boolean updateRouteAndConfigScenicSpot(Route route, String[] scenicSpotId);
}
