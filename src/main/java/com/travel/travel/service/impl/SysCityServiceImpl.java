package com.travel.travel.service.impl;

import com.travel.travel.entity.SysCity;
import com.travel.travel.mapper.SysCityMapper;
import com.travel.travel.service.SysCityService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * InnoDB free: 11264 kB 服务实现类
 * </p>
 *
 * @author Code Duck
 * @since 2022-07-04
 */
@Service
public class SysCityServiceImpl extends ServiceImpl<SysCityMapper, SysCity> implements SysCityService {
    @Autowired
    SysCityMapper sysCityMapper;

    /**
     * 查询所有根节点的城市
     *
     * @return List<SysCity> 城市编码集合
     */
    @Override
    public List<SysCity> getParent() {
        return sysCityMapper.getParent();
    }

    /**
     * 根据父节点的城市编码查询子节点城市
     *
     * @param code 父节点城市编码
     * @return List<SysCity> 城市编码集合
     */
    @Override
    public List<SysCity> getByParentCode(String code) {
        return sysCityMapper.getByParentCode(code);
    }

    /**
     * 获得省市的树结构
     *
     * @return List<SysCity>  树形结构的省市数据
     */
    @Override
    public List<SysCity> getTreeOfCity() {
        List<SysCity> root = this.getParent();
        for (SysCity parent : root) {
            List<SysCity> children = this.getByParentCode(parent.getCode());
            if (children != null && !children.isEmpty()) {
                parent.setChildren(children);
            } else {
                parent.setChildren(null);
            }

        }
        return root;
    }

    /**
     * 获得省市区Tree
     *
     * @return
     */
    @Override
    public List<SysCity> getTree() {
        List<SysCity> result = this.getParent();
        for (SysCity province : result) {
            List<SysCity> searchCity = this.getByParentCode(province.getCode());
            if (searchCity != null && !searchCity.isEmpty()) {
                for (SysCity city : searchCity) {
                    List<SysCity> county = this.getByParentCode(city.getCode());
                    if (county != null && !county.isEmpty()) {
                        city.setChildren(county);
                    } else {
                        city.setChildren(null);
                    }
                }
                province.setChildren(searchCity);
            } else {
                province.setChildren(null);
            }

        }
        return result;
    }
}
