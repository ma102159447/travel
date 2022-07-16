package com.travel.travel.service;

import com.travel.travel.entity.SafetyTips;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * InnoDB free: 4096 kB 服务类
 * </p>
 *
 * @author Code Duck
 * @since 2022-06-13
 */
public interface SafetyTipsService extends IService<SafetyTips> {
    /**
     * 根据参数获得安全提示
     * @param params  SafetyTips实例对象
     * @return SafetyTips 安全提示信息
     */
    List<SafetyTips> getSafetyTipsByParams(SafetyTips params);

    /**
     * 根据当前登录用户查询安全提示，如果当前用户没有编辑过安全提示则返回系统默认安全提示
     * @param userId 当前登录用户id
     * @return SafetyTips实例
     */
    SafetyTips getSafetyTipsByUser(String userId);

}
