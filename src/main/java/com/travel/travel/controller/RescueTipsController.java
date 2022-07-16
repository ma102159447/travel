package com.travel.travel.controller;


import com.travel.travel.entity.RescueTips;
import com.travel.travel.service.RescueTipsService;
import com.travel.travel.util.ReturnUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * InnoDB free: 4096 kB 救援提示信息前端控制器
 * </p>
 *
 * @author Code Duck
 * @since 2022-06-13
 */
@RestController
@RequestMapping("/rescue-tips")
public class RescueTipsController {
    @Autowired
    RescueTipsService rescueTipsService;

    /**
     * 根据当前登录用户获得救援提示信息，如果当前登录用户没有编辑过救援提示信息则返回系统默认信息
     *
     * @param userId 当前登录用户id
     * @return RescueTips  JSON字符串
     */
    @RequestMapping("getRescueTipsByUser")
    public ReturnUtil getRescueTipsByUser(String userId){
        return ReturnUtil.createReturnUtil(200,"查询成功",rescueTipsService.getRescueTipsByUser(userId));
    }

    /**
     * 保存救援信息，新增修改都可以调用此方法
     * @param rescueTips RescueTips实例对象
     * @return Object
     */
    @RequestMapping("saveOrUpdateRescueTips")
    public ReturnUtil saveOrUpdateRescueTips(RescueTips rescueTips){
        return rescueTipsService.saveOrUpdate(rescueTips)?
                ReturnUtil.createReturnUtil(200,"保存成功",null):
                ReturnUtil.createReturnUtil(500,"保存失败",null);
    }
}
