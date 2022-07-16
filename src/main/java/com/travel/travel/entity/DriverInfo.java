package com.travel.travel.entity;

import java.math.BigDecimal;
import java.util.Date;
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
public class DriverInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private String id;

    /**
     * 添加用户id
     */
    private String userId;

    /**
     * 创建时间
     */
    private Date createtime;

    /**
     * 最后修改时间
     */
    private Date updatetime;

    /**
     * 姓名
     */
    private String name;

    /**
     * 电话
     */
    private String phone;

    /**
     * 驾龄
     */
    private BigDecimal drivingAge;

    /**
     * 备注
     */
    private String remark;

    /**
     * 删除标志
     */
    private Integer flag;


}
