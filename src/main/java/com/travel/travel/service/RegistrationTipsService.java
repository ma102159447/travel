package com.travel.travel.service;

import com.travel.travel.entity.RegistrationTips;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * InnoDB free: 4096 kB 服务类
 * </p>
 *
 * @author Code Duck
 * @since 2022-06-13
 */
public interface RegistrationTipsService extends IService<RegistrationTips> {
    /**
     * 根据当前登录用户获得报名提示，如果当前登录用户没有编辑过报名提示信息则返回系统默认信息
     * @param userId 当前登录用户id
     * @return RegistrationTips 实例对象
     */
    RegistrationTips getRegistrationTipsByUser(String userId);
}
