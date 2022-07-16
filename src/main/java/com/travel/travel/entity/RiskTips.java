package com.travel.travel.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 风险提示
 * </p>
 *
 * @author Code Duck
 * @since 2022-06-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class RiskTips implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 用户id（主键）
     */
    @TableId
    private String userId;
    /**
     * 风险提示内容
     */
    private String content;


}
