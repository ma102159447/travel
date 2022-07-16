package com.travel.travel.entity;

import java.util.Date;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 路线
 * </p>
 *
 * @author Code Duck
 * @since 2022-06-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Route implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * id主键
     */
    private String id;
    /**
     * 用户id
     */
    private String userId;
    /**
     * 标题
     */
    private String title;
    /**
     * 内容
     */
    private String content;
    /**
     * 创建时间
     */
    private Date createtime;
    /**
     * 最后修改时间
     */
    private Date updatetime;
    /**
     * 视频
     */
    private String video;
    /**
     * 删除标识符
     */
    private Integer flag;


}
