package com.travel.travel.mapper;

import com.travel.travel.entity.RouteScenicSpotConfig;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.travel.travel.entity.ext.RouteScenicSpotConfigExt;

import java.util.List;

/**
 * <p>
 * InnoDB free: 4096 kB Mapper 接口
 * </p>
 *
 * @author Code Duck
 * @since 2022-06-16
 */
public interface RouteScenicSpotConfigMapper extends BaseMapper<RouteScenicSpotConfig> {
    List<RouteScenicSpotConfigExt> searchRouteScenicSpotConfigByRouteId(String routeId);
}
