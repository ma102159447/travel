package com.travel.travel.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.travel.travel.entity.ScenicSpot;
import com.travel.travel.mapper.ScenicSpotMapper;
import com.travel.travel.service.ScenicSpotService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * InnoDB free: 4096 kB 景点服务实现类
 * </p>
 *
 * @author Code Duck
 * @since 2022-06-16
 */
@Service
public class ScenicSpotServiceImpl extends ServiceImpl<ScenicSpotMapper, ScenicSpot> implements ScenicSpotService {
    @Autowired
    ScenicSpotMapper scenicSpotMapper;
    /**
     * 根据传递参数查询景点列表，如果传入null则查询所有景点信息
     *
     * @param scenicSpot ScenicSpot景点实例对象
     * @return ScenicSpot 景点集合
     */
    @Override
    public List<ScenicSpot> getScenicSpots(ScenicSpot scenicSpot) {
        QueryWrapper<ScenicSpot> queryWrapper = new QueryWrapper<>(scenicSpot);
        return this.list(queryWrapper);
    }

    /**
     * 根据传递参数查询景点列表，如果传入null则查询所有景点信息(分页查询)
     *
     * @param currentPage 当前页码
     * @param pageCount   每页显示数量
     * @param scenicSpot  ScenicSpot景点实例对象
     * @return ScenicSpot 含页码信息的数据合集
     */
    @Override
    public IPage<ScenicSpot> getScenicSpots(int currentPage, int pageCount, ScenicSpot scenicSpot) {
        IPage<ScenicSpot> page = new Page<>(currentPage,pageCount);
        QueryWrapper<ScenicSpot> queryWrapper = new QueryWrapper<>(scenicSpot);
        return scenicSpotMapper.selectPage(page,queryWrapper);
    }
}
