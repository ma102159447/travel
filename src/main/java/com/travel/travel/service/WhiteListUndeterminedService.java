package com.travel.travel.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.travel.travel.entity.WhiteListUndetermined;
import com.baomidou.mybatisplus.extension.service.IService;
import com.travel.travel.entity.ext.WhiteListUndeterminedExt;

/**
 * <p>
 * InnoDB free: 4096 kB 服务类
 * </p>
 *
 * @author Code Duck
 * @since 2022-06-16
 */
public interface WhiteListUndeterminedService extends IService<WhiteListUndetermined> {
    /**
     * 通过白名单主键删除数据
     * @param id 白名单主键id
     * @return int 删除数据条数
     */
    int removeById(String id);

    /**
     * 通过当前用户id和白名单用户id删除数据
     * @param userId 当前用户id
     * @param whiteListUserId 白名单用户id
     * @return int 删除数据条数
     */
    int removeByUserId(String userId,String whiteListUserId);

    /**
     * 清空当前用户白名单待定列表
     * @param userId 当前用户id
     * @return int 删除数据条数
     */
    int clearByUserId(String userId);


    /**
     * 添加白名单用户，如果已经在白名单中则不添加
     * @param whiteListUndetermined WhiteListUndetermined实例
     * @return int 状态码
     */
    int saveWhiteListUndetermined(WhiteListUndetermined whiteListUndetermined);

    /**
     * 根据登录用户id获得白名单待定列表（分页）
     * @param currentPage 当前页码
     * @param pageCount 每页显示数据条数
     * @param userId 根据登录用户id获得白名单列表
     * @return WhiteListUndeterminedExt 分页信息和数据
     */
    IPage<WhiteListUndeterminedExt> getWhiteListUndeterminedByUserId(int currentPage, int pageCount, String userId);

}
