package com.travel.travel.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.travel.travel.entity.BusType;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * InnoDB free: 4096 kB 服务类
 * </p>
 *
 * @author Code Duck
 * @since 2022-06-16
 */
public interface BusTypeService extends IService<BusType> {
    /**
     * 根据参数列表查询车辆类型，如果传入空则查询所有参数类型
     * @param busType 车辆类型实例（参数列表）
     * @return BusType 集合
     */
    List<BusType> searchBusTypes(BusType busType);

    /**
     * 根据参数列表查询车辆类型，如果传入空则查询所有参数类型（分页）
     * @param currentPage 当前页码
     * @param pageCount 每页显示数量
     * @param busType 车辆类型实例（参数列表）
     * @return BusType 包含分页信息的集合
     */
    IPage<BusType> searchBusTypes(int currentPage, int pageCount, BusType busType);

    /**
     * 根据id删除车辆类型信息
     * @param id 主键
     * @return boolean 删除结果
     */
    boolean removeBusTypeById(String id);
}
