package com.travel.travel.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.travel.travel.entity.DisclaimersTips;
import com.travel.travel.mapper.DisclaimersTipsMapper;
import com.travel.travel.service.DisclaimersTipsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * InnoDB free: 4096 kB 免责声明服务实现类
 * </p>
 *
 * @author Code Duck
 * @since 2022-06-16
 */
@Service
public class DisclaimersTipsServiceImpl extends ServiceImpl<DisclaimersTipsMapper, DisclaimersTips> implements DisclaimersTipsService {

    /**
     * 根据当前登录用户获得免责声明，如果当前登录用户没有编辑过免责声明则返回系统默认信息
     *
     * @param userId 当前登录用户id
     * @return DisclaimersTips 实例对象
     */
    @Override
    public DisclaimersTips getDisclaimersTipsByUser(String userId) {
        DisclaimersTips disclaimersTips = new DisclaimersTips();
        disclaimersTips.setUserId(userId==null?"":userId);
        QueryWrapper<DisclaimersTips> safetyTipsQueryWrapper = new QueryWrapper<>(disclaimersTips);
        List<DisclaimersTips> queryList = this.list(safetyTipsQueryWrapper);
        if(queryList==null||queryList.isEmpty()){
            disclaimersTips.setUserId("system");
            return this.list(safetyTipsQueryWrapper).get(0);
        }else{
            return queryList.get(0);
        }
    }
}
