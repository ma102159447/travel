package com.travel.travel.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.travel.travel.entity.RescueTips;
import com.travel.travel.mapper.RescueTipsMapper;
import com.travel.travel.service.RescueTipsService;
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
public class RescueTipsServiceImpl extends ServiceImpl<RescueTipsMapper, RescueTips> implements RescueTipsService {

    /**
     * 根据当前登录用户获得救援提示信息，如果当前登录用户没有编辑过救援提示信息则返回系统默认信息
     *
     * @param userId 当前登录用户id
     * @return RescueTips
     */
    @Override
    public RescueTips getRescueTipsByUser(String userId) {
        RescueTips rescueTips = new RescueTips();
        rescueTips.setUserId(userId==null?"":userId);
        QueryWrapper<RescueTips> safetyTipsQueryWrapper = new QueryWrapper<>(rescueTips);
        List<RescueTips> queryList = this.list(safetyTipsQueryWrapper);
        if(queryList==null||queryList.isEmpty()){
            rescueTips.setUserId("system");
            return this.list(safetyTipsQueryWrapper).get(0);
        }else{
            return queryList.get(0);
        }
    }
}
