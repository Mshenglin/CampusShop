package com.xu.dao;

import com.xu.BeseTest;
import com.xu.entity.Area;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
public class AreaTest extends BeseTest {
    @Autowired
    private  AreaDao areaDao;
    @Test
    public void Test(){
        List<Area> areas = areaDao.queryArea();
        System.out.println(areas);
        int a=1;
        int b=1;
        System.out.println();
    }
}
