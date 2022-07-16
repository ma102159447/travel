package com.travel.travel.controller;


import com.travel.travel.entity.EquipmentTips;
import com.travel.travel.service.EquipmentTipsService;
import com.travel.travel.util.ReturnUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * InnoDB free: 4096 kB 装备建议前端控制器
 * </p>
 *
 * @author Code Duck
 * @since 2022-06-13
 */
@RestController
@RequestMapping("/equipment-tips")
public class EquipmentTipsController {
    @Autowired
    EquipmentTipsService equipmentTipsService;
    /**
     * 根据当前登录用户获得装备建议，如果当前登录用户没有编辑过装备建议信息则返回系统默认信息
     *
     * @param userId 当前登录用户id
     * @return EquipmentTips  JSON字符串
     */
    @RequestMapping("getEquipmentTipsByUser")
    public ReturnUtil getEquipmentTipsByUser(String userId){
        return ReturnUtil.createReturnUtil(200,"查询成功",equipmentTipsService.getEquipmentTipsByUser(userId));
    }
    /**
     * 保存装备建议信息，新增修改都可以调用此方法
     * @param equipmentTips EquipmentTips实例对象
     * @return Object
     */
    @RequestMapping("saveOrUpdateEquipmentTips")
    public ReturnUtil saveOrUpdateEquipmentTips( EquipmentTips equipmentTips){
        return equipmentTipsService.saveOrUpdate(equipmentTips)?
                ReturnUtil.createReturnUtil(200,"保存成功",null):
                ReturnUtil.createReturnUtil(500,"保存失败",null);
    }
}
