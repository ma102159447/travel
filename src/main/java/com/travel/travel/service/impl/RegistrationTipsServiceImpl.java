package com.travel.travel.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.travel.travel.entity.RegistrationTips;
import com.travel.travel.mapper.RegistrationTipsMapper;
import com.travel.travel.service.RegistrationTipsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * InnoDB free: 4096 kB 服务实现类
 * </p>
 *
 * @author Code Duck
 * @since 2022-06-13
 */
@Service
public class RegistrationTipsServiceImpl extends ServiceImpl<RegistrationTipsMapper, RegistrationTips> implements RegistrationTipsService {

    /**
     * 根据当前登录用户获得报名提示，如果当前登录用户没有编辑过报名提示信息则返回系统默认信息
     *
     * @param userId 当前登录用户id
     * @return RegistrationTips 实例对象
     */
    @Override
    public RegistrationTips getRegistrationTipsByUser(String userId) {
        RegistrationTips registrationTips = new RegistrationTips();
        registrationTips.setUserId(userId==null?"":userId);
        QueryWrapper<RegistrationTips> safetyTipsQueryWrapper = new QueryWrapper<>(registrationTips);
        List<RegistrationTips> queryList = this.list(safetyTipsQueryWrapper);
        if(queryList==null||queryList.isEmpty()){
            registrationTips.setUserId("system");
            return this.list(safetyTipsQueryWrapper).get(0);
        }else{
            return queryList.get(0);
        }
    }
}
