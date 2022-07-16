package com.travel.travel.controller;


import com.alibaba.fastjson.JSONObject;
import com.travel.travel.entity.Userinfo;
import com.travel.travel.service.UserinfoService;
import com.travel.travel.util.ReturnUtil;
import com.travel.travel.util.WxUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * InnoDB free: 4096 kB 前端控制器
 * </p>
 *
 * @author Code Duck
 * @since 2022-06-12
 */
@RestController
@RequestMapping("/userinfo")
public class UserinfoController {
    @Autowired
    UserinfoService userinfoService;

    /**
     * 微信小程序接口
     *
     * @param encryptedData 加密数据
     * @param code          加密代码
     * @param iv            偏移量
     * @return JSON
     */
    @RequestMapping(value = "login", method = {RequestMethod.GET, RequestMethod.POST})
    public Object login(String encryptedData, String code, String iv) {
        //调用微信解密初始化用户数据
        System.out.println(encryptedData + "\n" + code + "\n" + iv);
        Map<String, Object> map = new HashMap<>();
        try {
            //获得微信登录的  openid 和 session_key
            JSONObject sessionJson = WxUtils.getSessionKey(code);
            if (sessionJson.containsKey("openid")) {
                //解密用户信息的加密信息字符串
                String result = WxUtils.wxDecrypt(encryptedData, sessionJson.getString("session_key"), iv);
                System.out.println(result);
                //初始化用户登录信息
                Userinfo entity = JSONObject.parseObject(result, Userinfo.class);
                entity.setWxId(sessionJson.getString("openid"));
                Userinfo returnUserinfo = userinfoService.login(entity);
                if (returnUserinfo == null) {
                    return ReturnUtil.createReturnUtil(500, "登录失败，请重试", null);
                }
                return ReturnUtil.createReturnUtil(200, "登录成功", returnUserinfo);
            } else {
                return ReturnUtil.createReturnUtil(500, "登录失败，请重试", null);
            }
        } catch (Exception e) {
            return ReturnUtil.createReturnUtil(500, "登录失败，请重试", null);
        }
    }

    /**
     * 修改用户信息，实名认证，状态修改，级别修改等
     *
     * @param userinfo 用户信息实例（参数列表）
     * @return Object JSON字符串
     */
    @RequestMapping("update")
    public Object update(Userinfo userinfo) {
        if (userinfoService.updateById(userinfo)) {
            return ReturnUtil.createReturnUtil(200, "修改成功", null);
        }
        return ReturnUtil.createReturnUtil(500, "修改失败", null);
    }

    /**
     * 删除用户信息
     *
     * @param id 用户id
     * @return JSON字符串（删除结果）
     */
    @RequestMapping("remove")
    public ReturnUtil remove(String id) {
        if (userinfoService.removeById(id)) {
            return ReturnUtil.createReturnUtil(200, "删除成功", null);
        }
        return ReturnUtil.createReturnUtil(500, "删除失败", null);
    }

    /**
     * 通过微信接口获得的唯一id进行用户查询操作
     * @param wxId 微信官方接口获得的唯一id
     * @return <p>JSON字符串<p/><p>code：200成功，500失败<p/><p>msg：提示消息<p/><p>data：成功则返回用户信息详情参照Userinfo<br>失败为空<p/>
     */
    @RequestMapping("getByWxId")
    public ReturnUtil getByWxId(String wxId) {
        try {
            return ReturnUtil.createReturnUtil(200, "查询成功", userinfoService.getByWxId(wxId));
        } catch (Exception e) {
            return ReturnUtil.createReturnUtil(500, "查询失败", null);
        }
    }
}
