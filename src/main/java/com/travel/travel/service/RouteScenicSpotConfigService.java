package com.travel.travel.service;

import com.travel.travel.entity.Route;
import com.travel.travel.entity.RouteScenicSpotConfig;
import com.baomidou.mybatisplus.extension.service.IService;
import com.travel.travel.entity.ext.RouteScenicSpotConfigExt;

import java.util.List;

/**
 * <p>
 * InnoDB free: 4096 kB 服务类
 * </p>
 *
 * @author Code Duck
 * @since 2022-06-16
 */
public interface RouteScenicSpotConfigService extends IService<RouteScenicSpotConfig> {
    /**
     * 修改线路景点配置
     *
     * @param routeScenicSpotConfigs 新的线路景点配置集合
     * @return boolean修改结果
     */
    boolean updateRouteScenicSpotConfigs(List<RouteScenicSpotConfig> routeScenicSpotConfigs);

    /**
     * 根据线路id查询该线路下景点详细信息
     *
     * @param routeId 线路id
     * @return RouteScenicSpotConfigExt 线路下景点详细信息集合
     */
    List<RouteScenicSpotConfigExt> searchRouteScenicSpotConfigByRouteId(String routeId);

    /**
     * 根据参数列表查询线路景点配置数量
     *
     * @param routeScenicSpotConfig 实例对象（参数列表）
     * @return int 查询数量
     */
    int searchRouteScenicSpotConfigCountByParams(RouteScenicSpotConfig routeScenicSpotConfig);

}
