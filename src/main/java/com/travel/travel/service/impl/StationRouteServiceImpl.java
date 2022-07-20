package com.travel.travel.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.travel.travel.entity.StationInformation;
import com.travel.travel.entity.StationRoute;
import com.travel.travel.mapper.StationRouteMapper;
import com.travel.travel.service.StationInformationService;
import com.travel.travel.service.StationRouteService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 上车线路管理
 * </p>
 *
 * @author Code Duck
 * @since 2022-07-19
 */
@Service
public class StationRouteServiceImpl extends ServiceImpl<StationRouteMapper, StationRoute> implements StationRouteService {
    @Autowired
    StationInformationService stationInformationService;

    /**
     * 查询上车线路信息及其站点信息
     *
     * @param id 主键id
     * @return
     */
    @Override
    public StationRoute getStationRouteById(String id) {
        StationRoute stationRoute = this.getById(id);
        LambdaQueryWrapper<StationInformation> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(StationInformation::getSrId, id);
        queryWrapper.orderByAsc(StationInformation::getArrivalTime);
        stationRoute.setStationInformationList(stationInformationService.list(queryWrapper));
        return stationRoute;
    }

    /**
     * 添加上车线路及其站点信息
     *
     * @param stationRoute 实例
     * @return
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean insertStationRoute(StationRoute stationRoute) {
        if (this.save(stationRoute)){
            return  stationInformationService.saveBatch(stationRoute.getStationInformationList());

        }
        return false;
    }

    /**
     * 修改上车线路及其站点id
     *
     * @param stationRoute
     * @return
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean updateStationRouteById(StationRoute stationRoute) {
        if(stationRoute==null && stationRoute.getId()==null && ("").equals(stationRoute.getId())&&("null").equalsIgnoreCase(stationRoute.getId())){
            return false;
        }
        if(this.updateById(stationRoute)){
            return stationInformationService.updateBatchById(stationRoute.getStationInformationList());
        }

        return false;
    }
}
