package com.travel.travel.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.travel.travel.entity.Userinfo;
import com.travel.travel.mapper.UserinfoMapper;
import com.travel.travel.service.UserinfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * InnoDB free: 4096 kB 服务实现类
 * </p>
 *
 * @author Code Duck
 * @since 2022-06-12
 */
@Service
public class UserinfoServiceImpl extends ServiceImpl<UserinfoMapper, Userinfo> implements UserinfoService {

    @Override
    public Userinfo login(Userinfo userinfo) {
//         通过微信获取的唯一  openid 进行去重操作
        Userinfo wi = new Userinfo();
        wi.setWxId(userinfo.getWxId());
        QueryWrapper<Userinfo> queryWrapper = new QueryWrapper<Userinfo>(wi);
        List<Userinfo> resultList = this.list(queryWrapper);
        if (resultList != null && !resultList.isEmpty()) {
            return resultList.get(0);
        } else {
            boolean b = this.save(userinfo);
            if (!b) {
                return null;

            }
            return userinfo;

        }
    }

    /**
     * 根据微信唯一id获得用户信息
     *
     * @param wxId 微信调用用户信息的唯一id
     * @return Userinfo 实例对象
     */
    @Override
    public Userinfo getByWxId(String wxId) {
        Userinfo userinfo = new Userinfo();
        userinfo.setWxId(wxId);
        QueryWrapper<Userinfo> userinfoQueryWrapper = new QueryWrapper<>();
        return null;
    }
}
