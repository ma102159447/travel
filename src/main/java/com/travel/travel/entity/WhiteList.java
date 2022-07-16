package com.travel.travel.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 白名单
 * </p>
 *
 * @author Code Duck
 * @since 2022-06-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class WhiteList implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 主键id
     */
    private String id;
    /**
     * 添加白名单用户id
     */
    private String insertUserId;
    /**
     * 被添加白名单用户id
     */
    private String whitelistUserId;


}
