package com.travel.travel.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 安全小贴士
 * </p>
 *
 * @author Code Duck
 * @since 2022-06-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SafetyTips implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 主键id
     */
    @TableId
    private String userId;
    /**
     * 安全小贴士内容
     */
    private String content;


}
