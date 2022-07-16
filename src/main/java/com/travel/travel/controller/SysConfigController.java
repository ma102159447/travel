package com.travel.travel.controller;


import com.travel.travel.entity.SysConfig;
import com.travel.travel.service.SysConfigService;
import com.travel.travel.util.ReturnUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * InnoDB free: 4096 kB 前端控制器
 * </p>
 *
 * @author Code Duck
 * @since 2022-06-14
 */
@RestController
@RequestMapping("/sys-config")
public class SysConfigController {
    @Autowired
    SysConfigService sysConfigService;

    /**
     * 查询系统配置
     * @param sysConfig SysConfig实例对象
     * @return SysConfig   JSON字符串
     */
    @RequestMapping("getSysConfig")
    public ReturnUtil getSysConfig(SysConfig sysConfig){
        return ReturnUtil.createReturnUtil(200,"查询成功",sysConfigService.getSysConfig(sysConfig));
    }

    /**
     * 保存系统配置，添加修改都可以调用此方法
     * @param sysConfig SysConfig实例对象
     * @return 保存信息JSON
     */
    @RequestMapping("saveSysConfig")
    public ReturnUtil saveSysConfig(SysConfig sysConfig){
        return sysConfigService.saveOrUpdate(sysConfig)?
                ReturnUtil.createReturnUtil(200,"保存成功",null):
                ReturnUtil.createReturnUtil(500,"保存失败",null);
    }
}
