package com.travel.travel.service;

import com.travel.travel.entity.DisclaimersTips;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * InnoDB free: 4096 kB 免责声明服务类
 * </p>
 *
 * @author Code Duck
 * @since 2022-06-16
 */
public interface DisclaimersTipsService extends IService<DisclaimersTips> {
    /**
     * 根据当前登录用户获得免责声明，如果当前登录用户没有编辑过免责声明则返回系统默认信息
     * @param userId 当前登录用户id
     * @return DisclaimersTips 实例对象
     */
    DisclaimersTips getDisclaimersTipsByUser(String userId);
}
