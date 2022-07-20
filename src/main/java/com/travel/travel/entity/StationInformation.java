package com.travel.travel.entity;

import java.util.Date;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 上车线路详细
 * </p>
 *
 * @author Code Duck
 * @since 2022-07-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class StationInformation implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private String id;
    /**
     * 上车线路概述主键
     */
    private String srId;
    /**
     * 省
     */
    private String province;

    /**
     * 市
     */
    private String city;

    /**
     * 区县
     */
    private String county;

    /**
     * 到站时间
     */
    private String arrivalTime;

    /**
     * 站点名称描述
     */
    private String content;


}
