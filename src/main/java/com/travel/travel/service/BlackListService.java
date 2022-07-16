package com.travel.travel.service;

import com.travel.travel.entity.BlackList;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * InnoDB free: 4096 kB 服务类
 * </p>
 *
 * @author Code Duck
 * @since 2022-06-14
 */
public interface BlackListService extends IService<BlackList> {
    /**
     * 添加黑名单用户，如果已经在黑名单中则不添加
     * @param blackList BlackList实例
     * @return int 状态码
     */
    int saveBlackList(BlackList blackList);

    /**
     * 根据id删除一条黑名单数据
     * @param id 主键
     * @return int 删除数据数量
     */
    int removeById(String id);

    /**
     * 根据用户id和被加入黑名单的用户id删除黑名单数据
     * @param userId 当前登录的用户id
     * @param blackListUserId 要移除黑名单的用户id
     * @return int 删除数据数量
     */
    int removeByUserId(String userId,String blackListUserId);
}
