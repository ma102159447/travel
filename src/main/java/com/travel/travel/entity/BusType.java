package com.travel.travel.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * InnoDB free: 4096 kB
 * </p>
 *
 * @author Code Duck
 * @since 2022-06-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class BusType implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    /**
     * 座位模板
     */
    private String seatTemplate;

    /**
     * 车型名称，简称，描述
     */
    private String name;

    /**
     * 车辆品牌
     */
    private String brand;

    /**
     * 座位数量
     */
    private Integer seatnum;

    /**
     * 删除标志
     */
    private Integer flag;


}
