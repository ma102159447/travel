package com.travel.travel.service;

import com.travel.travel.entity.RescueTips;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * InnoDB free: 4096 kB 服务类
 * </p>
 *
 * @author Code Duck
 * @since 2022-06-13
 */
public interface RescueTipsService extends IService<RescueTips> {
    /**
     * 根据当前登录用户获得救援提示信息，如果当前登录用户没有编辑过救援提示信息则返回系统默认信息
     * @param userId 当前用户id
     * @return RescueTips 救援提示
     */
    RescueTips getRescueTipsByUser(String userId);
}
