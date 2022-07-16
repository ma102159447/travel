package com.travel.travel.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 黑名单类
 * </p>
 *
 * @author majinliang
 * @since 2022-06-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class BlackList implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 主键id
     */
    private String id;
    /**
     * 添加黑名单用户
     */
    private String insertUserId;
    /**
     * 被添加黑名单用户
     */
    private String blacklistUserId;


}
