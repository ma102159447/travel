package com.travel.travel.entity;

import java.util.Date;
import java.io.Serializable;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 景点
 * </p>
 *
 * @author Code Duck
 * @since 2022-06-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ScenicSpot implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private String id;
    /**
     * 用户id
     */
    private String userId;

    /**
     * 景点标题
     */
    private String title;

    /**
     * 图片地址
     */
    private String img;

    /**
     * 图片简介
     */
    private String imgInfo;

    /**
     * 图片地址2
     */
    private String img1;

    /**
     * 图片简介2
     */
    private String img1Info;

    /**
     * 图片地址3
     */
    private String img2;

    /**
     * 图片简介3
     */
    private String img2Info;

    /**
     * 创建时间
     */
    private Date createtime;

    /**
     * 最后修改时间
     */

    private Date updatetime;

    /**
     * 景点视频
     */
    private String video;

    /**
     * 删除标志
     */
    private Integer flag;

    /**
     * 引用计数器
     */
    private Integer count;

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

}
