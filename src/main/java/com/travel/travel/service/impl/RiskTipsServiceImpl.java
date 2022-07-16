package com.travel.travel.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.travel.travel.entity.RiskTips;
import com.travel.travel.mapper.RiskTipsMapper;
import com.travel.travel.service.RiskTipsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * InnoDB free: 4096 kB 服务实现类
 * </p>
 *
 * @author Code Duck
 * @since 2022-06-13
 */
@Service
public class RiskTipsServiceImpl extends ServiceImpl<RiskTipsMapper, RiskTips> implements RiskTipsService {

    /**
     * 根据当前登录用户查询风险提示，如果当前用户没有编辑过风险提示则返回系统默认安全提示
     *
     * @param userId 当前登录用户id
     * @return RiskTips实例
     */
    @Override
    public RiskTips getRiskTipsByUser(String userId) {
        RiskTips riskTips = new RiskTips();
        riskTips.setUserId(userId==null?"":userId);
        QueryWrapper<RiskTips> safetyTipsQueryWrapper = new QueryWrapper<>(riskTips);
        List<RiskTips> queryList = this.list(safetyTipsQueryWrapper);
        if(queryList==null||queryList.isEmpty()){
            riskTips.setUserId("system");
            return this.list(safetyTipsQueryWrapper).get(0);
        }else{
            return queryList.get(0);
        }
    }
}
