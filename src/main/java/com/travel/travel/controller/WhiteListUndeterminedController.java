package com.travel.travel.controller;


import com.travel.travel.entity.WhiteListUndetermined;
import com.travel.travel.entity.ext.WhiteListUndeterminedExt;
import com.travel.travel.service.WhiteListUndeterminedService;
import com.travel.travel.util.ReturnUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * InnoDB free: 4096 kB 白名单待定前端控制器
 * </p>
 *
 * @author Code Duck
 * @since 2022-06-16
 */
@RestController
@RequestMapping("/white-list-undetermined")
public class WhiteListUndeterminedController {
    @Autowired
    WhiteListUndeterminedService whiteListUndeterminedService;

    /**
     * 添加白名单待定
     * @param whiteListUndetermined WhiteListUndetermined实例
     * @return Object
     */
    @RequestMapping("saveWhiteList")
    public ReturnUtil saveWhiteList(WhiteListUndetermined whiteListUndetermined) {
            switch (whiteListUndeterminedService.saveWhiteListUndetermined(whiteListUndetermined)) {
                case 200:
                    return ReturnUtil.createReturnUtil(200, "保存成功", null);
                case 500:
                    return ReturnUtil.createReturnUtil(500, "保存失败，请稍后再试", null);
                case 501:
                    return ReturnUtil.createReturnUtil(501, "保存失败，该用户已经在您的黑名单列表", null);
                default:
                    return ReturnUtil.createReturnUtil(502, "系统繁忙请稍后再试", null);
            }
    }

    /**
     * 根据id删除白名单待定用户
     * @param id 主键
     * @return Object
     */
    @RequestMapping("removeById")
    public ReturnUtil removeById(String id) {
        return whiteListUndeterminedService.removeById(id)!=0?
                ReturnUtil.createReturnUtil(200, "删除成功", null):
                ReturnUtil.createReturnUtil(500, "删除失败", null);
    }

    /**
     * 根据当前登录用户id和白名单用户id删除待定白名单
     * @param userId 当前登录用户id
     * @param whiteListUserId  白名单用户id
     * @return  Object
     */
    @RequestMapping("removeByUserId")
    public ReturnUtil removeByUserId(String userId, String whiteListUserId) {
        return whiteListUndeterminedService.removeByUserId(userId,whiteListUserId)!=0?
                ReturnUtil.createReturnUtil(200, "删除成功", null):
                ReturnUtil.createReturnUtil(500, "删除失败", null);
    }

    /**
     * 清空当前登录用户白名单列表
     * @param userId 当前登录用户id
     * @return JSON字符串
     */
    @RequestMapping("clearByUserId")
    public ReturnUtil clearByUserId(String userId){
        return whiteListUndeterminedService.clearByUserId(userId)!=0?
                ReturnUtil.createReturnUtil(200, "清除成功", null):
                ReturnUtil.createReturnUtil(500, "清除失败", null);
    }

    /**
     * 根据登录用户id获得白名单待定列表（分页）
     * @param currentPage 当前页码
     * @param pageCount 每页显示数据条数
     * @param userId 根据登录用户id获得白名单列表
     * @return Object    JSON字符串  data：WhiteList 分页信息和数据
     */
    @RequestMapping("getWhiteListByUserId")
    public ReturnUtil getWhiteListByUserId(int currentPage,int pageCount,String userId){
        return ReturnUtil.createReturnUtil(200, "查询成功", whiteListUndeterminedService.getWhiteListUndeterminedByUserId(currentPage,pageCount,userId));
    }
}
