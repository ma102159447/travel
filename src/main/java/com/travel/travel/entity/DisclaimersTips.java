package com.travel.travel.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 免责声明
 * </p>
 *
 * @author majinliang
 * @since 2022-06-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class DisclaimersTips implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 添加用户id(主键)
     */
    @TableId
    private String userId;
    /**
     *免责说明内容
     */
    private String content;


}
