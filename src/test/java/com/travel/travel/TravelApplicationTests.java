package com.travel.travel;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.travel.travel.entity.BlackList;
import com.travel.travel.entity.StationRoute;
import com.travel.travel.entity.SysCity;
import com.travel.travel.entity.WhiteList;
import com.travel.travel.entity.ext.BlackListExt;
import com.travel.travel.entity.ext.WhiteListExt;
import com.travel.travel.mapper.BlackListMapper;
import com.travel.travel.mapper.WhiteListMapper;
import com.travel.travel.service.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class TravelApplicationTests {
    @Autowired
    StationRouteService stationRouteService;
    @Test
    void contextLoads() {
        StationRoute stationRouteById = stationRouteService.getStationRouteById("1");
        System.out.println(stationRouteById);
    }

}
