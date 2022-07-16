package com.travel.travel.controller;


import com.travel.travel.entity.RiskTips;
import com.travel.travel.service.RiskTipsService;
import com.travel.travel.util.ReturnUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * InnoDB free: 4096 kB 风险提示前端控制器
 * </p>
 *
 * @author Code Duck
 * @since 2022-06-13
 */
@RestController
@RequestMapping("/risk-tips")
public class RiskTipsController {
    @Autowired
    RiskTipsService riskTipsService;
    /**
     * 根据当前登录用户查风险提示，如果当前用户没有编辑过风险提示则返回系统默认风险提示
     *
     * @param userId 当前登录用户id
     * @return SafetyTips实例
     */
    @RequestMapping("getRiskTipsByUser")
    public ReturnUtil getRiskTipsByUser(String userId){
        return ReturnUtil.createReturnUtil(200,"查询成功",riskTipsService.getRiskTipsByUser(userId));
    }

    /**
     * 保存风险提示，新增修改都可以调用此方法
     * @param riskTips RiskTips实例对象
     * @return Object
     */
    @RequestMapping("saveOrUpdateRiskTips")
    public ReturnUtil saveOrUpdateRiskTips(RiskTips riskTips){
        return riskTipsService.saveOrUpdate(riskTips)?
                ReturnUtil.createReturnUtil(200,"保存成功",null):
                ReturnUtil.createReturnUtil(500,"保存失败",null);
    }
}
