package com.travel.travel.service;

import com.travel.travel.entity.EquipmentTips;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * InnoDB free: 4096 kB 服务类
 * </p>
 *
 * @author Code Duck
 * @since 2022-06-13
 */
public interface EquipmentTipsService extends IService<EquipmentTips> {
    /**
     * 根据当前登录用户获得装备建议，如果当前登录用户没有编辑过装备建议信息则返回系统默认信息
     * @param userId 当前登录用户id
     * @return EquipmentTips 实例对象
     */
    EquipmentTips getEquipmentTipsByUser(String userId);
}
