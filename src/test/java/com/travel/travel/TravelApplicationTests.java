package com.travel.travel;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.travel.travel.entity.BlackList;
import com.travel.travel.entity.SysCity;
import com.travel.travel.entity.WhiteList;
import com.travel.travel.entity.ext.BlackListExt;
import com.travel.travel.entity.ext.WhiteListExt;
import com.travel.travel.mapper.BlackListMapper;
import com.travel.travel.mapper.WhiteListMapper;
import com.travel.travel.service.BlackListService;
import com.travel.travel.service.SysCityService;
import com.travel.travel.service.SysConfigService;
import com.travel.travel.service.WhiteListService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class TravelApplicationTests {
    @Test
    void contextLoads() {

    }

}
