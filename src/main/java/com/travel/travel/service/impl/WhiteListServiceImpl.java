package com.travel.travel.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.travel.travel.entity.Userinfo;
import com.travel.travel.entity.WhiteList;
import com.travel.travel.entity.ext.WhiteListExt;
import com.travel.travel.mapper.UserinfoMapper;
import com.travel.travel.mapper.WhiteListMapper;
import com.travel.travel.service.WhiteListService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * InnoDB free: 4096 kB 服务实现类
 * </p>
 *
 * @author Code Duck
 * @since 2022-06-14
 */
@Service
public class WhiteListServiceImpl extends ServiceImpl<WhiteListMapper, WhiteList> implements WhiteListService {
    @Autowired
    WhiteListMapper whiteListMapper;
    @Autowired
    UserinfoMapper userinfoMapper;

    /**
     * 通过白名单主键删除数据
     *
     * @param id 白名单主键id
     * @return int 删除数据条数
     */
    @Override
    public int removeById(String id) {
        return whiteListMapper.removeById(id);
    }

    /**
     * 通过当前用户id和白名单用户id删除数据
     *
     * @param userId          当前用户id
     * @param whiteListUserId 白名单用户id
     * @return int 删除数据条数
     */
    @Override
    public int removeByUserId(String userId, String whiteListUserId) {
        return whiteListMapper.removeByUserId(userId, whiteListUserId);
    }

    /**
     * 添加白名单用户，如果已经在白名单中则不添加
     *
     * @param whiteList WhiteList实例
     * @return int 状态码
     */
    @Override
    public int saveWhiteList(WhiteList whiteList) {
        Userinfo userinfo = new Userinfo();
        userinfo.setId(whiteList.getInsertUserId());
        QueryWrapper<Userinfo> userinfoQueryWrapper = new QueryWrapper<>(userinfo);
        List<Userinfo> insertUsers = userinfoMapper.selectList(userinfoQueryWrapper);
        if (insertUsers == null || insertUsers.isEmpty()) {
            return 502;
        }
        userinfo.setId(whiteList.getWhitelistUserId());
        userinfoQueryWrapper = new QueryWrapper<>(userinfo);
        insertUsers = userinfoMapper.selectList(userinfoQueryWrapper);
        if (insertUsers == null || insertUsers.isEmpty()) {
            return 503;
        }
        QueryWrapper<WhiteList> queryWrapper = new QueryWrapper<>(whiteList);
        List<WhiteList> blackLists = this.list(queryWrapper);
        if (blackLists == null || blackLists.isEmpty()) {
            return this.save(whiteList) ? 200 : 500;
        } else {
            return 501;
        }
    }

    /**
     * 根据登录用户id获得白名单列表（分页）
     *
     * @param currentPage 当前页码
     * @param pageCount   每页显示数据条数
     * @param userId      根据登录用户id获得白名单列表
     * @return WhiteListExt 分页信息和数据
     */
    @Override
    public IPage<WhiteListExt> getWhiteListByUserId(int currentPage, int pageCount, String userId) {
        IPage<WhiteListExt> page = new Page<>(currentPage, pageCount);
        return whiteListMapper.getByUserId(page, userId);
    }
}
