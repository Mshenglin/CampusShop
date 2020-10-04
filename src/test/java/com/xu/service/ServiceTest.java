package com.xu.service;

import com.xu.BeseTest;
import com.xu.entity.Area;
import com.xu.services.AreaService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ServiceTest extends BeseTest {
    @Autowired
    private AreaService areaService;
    @Test
    public void testGetAreaList(){
        List<Area> list = areaService.getAreaList();
        System.out.println(list);
    }
}
