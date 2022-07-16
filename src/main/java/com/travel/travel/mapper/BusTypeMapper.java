package com.travel.travel.mapper;

import com.travel.travel.entity.BusType;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * InnoDB free: 4096 kB Mapper 接口
 * </p>
 *
 * @author Code Duck
 * @since 2022-06-16
 */
public interface BusTypeMapper extends BaseMapper<BusType> {
    int removeById(String id);
}
