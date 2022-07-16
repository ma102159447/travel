package com.travel.travel.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.travel.travel.entity.BusType;
import com.travel.travel.mapper.BusTypeMapper;
import com.travel.travel.service.BusTypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * InnoDB free: 4096 kB 服务实现类
 * </p>
 *
 * @author Code Duck
 * @since 2022-06-16
 */
@Service
public class BusTypeServiceImpl extends ServiceImpl<BusTypeMapper, BusType> implements BusTypeService {
    @Autowired
    BusTypeMapper busTypeMapper;

    /**
     * 根据参数列表查询车辆类型，如果传入空则查询所有参数类型
     *
     * @param busType 车辆类型实例（参数列表）
     * @return BusType 集合
     */
    @Override
    public List<BusType> searchBusTypes(BusType busType) {
        QueryWrapper<BusType> busTypeQueryWrapper = new QueryWrapper<>(busType);
        return this.list(busTypeQueryWrapper);
    }

    /**
     * 根据参数列表查询车辆类型，如果传入空则查询所有参数类型（分页）
     *
     * @param currentPage 当前页码
     * @param pageCount   每页显示数量
     * @param busType     车辆类型实例（参数列表）
     * @return BusType 包含分页信息的集合
     */
    @Override
    public IPage<BusType> searchBusTypes(int currentPage, int pageCount, BusType busType) {
        QueryWrapper<BusType> busTypeQueryWrapper = new QueryWrapper<>(busType);
        return busTypeMapper.selectPage(new Page<>(currentPage, pageCount), busTypeQueryWrapper);
    }

    /**
     * 根据id删除车辆类型信息
     *
     * @param id 主键
     * @return boolean 删除结果
     */
    @Override
    public boolean removeBusTypeById(String id) {
        return busTypeMapper.removeById(id) > 0;
    }
}
