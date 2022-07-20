package com.travel.travel.service.impl;

import com.travel.travel.entity.StationInformation;
import com.travel.travel.mapper.StationInformationMapper;
import com.travel.travel.service.StationInformationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Code Duck
 * @since 2022-07-19
 */
@Service
public class StationInformationServiceImpl extends ServiceImpl<StationInformationMapper, StationInformation> implements StationInformationService {
    @Autowired
    StationInformationMapper mapper;
    @Override
    public boolean deleteById(String id) {
        return mapper.deleteById(id)>=0;
    }
}
