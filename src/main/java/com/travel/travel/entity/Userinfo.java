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
 * @since 2022-06-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Userinfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    private String id;

    /**
     * 用户id保留
     */
    private String yid;

    /**
     * 微信用户id微信账号唯一值
     */
    private String wxId;

    /**
     * 头像
     */
    private String avatarUrl;

    /**
     * 性别
     */
    private String gender;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 电话
     */
    private String phone;

    /**
     * 用户名，保留
     */
    private String username;

    /**
     * 用户密码，保留
     */
    private String password;

    /**
     * 身份证号码
     */
    private String idNumber;

    /**
     * 身份证正面
     */
    private String idAvatar;

    /**
     * 身份证国徽面
     */
    private String idEmblem;

    /**
     * 生日
     */
    private String brithday;

    /**
     * 个人简介
     */
    private String briefIntroduction;

    /**
     * 用户级别
     */
    private String leve;

    /**
     * 用户状态
     */
    private String status;

    /**
     * 省
     */
    private String province;

    /**
     * 市
     */
    private String city;

    /**
     * 区
     */
    private String county;

    /**
     * 创建时间
     */
    private String createtime;

    /**
     * 删除标识
     */
    private Integer flag;


}
