package com.travel.travel.controller;


import com.travel.travel.entity.ScenicSpot;
import com.travel.travel.service.ScenicSpotService;
import com.travel.travel.util.ReturnUtil;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * <p>
 * InnoDB free: 4096 kB 景点前端控制器
 * </p>
 *
 * @author Code Duck
 * @since 2022-06-16
 */
@RestController
@RequestMapping("/scenic-spot")
public class ScenicSpotController {
    @Autowired
    ScenicSpotService scenicSpotService;

    /**
     * 保存景点信息
     *
     * @param scenicSpot ScenicSpot实例对象
     * @return JSON字符串
     */
    @RequestMapping("addScenicSpot")
    @ApiOperation("保存单个景点信息")
    @ApiImplicitParams({@ApiImplicitParam(name = "ScenicSpot字段说明")})
    public ReturnUtil addScenicSpot(ScenicSpot scenicSpot) {
        scenicSpot.setCreatetime(new Date());
        scenicSpot.setFlag(1);
        return scenicSpotService.save(scenicSpot) ?
                ReturnUtil.createReturnUtil(200, "保存成功", null) :
                ReturnUtil.createReturnUtil(500, "保存失败", null);
    }

    /**
     * 根据id修改景点信息
     * @param scenicSpot ScenicSpot实例对象
     * @return JSON字符串
     */
    @RequestMapping("updateScenicSootById")
    public ReturnUtil updateScenicSootById(ScenicSpot scenicSpot){
        scenicSpot.setUpdatetime(new Date());
        return scenicSpotService.updateById(scenicSpot)?
                ReturnUtil.createReturnUtil(200, "修改成功", null) :
                ReturnUtil.createReturnUtil(500, "修改失败", null);
    }


    /**
     * 根据主键id删除景点信息
     *
     * @param id 主键id
     * @return JSON字符串
     */
    @RequestMapping("removeScenicSpot")
    public ReturnUtil removeScenicSpot(String id) {
        return scenicSpotService.removeById(id) ?
                ReturnUtil.createReturnUtil(200, "删除成功", null) :
                ReturnUtil.createReturnUtil(500, "删除失败", null);
    }

    /**
     * 根据传递参数查询景点列表，如果传入null则查询所有景点信息
     *
     * @param scenicSpot ScenicSpot景点实例对象
     * @return JSON字符串
     */
    @RequestMapping("getScenicSpots")
    public ReturnUtil getScenicSpots(ScenicSpot scenicSpot) {
        return ReturnUtil.createReturnUtil(200, "查询成功", scenicSpotService.getScenicSpots(scenicSpot));
    }

    /**
     * 根据传递参数查询景点列表，如果传入null则查询所有景点信息(分页查询)
     *
     * @param currentPage 当前页码
     * @param pageCount   每页显示数量
     * @param scenicSpot  ScenicSpot景点实例对象
     * @return JSON字符串
     */
    @RequestMapping("getScenicSpotsByPage")
    public ReturnUtil getScenicSpotsByPage(int currentPage,int pageCount,ScenicSpot scenicSpot){
        return ReturnUtil.createReturnUtil(200, "查询成功", scenicSpotService.getScenicSpots(currentPage,pageCount,scenicSpot));
    }


}
