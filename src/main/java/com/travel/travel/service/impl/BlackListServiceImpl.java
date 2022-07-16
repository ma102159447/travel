package com.travel.travel.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.travel.travel.entity.BlackList;
import com.travel.travel.mapper.BlackListMapper;
import com.travel.travel.service.BlackListService;
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
public class BlackListServiceImpl extends ServiceImpl<BlackListMapper, BlackList> implements BlackListService {
    @Autowired
    BlackListMapper blackListMapper;
    @Override
    public int saveBlackList(BlackList blackList) {
        QueryWrapper<BlackList> queryWrapper = new QueryWrapper<>(blackList);
        List<BlackList> blackLists = this.list(queryWrapper);
        if (blackLists == null || blackLists.isEmpty()) {
            return this.save(blackList) ? 200 : 500;
        } else {
            return 501;
        }

    }
    /**
     * 根据id删除一条黑名单数据
     * @param id 主键
     * @return int 删除数据数量
     */
    @Override
    public int removeById(String id) {
        return blackListMapper.removeById(id);
    }

    /**
     * 根据用户id和被加入黑名单的用户id删除黑名单数据
     *
     * @param userId          当前登录的用户id
     * @param blackListUserId 要移除黑名单的用户id
     * @return int 删除数据数量
     */
    @Override
    public int removeByUserId(String userId, String blackListUserId) {
        return blackListMapper.removeByUserId(userId,blackListUserId);
    }
}
