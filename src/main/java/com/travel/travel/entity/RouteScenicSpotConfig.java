package com.travel.travel.entity;

import java.io.Serializable;

import io.swagger.annotations.Api;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 路线包含的景点
 * </p>
 *
 * @author Code Duck
 * @since 2022-06-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class RouteScenicSpotConfig implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 主键id
     */
    private String id;
    /**
     * 路线id
     */
    private String routeId;
    /**
     * 景点id
     */
    private String scenicSpotId;
    /**
     * 排序
     */
    private Integer orderNum;


}
