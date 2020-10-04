package com.xu.services;

import com.xu.entity.Area;

import java.util.List;

/**
 * @author mashenglin
 */
public interface AreaService {
    /**
     * 获得所有区域信息
     * @return 区域列表
     */
   List<Area> getAreaList();
}
