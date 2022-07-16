package com.travel.travel.service;

import com.travel.travel.entity.SysCity;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 城市编码
 * </p>
 *
 * @author Code Duck
 * @since 2022-07-04
 */
public interface SysCityService extends IService<SysCity> {
    /**
     * 查询所有根节点的城市
     * @return  List<SysCity> 城市编码集合
     */
    List<SysCity> getParent();

    /**
     * 根据父节点的城市编码查询子节点城市
     * @param code 父节点城市编码
     * @return List<SysCity> 城市编码集合
     */
    List<SysCity> getByParentCode(String code);

    List<SysCity> getTreeOfCity();


}
