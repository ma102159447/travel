package com.travel.travel.controller;


import com.travel.travel.entity.BlackList;
import com.travel.travel.service.BlackListService;
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
@RequestMapping("/black-list")
public class BlackListController {
    @Autowired
    BlackListService blackListService;

    /**
     * 添加黑名单用户
     * @param blackList BlackList实例
     * @return Object
     */
    @RequestMapping("saveBlackList")
    public ReturnUtil saveBlackList(BlackList blackList) {
        switch (blackListService.saveBlackList(blackList)) {
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
     * 根据id删除黑名单
     * @param id 主键
     * @return Object
     */
    @RequestMapping("removeById")
    public ReturnUtil removeById(String id) {
        return blackListService.removeById(id)!=0?
                ReturnUtil.createReturnUtil(200, "删除成功", null):
                ReturnUtil.createReturnUtil(500, "删除失败", null);
    }

    /**
     * 根据当前登录用户和黑名单用户id删除黑名单
     * @param userId  当前登录用户id
     * @param blackListUserId 黑名单用户id
     * @return Object
     */
    @RequestMapping("removeByUserId")
    public ReturnUtil removeByUserId(String userId, String blackListUserId) {
        return blackListService.removeByUserId(userId,blackListUserId)!=0?
                ReturnUtil.createReturnUtil(200, "删除成功", null):
                ReturnUtil.createReturnUtil(500, "删除失败", null);
    }
}
