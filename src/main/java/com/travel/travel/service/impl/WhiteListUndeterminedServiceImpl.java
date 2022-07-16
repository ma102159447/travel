package com.travel.travel.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.travel.travel.entity.WhiteListUndetermined;
import com.travel.travel.entity.ext.WhiteListUndeterminedExt;
import com.travel.travel.mapper.WhiteListUndeterminedMapper;
import com.travel.travel.service.WhiteListUndeterminedService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * InnoDB free: 4096 kB 白名单待定服务实现类
 * </p>
 *
 * @author Code Duck
 * @since 2022-06-16
 */
@Service
public class WhiteListUndeterminedServiceImpl extends ServiceImpl<WhiteListUndeterminedMapper, WhiteListUndetermined> implements WhiteListUndeterminedService {
    @Autowired
    WhiteListUndeterminedMapper whiteListUndeterminedMapper;
    /**
     * 通过白名单待定主键删除数据
     *
     * @param id 白名单主键id
     * @return int 删除数据条数
     */
    @Override
    public int removeById(String id) {
        return whiteListUndeterminedMapper.removeById(id);
    }

    /**
     * 通过当前用户id和白名单待定用户id删除数据
     *
     * @param userId          当前用户id
     * @param whiteListUserId 白名单用户id
     * @return int 删除数据条数
     */
    @Override
    public int removeByUserId(String userId, String whiteListUserId) {
        return whiteListUndeterminedMapper.removeByUserId(userId,whiteListUserId);
    }

    /**
     * 清空当前用户白名单待定列表
     *
     * @param userId 当前用户id
     * @return int 删除数据条数
     */
    @Override
    public int clearByUserId(String userId) {
        return whiteListUndeterminedMapper.clearByUserId(userId);
    }

    /**
     * 添加白名单用户，如果已经在白名单待定列表中则不添加
     *
     * @param whiteListUndetermined WhiteListUndetermined实例
     * @return int 状态码
     */
    @Override
    public int saveWhiteListUndetermined(WhiteListUndetermined whiteListUndetermined) {
        QueryWrapper<WhiteListUndetermined> queryWrapper = new QueryWrapper<>(whiteListUndetermined);
        List<WhiteListUndetermined> blackLists = this.list(queryWrapper);
        if (blackLists == null || blackLists.isEmpty()) {
            return this.save(whiteListUndetermined) ? 200 : 500;
        } else {
            return 501;
        }
    }

    /**
     * 根据登录用户id获得白名单待定列表（分页）
     * @param currentPage 当前页码
     * @param pageCount 每页显示数据条数
     * @param userId 根据登录用户id获得白名单列表
     * @return WhiteListUndeterminedExt 分页信息和数据
     */
    @Override
    public IPage<WhiteListUndeterminedExt> getWhiteListUndeterminedByUserId(int currentPage, int pageCount, String userId) {
        IPage<WhiteListUndeterminedExt> page = new Page<>(currentPage,pageCount);
        return  whiteListUndeterminedMapper.getByUserId(page,userId);
    }
}
