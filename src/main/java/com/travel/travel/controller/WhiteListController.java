package com.travel.travel.controller;


import com.travel.travel.entity.WhiteList;
import com.travel.travel.service.WhiteListService;
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
@RequestMapping("/white-list")
public class WhiteListController {
    @Autowired
    WhiteListService whiteListService;

    /**
     * 添加白名单
     * @param WhiteList WhiteList实例
     * @return Object
     */
    @RequestMapping("saveWhiteList")
    public ReturnUtil saveWhiteList(WhiteList WhiteList) {
        switch (whiteListService.saveWhiteList(WhiteList)) {
            case 200:
                return ReturnUtil.createReturnUtil(200, "保存成功", null);
            case 500:
                return ReturnUtil.createReturnUtil(500, "保存失败，请稍后再试", null);
            case 501:
                return ReturnUtil.createReturnUtil(501, "保存失败，该用户已经在您的白名单列表", null);
            case 502:
                return ReturnUtil.createReturnUtil(502, "当前登录用户信息异常请重新登录", null);
            case 503:
                return ReturnUtil.createReturnUtil(503, "您添加的用户信息不存在，请稍后再试", null);
            default:
                return ReturnUtil.createReturnUtil(599, "系统繁忙请稍后再试", null);
        }
    }


    /**
     * 根据id删除白名单用户
     * @param id 主键
     * @return Object
     */
    @RequestMapping("removeById")
    public ReturnUtil removeById(String id) {
        return whiteListService.removeById(id)!=0?
                ReturnUtil.createReturnUtil(200, "删除成功", null):
                ReturnUtil.createReturnUtil(500, "删除失败", null);
    }

    /**
     * 根据当前登录用户id和白名单用户id删除白名单
     * @param userId 当前登录用户id
     * @param whiteListUserId  白名单用户id
     * @return  Object
     */
    @RequestMapping("removeByUserId")
    public ReturnUtil removeByUserId(String userId, String whiteListUserId) {
        return whiteListService.removeByUserId(userId,whiteListUserId)!=0?
                ReturnUtil.createReturnUtil(200, "删除成功", null):
                ReturnUtil.createReturnUtil(500, "删除失败", null);
    }
    /**
     * 根据登录用户id获得白名单列表（分页）
     * @param currentPage 当前页码
     * @param pageCount 每页显示数据条数
     * @param userId 根据登录用户id获得白名单列表
     * @return Object    JSON字符串  data：WhiteList 分页信息和数据
     */
    @RequestMapping("getWhiteListByUserId")
    public ReturnUtil getWhiteListByUserId(int currentPage,int pageCount,String userId){
        return ReturnUtil.createReturnUtil(200, "查询成功", whiteListService.getWhiteListByUserId(currentPage,pageCount,userId));
    }
}
