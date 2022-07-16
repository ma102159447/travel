package com.travel.travel.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.travel.travel.configuration.WxConstant;
import com.travel.travel.util.HttpRequest;
import com.travel.travel.util.WxUtils;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/wx")
@CrossOrigin(origins = "*", maxAge = 3600)
public class WxController {
    @ApiOperation(value = "openid", notes = "获取openId的接口")
    @RequestMapping("/auth")
    public Object auth(String code) {
        System.out.println(code);
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid=" + WxConstant.appid + "&secret=" + WxConstant.secret + "&js_code=" + code + "&grant_type=authorization_code";
        Map<String, Object> map = new HashMap<>();
        String data = HttpRequest.sendGet(url, null);
        JSONObject jo = JSON.parseObject(data);
        System.out.println(jo);
        map.put("code", 200);
        map.put("data", jo);
        map.put("msg", "调用成功");

        return map;
    }

    @ApiOperation(value = "权限获取用户手机号", notes = "权限获取用户手机号")
    @RequestMapping("/auth/phone")
    public Object authPhone(String encryptedData, String code, String iv) {
        System.out.println(encryptedData+"\n"+code+"\n"+iv);
        Map<String, Object> map = new HashMap<>();
        try {
            String result = WxUtils.wxDecrypt(encryptedData, WxUtils.getSessionKey(code).getString("session_key"), iv);
            JSONObject json = JSONObject.parseObject(result);
            if (json.containsKey("phoneNumber")) {
                String phone = json.getString("phoneNumber");
                String appid = json.getJSONObject("watermark").getString("appid");
                map.put("code", 200);
                map.put("msg", "成功");
                map.put("phoneNumber", phone);
                System.out.println(map);
            } else {
                map.put("code", 401);
                map.put("msg", "获取失败！");
                map.put("phoneNumber", "");
            }
        } catch (Exception e) {
            map.put("code", 401);
            map.put("msg", e.getMessage());
            map.put("phoneNumber", "");
            System.out.println(e.getMessage());
        }
        return map;
    }
}
