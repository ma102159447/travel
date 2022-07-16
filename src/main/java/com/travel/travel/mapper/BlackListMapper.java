package com.travel.travel.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.travel.travel.entity.BlackList;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.travel.travel.entity.ext.BlackListExt;

/**
 * <p>
 * InnoDB free: 4096 kB Mapper 接口
 * </p>
 *
 * @author Code Duck
 * @since 2022-06-14
 */
public interface BlackListMapper extends BaseMapper<BlackList> {
     int removeById(String id);
     int removeByUserId(String userId,String blackListUserId);
     IPage<BlackListExt> getByUserId(IPage<BlackListExt> page, String userId);
}
