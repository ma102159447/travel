package com.travel.travel.controller;


import com.travel.travel.entity.RouteScenicSpotConfig;
import com.travel.travel.service.RouteScenicSpotConfigService;
import com.travel.travel.util.ReturnUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping("/route-scenic-spot-config")
public class RouteScenicSpotConfigController {
    @Autowired
    RouteScenicSpotConfigService routeScenicSpotConfigService;

    /**
     * 批量添加景点配置列表
     * @param routeScenicSpotConfigs
     * @return
     */
    @RequestMapping("saveRouteScenicSpotConfigs")
    public ReturnUtil saveRouteScenicSpotConfigs(List<RouteScenicSpotConfig> routeScenicSpotConfigs) {
        return routeScenicSpotConfigService.saveBatch(routeScenicSpotConfigs) ?
                ReturnUtil.createReturnUtil(200, "保存成功", null) :
                ReturnUtil.createReturnUtil(500, "保存失败", null);
    }

    @RequestMapping("updateRouteScenicSpotConfigs")
    public ReturnUtil updateRouteScenicSpotConfigs(List<RouteScenicSpotConfig> routeScenicSpotConfigs) {
        return routeScenicSpotConfigService.updateRouteScenicSpotConfigs(routeScenicSpotConfigs) ?
                ReturnUtil.createReturnUtil(200, "修改成功", null) :
                ReturnUtil.createReturnUtil(500, "修改失败", null);
    }

    @RequestMapping("removeRouteScenicSpotConfigById")
    public ReturnUtil removeRouteScenicSpotConfigById(String id) {
        return routeScenicSpotConfigService.removeById(id) ?
                ReturnUtil.createReturnUtil(200, "删除成功", null) :
                ReturnUtil.createReturnUtil(500, "删除失败", null);
    }

    /**
     * 根据线路id查询该线路下景点详细信息
     *
     * @param routeId 线路id
     * @return JSON 查询结果
     */
    @RequestMapping("searchRouteScenicSpotConfigByRouteId")
    public ReturnUtil searchRouteScenicSpotConfigByRouteId(String routeId) {
        return ReturnUtil.createReturnUtil(200, "查询成功", routeScenicSpotConfigService.searchRouteScenicSpotConfigByRouteId(routeId));
    }

    /**
     * 根据参数列表查询线路景点配置数量
     *
     * @param routeScenicSpotConfig 实例对象（参数列表）
     * @return 查询数量
     */
    @RequestMapping("searchRouteScenicSpotConfigCountByParams")
    public int searchRouteScenicSpotConfigCountByParams(RouteScenicSpotConfig routeScenicSpotConfig) {
        return routeScenicSpotConfigService.searchRouteScenicSpotConfigCountByParams(routeScenicSpotConfig);
    }
}
