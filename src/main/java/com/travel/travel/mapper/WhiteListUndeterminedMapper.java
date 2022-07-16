package com.travel.travel.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.travel.travel.entity.WhiteListUndetermined;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.travel.travel.entity.ext.WhiteListUndeterminedExt;

/**
 * <p>
 * InnoDB free: 4096 kB Mapper 接口
 * </p>
 *
 * @author Code Duck
 * @since 2022-06-16
 */
public interface WhiteListUndeterminedMapper extends BaseMapper<WhiteListUndetermined> {
    int removeById(String id);
    int removeByUserId(String userId,String whiteListUserId);
    int clearByUserId(String userId);
    IPage<WhiteListUndeterminedExt> getByUserId(IPage<WhiteListUndeterminedExt> whiteListPage, String userId);
}
