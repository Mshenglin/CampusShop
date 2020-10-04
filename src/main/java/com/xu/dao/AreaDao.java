package com.xu.dao;

import com.xu.entity.Area;

import java.util.List;

/**
 * @author mashenglin
 */
public interface AreaDao {
    /**
     *查询所有地区
     * @return 地区的集合
     */
    List<Area> queryArea();
}
