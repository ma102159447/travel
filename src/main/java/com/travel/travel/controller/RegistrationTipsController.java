package com.travel.travel.controller;


import com.travel.travel.entity.RegistrationTips;
import com.travel.travel.service.RegistrationTipsService;
import com.travel.travel.util.ReturnUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * InnoDB free: 4096 kB 报名提示前端控制器
 * </p>
 *
 * @author Code Duck
 * @since 2022-06-13
 */
@RestController
@RequestMapping("/registration-tips")
public class RegistrationTipsController {

    @Autowired
    RegistrationTipsService registrationTipsService;
    /**
     * 根据当前登录用户获得报名提示信息，如果当前登录用户没有编辑过报名提示信息则返回系统默认信息
     *
     * @param userId 当前登录用户id
     * @return RegistrationTips  JSON字符串
     */
    @RequestMapping("getRegistrationTipsByUser")
    public ReturnUtil getRegistrationTipsByUser(String userId){
        return ReturnUtil.createReturnUtil(200,"查询成功",registrationTipsService.getRegistrationTipsByUser(userId));
    }
    /**
     * 保存报名提示信息，新增修改都可以调用此方法
     * @param registrationTips RegistrationTips实例对象
     * @return Object
     */
    @RequestMapping("saveOrUpdateRegistrationTips")
    public ReturnUtil saveOrUpdateRegistrationTips( RegistrationTips registrationTips){
        return registrationTipsService.saveOrUpdate(registrationTips)?
                ReturnUtil.createReturnUtil(200,"保存成功",null):
                ReturnUtil.createReturnUtil(500,"保存失败",null);
    }
}
