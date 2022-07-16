package com.travel.travel.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * InnoDB free: 11264 kB
 * </p>
 *
 * @author Code Duck
 * @since 2022-07-04
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode(callSuper = false)
public class SysCity implements Serializable {

    private static final long serialVersionUID = 1L;

    private String code;

    private String name;

    @TableField("parentCode")
    private String parentcode;

    private Integer flag;

    private List<SysCity> children;


}
