package com.travel.travel.controller;


import com.travel.travel.entity.BusType;
import com.travel.travel.service.BusTypeService;
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
 * @since 2022-06-16
 */
@RestController
@RequestMapping("/bus-type")
public class BusTypeController {
    @Autowired
    BusTypeService busTypeService;

    /**
     * 保存/修改 车辆类型信息
     * @param busType 车辆类型实例
     * @return JSON 保存结果
     */
    @RequestMapping("saveOrUpdateBusType")
    public ReturnUtil saveOrUpdateBusType(BusType busType){
        return  busTypeService.saveOrUpdate(busType)?
                ReturnUtil.createReturnUtil(200,"保存成功",null):
                ReturnUtil.createReturnUtil(500,"保存失败",null);
    }

    /**
     * 根据参数列表查询车辆类型信息
     * @param busType 车辆类型实例（参数列表）
     * @return JSON 查询结果
     */
    @RequestMapping("searchBusTypes")
    public ReturnUtil searchBusTypes(BusType busType){
        return ReturnUtil.createReturnUtil(200,"查询成功",busTypeService.searchBusTypes(busType));
    }
    /**
     * 根据参数列表查询车辆类型信息(分页)
     * @param currentPage 当前页码
     * @param pageCount 每页显示数量
     * @param busType 车辆类型实例（参数列表）
     * @return JSON 查询结果
     */
    @RequestMapping("searchBusTypesByPages")
    public ReturnUtil searchBusTypesByPages(int currentPage,int pageCount,BusType busType){
        return ReturnUtil.createReturnUtil(200,"查询成功",busTypeService.searchBusTypes(currentPage,pageCount,busType));
    }

    /**
     * 根据id删除车辆类型信息
     * @param id 主键
     * @return JSON 删除结果
     */
    @RequestMapping("removeBusTypeById")
    public ReturnUtil removeBusTypeById(String id){
        return  busTypeService.removeBusTypeById(id)?
                ReturnUtil.createReturnUtil(200,"删除成功",null):
                ReturnUtil.createReturnUtil(500,"删除失败",null);
    }
}
