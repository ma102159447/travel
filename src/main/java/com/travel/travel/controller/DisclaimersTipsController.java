package com.travel.travel.controller;


import com.travel.travel.entity.DisclaimersTips;
import com.travel.travel.service.DisclaimersTipsService;
import com.travel.travel.util.ReturnUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * InnoDB free: 4096 kB 免责声明前端控制器
 * </p>
 *
 * @author Code Duck
 * @since 2022-06-16
 */
@RestController
@RequestMapping("/disclaimers-tips")
public class DisclaimersTipsController {
    @Autowired
    DisclaimersTipsService disclaimersTipsService;
    /**
     * 根据当前登录用户获得免责声明，如果当前登录用户没有编辑过免责声明信息则返回系统默认信息
     *
     * @param userId 当前登录用户id
     * @return DisclaimersTips  JSON字符串
     */
    @RequestMapping("getDisclaimersTipsByUser")
    public ReturnUtil getDisclaimersTipsByUser(String userId){
        return ReturnUtil.createReturnUtil(200,"查询成功",disclaimersTipsService.getDisclaimersTipsByUser(userId));
    }
    /**
     * 保存免责声明信息，新增修改都可以调用此方法
     * @param disclaimersTips DisclaimersTips实例对象
     * @return Object
     */
    @RequestMapping("saveOrUpdateDisclaimersTips")
    public ReturnUtil saveOrUpdateDisclaimersTips(DisclaimersTips disclaimersTips){
        return disclaimersTipsService.saveOrUpdate(disclaimersTips)?
                ReturnUtil.createReturnUtil(200,"保存成功",null):
                ReturnUtil.createReturnUtil(500,"保存失败",null);
    }
}
