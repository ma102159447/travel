package com.travel.travel.service;

import com.travel.travel.entity.Userinfo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * InnoDB free: 4096 kB 服务类
 * </p>
 *
 * @author Code Duck
 * @since 2022-06-12
 */
public interface UserinfoService extends IService<Userinfo> {
    Userinfo login(Userinfo userinfo);

    /**
     * 根据微信唯一id获得用户信息
     * @param wxId 微信调用用户信息的唯一id
     * @return Userinfo 实例对象
     */
    Userinfo getByWxId(String wxId);
}
