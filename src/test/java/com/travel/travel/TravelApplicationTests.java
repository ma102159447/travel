package com.travel.travel;



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

    }

}
