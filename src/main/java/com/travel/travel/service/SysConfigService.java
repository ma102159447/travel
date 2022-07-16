package com.travel.travel.service;

import com.travel.travel.entity.SysConfig;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * InnoDB free: 4096 kB 服务类
 * </p>
 *
 * @author Code Duck
 * @since 2022-06-14
 */
public interface SysConfigService extends IService<SysConfig> {
    List<SysConfig> getSysConfig(SysConfig sysConfig);
}
