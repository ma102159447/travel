package com.travel.travel.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.travel.travel.entity.DriverInfo;
import com.travel.travel.entity.ScenicSpot;
import com.travel.travel.mapper.DriverInfoMapper;
import com.travel.travel.service.DriverInfoService;
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
public class DriverInfoServiceImpl extends ServiceImpl<DriverInfoMapper, DriverInfo> implements DriverInfoService {
    @Autowired
    DriverInfoMapper driverInfoMapper;
    /**
     * 根据参数列表查询该用户保存的司机信息
     *
     * @param driverInfo DriverInfo实例
     * @return DriverInfo 集合
     */
    @Override
    public List<DriverInfo> searchDriverInfosByUserId(DriverInfo driverInfo) {
        QueryWrapper<DriverInfo> driverInfoQueryWrapper = new QueryWrapper<>(driverInfo);
        return this.list(driverInfoQueryWrapper);
    }

    /**
     * 根据参数列表和分页信息查询该用户保存的司机信息（分页）
     *
     * @param currentPage 当前页码
     * @param pageCount   每页显示数量
     * @param driverInfo DriverInfo实例
     * @return DriverInfo 包含页码信息的集合
     */
    @Override
    public IPage<DriverInfo> searchDriverInfosByUserId(int currentPage, int pageCount, DriverInfo driverInfo) {
        IPage<DriverInfo> page = new Page<>(currentPage,pageCount);
        QueryWrapper<DriverInfo> driverInfoQueryWrapper = new QueryWrapper<>(driverInfo);
        return driverInfoMapper.selectPage(page,driverInfoQueryWrapper);
    }
}
