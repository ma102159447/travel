package com.travel.travel.entity;

import java.io.Serializable;
import java.util.List;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 *  上车线路管理
 * </p>
 *
 * @author Code Duck
 * @since 2022-07-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StationRoute implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private String id;
    /**
     * 用户id
     */
    private String uid;
    /**
     * 标题
     */
    private String title;
    /**
     * 城市编码
     */
    private String cityCode;
    /**
     * 城市名称
     */
    private String cityName;
    /**
     * 概述
     */
    private String content;

    /**
     * 逻辑删除
     */
    private Integer flag;

    @TableField(exist = false)
    private List<StationInformation>  stationInformationList;

}
