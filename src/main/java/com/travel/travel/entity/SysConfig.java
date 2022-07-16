package com.travel.travel.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 系统配置
 * </p>
 *
 * @author Code Duck
 * @since 2022-06-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SysConfig implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 主键id
     */
    private String id;
    /**
     * 标题
     */
    private String title;
    /**
     * 编码（字段）
     */
    private String field;
    /**
     * 值
     */
    private String value;


}
