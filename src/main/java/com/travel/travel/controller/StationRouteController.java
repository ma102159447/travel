package com.travel.travel.controller;


import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.travel.travel.entity.StationInformation;
import com.travel.travel.entity.StationRoute;
import com.travel.travel.service.StationInformationService;
import com.travel.travel.service.StationRouteService;
import com.travel.travel.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  上车线路管理
 * </p>
 *
 * @author Code Duck
 * @since 2022-07-19
 */
@RestController
@RequestMapping("/station-route")
public class StationRouteController {
    @Autowired
    StationRouteService stationRouteService;
    @Autowired
    StationInformationService stationInformationService;

    /**
     * 根据参数获得上车线路列表
     * @param data
     * @return
     */
    @PostMapping("getList")
    public R<List<StationRoute>> getList(String data){
        StationRoute stationRoute = JSON.parseObject(data, StationRoute.class);
        try {
            QueryWrapper<StationRoute> queryWrapper = new QueryWrapper<>(stationRoute);
            return R.success(stationRouteService.list(queryWrapper));
        } catch (Exception e) {
            return R.error("查询异常");
        }
    }

    /**
     * 根据id获得上车线路信息以及线路下的站点信息
     * @param id
     * @return
     */
    @PostMapping("getStationRouteById")
    public R<StationRoute> getStationRouteById(String id){
        try {
            return R.success(stationRouteService.getStationRouteById(id));
        } catch (Exception e) {
            return R.error("查询异常");
        }
    }

    /**
     * 添加上车线路信息以及上车线路站点
     * @param data
     * @return
     */
    @PostMapping("insertStationRoute")
    public R<String> insertStationRoute(String data){

        try {
            StationRoute stationRoute = JSON.parseObject(data ,StationRoute.class);
            List<StationInformation> stationInformationList = JSON.parseObject(JSON.parseObject(data).getJSONArray("stationInformationList").toJSONString(),List.class);
            stationRoute.setStationInformationList(stationInformationList);
            return stationRouteService.insertStationRoute(stationRoute)?R.success(null):R.error("添加失败");
        } catch (Exception e) {
            return R.error("添加异常");
        }
    }

    /**
     * 更新线路信息以及景点信息
     * @param data
     * @return
     */
    @PostMapping("updateStationRouteById")
    public R<String> updateStationRouteById(String data){
        try {
            StationRoute stationRoute = JSON.parseObject(data ,StationRoute.class);
            List<StationInformation> stationInformationList = JSON.parseObject(JSON.parseObject(data).getJSONArray("stationInformationList").toJSONString(),List.class);
            stationRoute.setStationInformationList(stationInformationList);
            return stationRouteService.updateStationRouteById(stationRoute)?R.success("success"):R.error("修改失败");
        } catch (Exception e) {
            return R.error("系统异常");
        }
    }

    /**
     * 删除一条上车线路
     * @param id
     * @return
     */
    @PostMapping("deleteStationRouteById")
    public R<String> deleteStationRouteById(String id){
        try {
            return stationRouteService.removeById(id)?R.success("success"):R.error("删除失败");
        } catch (Exception e) {
            return R.error("系统异常");
        }
    }

    /**
     * 删除一个线路下的站点
     * @param id
     * @return
     */
    @PostMapping("deleteStationInformationById")
    public R<String> deleteStationInformationById(String id){
        try {
            return stationInformationService.deleteById(id)?R.success("success"):R.error("删除失败");
        } catch (Exception e) {
            return R.error("系统异常");
        }
    }
}
