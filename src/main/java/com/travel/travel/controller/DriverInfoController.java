package com.travel.travel.controller;


import com.travel.travel.entity.DriverInfo;
import com.travel.travel.service.DriverInfoService;
import com.travel.travel.util.ReturnUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * <p>
 * InnoDB free: 4096 kB 司机信息前端控制器
 * </p>
 *
 * @author Code Duck
 * @since 2022-06-16
 */
@RestController
@RequestMapping("/driver-info")
public class DriverInfoController {
    @Autowired
    DriverInfoService driverInfoService;

    /**
     * 根据传入参数查询司机信息列表
     *
     * @param driverInfo DriverInfo实例
     * @return JSON字符串
     */
    @RequestMapping("searchDriverInfosByParams")
    public ReturnUtil searchDriverInfosByParams(DriverInfo driverInfo) {
        return ReturnUtil.createReturnUtil(200, "查询成功", driverInfoService.searchDriverInfosByUserId(driverInfo));
    }

    /**
     * 根据传入参数和分页信息查询司机信息列表
     * @param currentPage 当前页码
     * @param pageCount 每页显示数量
     * @param driverInfo DriverInfo实例（参数列表）
     * @return JSON字符串
     */
    @RequestMapping("searchDriverInfosByParamsAndPages")
    public ReturnUtil searchDriverInfosByParamsAndPages(int currentPage, int pageCount, DriverInfo driverInfo) {
        return ReturnUtil.createReturnUtil(200, "查询成功", driverInfoService.searchDriverInfosByUserId(currentPage, pageCount, driverInfo));
    }

    /**
     * 保存司机信息
     * @param driverInfo 司机信息实例
     * @return JSON字符串（保存结果）
     */
    @RequestMapping("addDriverInfo")
    public ReturnUtil addDriverInfo(DriverInfo driverInfo){
        driverInfo.setCreatetime(new Date());
        return driverInfoService.save(driverInfo)?
                ReturnUtil.createReturnUtil(200,"保存成功",null):
                ReturnUtil.createReturnUtil(500,"保存失败",null);
    }

    /**
     * 修改司机信息
     * @param driverInfo 司机信息实例
     * @return JSON字符串（修改结果）
     */
    @RequestMapping("updateDriverInfo")
    public ReturnUtil updateDriverInfo(DriverInfo driverInfo){
        driverInfo.setUpdatetime(new Date());
        return driverInfoService.updateById(driverInfo)?
                ReturnUtil.createReturnUtil(200,"修改成功",null):
                ReturnUtil.createReturnUtil(500,"修改失败",null);
    }

    /**
     * 根据id删除司机信息数据
     * @param id 主键
     * @return JSON字符串（删除结果）
     */
    @RequestMapping("removeDriverInfoById")
    public ReturnUtil removeDriverInfoById(String id){
        return driverInfoService.removeById(id)?
                ReturnUtil.createReturnUtil(200,"删除成功",null):
                ReturnUtil.createReturnUtil(500,"删除失败",null);
    }
}
