package com.xu.web.superadmin;

import com.xu.dao.AreaDao;
import com.xu.entity.Area;
import com.xu.services.AreaService;
import jdk.nashorn.internal.ir.RuntimeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author mashenglin
 */
@Controller
@RequestMapping("/superadmin")
public class AreaController {
    @Autowired
    AreaService areaService;
    @ResponseBody
    @RequestMapping(value="/listarea",method= RequestMethod.GET)
    public Map<String,Object> listArea(){
        Map<String,Object> modelMap=new HashMap<String,Object>();
        List<Area> list=new ArrayList<Area>();
        try {
            list = areaService.getAreaList();
            modelMap.put("rows", list);
            modelMap.put("tolal", list.size());
        }
        catch (Exception e){
            e.printStackTrace();;
            modelMap.put("success", false);
            modelMap.put("Msg", e.toString());
        }
       return  modelMap;


    }
}
