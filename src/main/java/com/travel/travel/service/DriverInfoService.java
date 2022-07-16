package com.travel.travel.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.travel.travel.entity.DriverInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.travel.travel.entity.ScenicSpot;

import java.util.List;

/**
 * <p>
 * InnoDB free: 4096 kB 服务类
 * </p>
 *
 * @author Code Duck
 * @since 2022-06-16
 */
public interface DriverInfoService extends IService<DriverInfo> {
    /**
     * 根据参数列表查询该用户保存的司机信息
     * @param driverInfo DriverInfo实例
     * @return DriverInfo 集合
     */
    List<DriverInfo> searchDriverInfosByUserId(DriverInfo driverInfo);

    /**
     * 根据参数列表和分页信息查询该用户保存的司机信息（分页）
     * @param currentPage 当前页码
     * @param pageCount 每页显示数量
     * @param driverInfo DriverInfo实例
     * @return DriverInfo 包含页码信息的集合
     */
    IPage<DriverInfo> searchDriverInfosByUserId(int currentPage,int pageCount,DriverInfo driverInfo);

}
