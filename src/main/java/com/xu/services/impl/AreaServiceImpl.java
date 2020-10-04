package com.xu.services.impl;

import com.xu.dao.AreaDao;
import com.xu.entity.Area;
import com.xu.services.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author mashenglin
 */
@Service
public class AreaServiceImpl implements AreaService {
    @Autowired
    private AreaDao areaDao;
    public List<Area> getAreaList() {
        return areaDao.queryArea();
    }
}
