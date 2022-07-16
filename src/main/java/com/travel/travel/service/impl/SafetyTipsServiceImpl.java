package com.travel.travel.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.travel.travel.entity.SafetyTips;
import com.travel.travel.mapper.SafetyTipsMapper;
import com.travel.travel.service.SafetyTipsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * InnoDB free: 4096 kB 服务实现类
 * </p>
 *
 * @author Code Duck
 * @since 2022-06-13
 */
@Service
public class SafetyTipsServiceImpl extends ServiceImpl<SafetyTipsMapper, SafetyTips> implements SafetyTipsService {
    /**
     * 根据参数获得安全提示
     * @param params  SafetyTips实例对象
     * @return SafetyTips 安全提示集合
     */
    @Override
    public List<SafetyTips> getSafetyTipsByParams(SafetyTips params) {
        QueryWrapper<SafetyTips> safetyTipsQueryWrapper = new QueryWrapper<>(params);
        return this.list(safetyTipsQueryWrapper);
    }

    /**
     * 根据当前登录用户查询安全提示，如果当前用户没有编辑过安全提示则返回系统默认安全提示
     *
     * @param userId 当前登录用户id
     * @return SafetyTips实例
     */
    @Override
    public SafetyTips getSafetyTipsByUser(String userId) {
        SafetyTips safetyTips = new SafetyTips();
        safetyTips.setUserId(userId==null?"":userId);
        QueryWrapper<SafetyTips> safetyTipsQueryWrapper = new QueryWrapper<>(safetyTips);
        List<SafetyTips> queryList = this.list(safetyTipsQueryWrapper);
        if(queryList==null||queryList.isEmpty()){
            safetyTips.setUserId("system");
            return this.list(safetyTipsQueryWrapper).get(0);
        }else{
            return queryList.get(0);
        }

    }



}
