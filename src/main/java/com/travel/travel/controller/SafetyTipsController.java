package com.travel.travel.controller;


import com.travel.travel.entity.SafetyTips;
import com.travel.travel.service.SafetyTipsService;
import com.travel.travel.util.ReturnUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * InnoDB free: 4096 kB 安全提示(小贴士)前端控制器
 * </p>
 *
 * @author Code Duck
 * @since 2022-06-13
 */
@RestController
@RequestMapping("/safety-tips")
public class SafetyTipsController {
    @Autowired
    SafetyTipsService safetyTipsService;

    /**
     * 根据参数获得安全提示
     * @param safetyTips SafetyTips实例（参数列表）
     * @return Object JSON字符串
     */
    @RequestMapping("getSafetyTipsByParams")
    public ReturnUtil getSafetyTipsByParams(SafetyTips safetyTips){
        return ReturnUtil.createReturnUtil(200,"查询成功",safetyTipsService.getSafetyTipsByParams(safetyTips));
    }
    /**
     * 根据当前登录用户查询安全提示，如果当前用户没有编辑过安全提示则返回系统默认安全提示
     *
     * @param userId 当前登录用户id
     * @return SafetyTips实例
     */
    @RequestMapping("getSafetyTipsByUser")
    public ReturnUtil getSafetyTipsByUser(String userId){
        return ReturnUtil.createReturnUtil(200,"查询成功",safetyTipsService.getSafetyTipsByUser(userId));
    }

    /**
     * 保存安全提示，新增修改都可以调用此方法
     * @param safetyTips SafetyTips实例对象
     * @return Object JSON字符串
     */
    @RequestMapping("saveOrUpdateSafetyTips")
    public ReturnUtil saveOrUpdateSafetyTips(SafetyTips safetyTips){
        return safetyTipsService.saveOrUpdate(safetyTips)?
                ReturnUtil.createReturnUtil(200,"保存成功",null):
                ReturnUtil.createReturnUtil(500,"保存失败",null);
    }
}
