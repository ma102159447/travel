package com.travel.travel.controller;


import com.travel.travel.service.SysCityService;
import com.travel.travel.util.ReturnUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 城市接口
 * </p>
 *
 * @author Code Duck
 * @since 2022-07-04
 */
@RestController
@RequestMapping("/sys-city")
public class SysCityController {
    @Autowired
    SysCityService sysCityService;

    /**
     * 获得所有根城市
     *
     * @return <p>JSON字符串<p/><p>code状态码<p/><p>msg 提示信息 data<p/>  <p>SysCity集合数据</p>
     */
    @RequestMapping("getParent")
    public Object getParent() {
        return ReturnUtil.createReturnUtil(200, "", sysCityService.getParent());
    }

    /**
     * 根据父节点城市编码获得所有子城市
     *
     * @param code 父城市code国标编码
     * @return <p>JSON字符串<p/><p>code状态码<p/><p>msg 提示信息 data<p/>  <p>SysCity集合数据</p>
     */
    @RequestMapping("getByParentCode")
    public Object getByParentCode(String code) {
        return ReturnUtil.createReturnUtil(200, "", sysCityService.getByParentCode(code));
    }

    /**
     * 获得省市的树形结构
     *
     * @return
     */
    @RequestMapping("getTreeOfCity")
    public Object getTreeOfCity() {
        try {
            return ReturnUtil.createReturnUtil(200, "", sysCityService.getTreeOfCity());
        } catch (Exception e) {
            return ReturnUtil.createReturnUtil(500, "服务器繁忙请稍后再试", null);
        }
    }
    /**
     * 获得省市区的树形结构
     *
     * @return
     */
    @RequestMapping("getTree")
    public Object getTree() {
        try {
            return ReturnUtil.createReturnUtil(200, "", sysCityService.getTree());
        } catch (Exception e) {
            return ReturnUtil.createReturnUtil(500, "服务器繁忙请稍后再试", null);
        }
    }
}
