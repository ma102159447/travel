package com.travel.travel.service;

import com.travel.travel.entity.RiskTips;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * InnoDB free: 4096 kB 服务类
 * </p>
 *
 * @author Code Duck
 * @since 2022-06-13
 */
public interface RiskTipsService extends IService<RiskTips> {
    /**
     * 根据当前登录用户查询风险提示，如果当前用户没有编辑过风险提示则返回系统默认安全提示
     * @param userId 当前登录用户id
     * @return RiskTips实例
     */
    RiskTips getRiskTipsByUser(String userId);
}
