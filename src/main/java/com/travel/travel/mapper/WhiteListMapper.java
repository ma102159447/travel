package com.travel.travel.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.travel.travel.entity.WhiteList;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.travel.travel.entity.ext.WhiteListExt;

/**
 * <p>
 * InnoDB free: 4096 kB Mapper 接口
 * </p>
 *
 * @author Code Duck
 * @since 2022-06-14
 */
public interface WhiteListMapper extends BaseMapper<WhiteList> {
    int removeById(String id);
    int removeByUserId(String userId,String whiteListUserId);
    IPage<WhiteListExt> getByUserId(IPage<WhiteListExt> whiteListPage, String userId);
}
