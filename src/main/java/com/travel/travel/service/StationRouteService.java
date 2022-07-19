package com.travel.travel.service;

import com.travel.travel.entity.StationRoute;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Code Duck
 * @since 2022-07-19
 */
public interface StationRouteService extends IService<StationRoute> {

    StationRoute getStationRouteById(String id);

    boolean insertStationRoute(StationRoute stationRoute);

    boolean updateStationRouteById(StationRoute stationRoute);
}
