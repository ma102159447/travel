package com.travel.travel.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.travel.travel.entity.ScenicSpot;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * InnoDB free: 4096 kB 景点服务类
 * </p>
 *
 * @author Code Duck
 * @since 2022-06-16
 */
public interface ScenicSpotService extends IService<ScenicSpot> {
    /**
     * 根据传递参数查询景点列表，如果传入null则查询所有景点信息
     * @param scenicSpot ScenicSpot景点实例对象
     * @return ScenicSpot 集合
     */
    List<ScenicSpot> getScenicSpots(ScenicSpot scenicSpot);

    /**
     * 根据传递参数查询景点列表，如果传入null则查询所有景点信息(分页查询)
     * @param currentPage 当前页码
     * @param pageCount 每页显示数量
     * @param scenicSpot ScenicSpot景点实例对象
     * @return ScenicSpot 含页码信息的数据合集
     */
    IPage<ScenicSpot> getScenicSpots(int currentPage, int pageCount, ScenicSpot scenicSpot);

}
