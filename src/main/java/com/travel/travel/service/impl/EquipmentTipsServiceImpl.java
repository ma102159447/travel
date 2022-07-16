package com.travel.travel.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.travel.travel.entity.EquipmentTips;
import com.travel.travel.mapper.EquipmentTipsMapper;
import com.travel.travel.service.EquipmentTipsService;
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
public class EquipmentTipsServiceImpl extends ServiceImpl<EquipmentTipsMapper, EquipmentTips> implements EquipmentTipsService {

    /**
     * 根据当前登录用户获得装备建议，如果当前登录用户没有编辑过装备建议信息则返回系统默认信息
     *
     * @param userId 当前登录用户id
     * @return EquipmentTips 实例对象
     */
    @Override
    public EquipmentTips getEquipmentTipsByUser(String userId) {
        EquipmentTips equipmentTips = new EquipmentTips();
        equipmentTips.setUserId(userId==null?"":userId);
        QueryWrapper<EquipmentTips> safetyTipsQueryWrapper = new QueryWrapper<>(equipmentTips);
        List<EquipmentTips> queryList = this.list(safetyTipsQueryWrapper);
        if(queryList==null||queryList.isEmpty()){
            equipmentTips.setUserId("system");
            return this.list(safetyTipsQueryWrapper).get(0);
        }else{
            return queryList.get(0);
        }
    }
}
