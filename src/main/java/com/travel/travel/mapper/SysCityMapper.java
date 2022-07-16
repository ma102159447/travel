package com.travel.travel.mapper;

import com.travel.travel.entity.SysCity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * InnoDB free: 11264 kB Mapper 接口
 * </p>
 *
 * @author Code Duck
 * @since 2022-07-04
 */
public interface SysCityMapper extends BaseMapper<SysCity> {
    List<SysCity> getParent();
    List<SysCity> getByParentCode(String code);
}
