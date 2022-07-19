package com.travel.travel.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.travel.travel.entity.StationInformation;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Code Duck
 * @since 2022-07-19
 */
public interface StationInformationService extends IService<StationInformation> {
    boolean deleteById(String id);
}
