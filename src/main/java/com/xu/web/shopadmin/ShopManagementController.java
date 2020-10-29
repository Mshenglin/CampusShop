package com.xu.web.shopadmin;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xu.dto.ShopExecution;
import com.xu.entity.Area;
import com.xu.entity.PersonInfo;
import com.xu.entity.Shop;
import com.xu.entity.ShopCategory;
import com.xu.enums.ShopStateEnum;
import com.xu.exceptions.ShopOperationException;
import com.xu.services.AreaService;
import com.xu.services.ShopCategoryService;
import com.xu.services.ShopService;
import com.xu.util.HttpServletRequestUtil;
import com.xu.util.VerificationCodeUtil;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author mashenglin
 */
@Controller
@RequestMapping(value = "/shopadmin",method = RequestMethod.GET)
public class ShopManagementController {
    @Autowired
    private ShopService shopService;
    @Autowired
    private ShopCategoryService shopCategoryService;
    @Autowired
    private AreaService areaService;
    /**
     * 根据shopId返回商品信息
     * @param request
     * @return
     */
    @RequestMapping(value = "/getShopById" ,method=RequestMethod.GET)
    @ResponseBody
    private Map<String,Object> getShopById(HttpServletRequest request){
        Map<String,Object> modelMap=new HashMap<String,Object>();
        Long shopId=HttpServletRequestUtil.getLong(request, "shopid");
        System.out.println(shopId);
        if(shopId>-1){
            try {
                Shop shop=shopService.getByShopId(shopId);
                System.out.println(shop);
                List<Area> areaList=areaService.getAreaList();
                System.out.println(areaList);
                modelMap.put("shop", shop);
                modelMap.put("areaList", areaList);
                modelMap.put("success", true);
            } catch (ShopOperationException e) {
                modelMap.put("success",false);
                modelMap.put("errMag", e.toString());
            }
        }
        return modelMap;
    }
    /**
     * 注册店铺
     * @param request
     * @return
     */
    @RequestMapping(value = "/registershop",method = RequestMethod.POST)
    public Map<String, Object> registerShop(HttpServletRequest request) {
        //1.处理请求
        HashMap<String,Object>  modelMap=new HashMap<>();
        //验证码的比对
        Boolean flag=VerificationCodeUtil.verificationCodeComparison(request);
        System.out.println(flag);
        if(!flag){
            modelMap.put("success", false);
            modelMap.put("Mag", "验证码输入有误");
            return modelMap;
        }
        //让前端返回的数据字符串化
        String shopStr = HttpServletRequestUtil.getString(request, "shopStr");
        //使用json解析
        ObjectMapper mapper = new ObjectMapper();
        //将传入的json对象和实体类对应
        Shop shop=null;
        try {
            shop = mapper.readValue(shopStr, Shop.class);
        } catch (IOException e) {
            modelMap.put("success",false);
            modelMap.put("err",e.getMessage());
            return modelMap;
        }
        //处理图片
        CommonsMultipartFile shopImg=null;
        CommonsMultipartResolver commonsMultipartResolver=new CommonsMultipartResolver();
        //在request查找是否有文件上传的会话
        request.getSession().getServletContext();
        //如果上传请求对象有文件上传,将请求中的文件转换成CommonsMultipartFile
        if(commonsMultipartResolver.isMultipart(request)){
            MultipartHttpServletRequest multipartHttpServletRequest= (MultipartHttpServletRequest) request;
            shopImg= (CommonsMultipartFile) multipartHttpServletRequest.getFile("shopImg");
        }
        else {
            modelMap.put("success",false);
            modelMap.put("err","上传店铺不可以为空");
            return modelMap;
        }
        //2.注册店铺
        if(shop!=null&&shopImg!=null){
            //该处后续完善
            PersonInfo owner=new PersonInfo();
            owner.setUserId(1L);
            shop.setOwner(owner);
            ShopExecution shopExecution = shopService.addShop(shop, shopImg);
            if (shopExecution.getState()==ShopStateEnum.CHECK.getState()){
                modelMap.put("success",true);
                return modelMap;
            }
            else {
                modelMap.put("success",false);
                modelMap.put("errMag",shopExecution.getStateInfo());
                return modelMap;
            }

        }
        else {
            modelMap.put("success",false);
            modelMap.put("errMag","输入店铺信息");
            return modelMap;
        }
    }
    /**
     * 注册店铺
     * @param request
     * @return
     */
    @RequestMapping(value = "/modifyshop",method = RequestMethod.POST)
    public Map<String, Object> modifyShop(HttpServletRequest request) {
        //1.处理请求
        HashMap<String,Object>  modelMap=new HashMap<>();
        //验证码的比对
        Boolean flag=VerificationCodeUtil.verificationCodeComparison(request);
        System.out.println(flag);
        if(!flag){
            modelMap.put("success", false);
            modelMap.put("Mag", "验证码输入有误");
            return modelMap;
        }
        //让前端返回的数据字符串化
        String shopStr = HttpServletRequestUtil.getString(request, "shopStr");
        //使用json解析
        ObjectMapper mapper = new ObjectMapper();
        //将传入的json对象和实体类对应
        Shop shop=null;
        try {
            shop = mapper.readValue(shopStr, Shop.class);
        } catch (IOException e) {
            modelMap.put("success",false);
            modelMap.put("err",e.getMessage());
            return modelMap;
        }
        //处理图片
        CommonsMultipartFile shopImg=null;
        CommonsMultipartResolver commonsMultipartResolver=new CommonsMultipartResolver();
        //在request查找是否有文件上传的会话
        request.getSession().getServletContext();
        //如果上传请求对象有文件上传,将请求中的文件转换成CommonsMultipartFile
        if(commonsMultipartResolver.isMultipart(request)){
            MultipartHttpServletRequest multipartHttpServletRequest= (MultipartHttpServletRequest) request;
            shopImg= (CommonsMultipartFile) multipartHttpServletRequest.getFile("shopImg");
        }
        else {
            modelMap.put("success",false);
            modelMap.put("err","上传店铺不可以为空");
            return modelMap;
        }
        //2.修改店铺信息
        if(shop!=null&&shop.getShopId()!=null){
            //该处后续完善
            PersonInfo owner=new PersonInfo();
            owner.setUserId(1L);
            shop.setOwner(owner);
            ShopExecution shopExecution = shopService.addShop(shop, shopImg);
            if (shopExecution.getState()==ShopStateEnum.CHECK.getState()){
                modelMap.put("success",true);
                return modelMap;
            }
            else {
                modelMap.put("success",false);
                modelMap.put("errMag",shopExecution.getStateInfo());
                return modelMap;
            }

        }
        else {
            modelMap.put("success",false);
            modelMap.put("errMag","输入店铺信息");
            return modelMap;
        }
    }
    /**
     * 获取店铺类别信息
     * @param request
     * @return
     */
    @RequestMapping("/getshopinitinfo")
    @ResponseBody
    public Map<String, Object> getShopManagementInfo(HttpServletRequest request){
        HashMap<String,Object>  modelMap=new HashMap<>();
        //用于接受返回的Area和ShopCategoryList列表
        List<ShopCategory> shopCategoryList = null;
        List<Area> areaList=null;
        try {
            areaList = areaService.getAreaList();
            shopCategoryList = shopCategoryService.getShopCategoryList(new ShopCategory());
            modelMap.put("areaList",areaList);
            modelMap.put("shopCategoryList",shopCategoryList);
            System.out.println(areaList);
            System.out.println(shopCategoryList);
            modelMap.put("success", true);
        }
        catch (Exception e){
            modelMap.put("success", false);
            modelMap.put("errMag", e.getMessage());
        }
        return  modelMap;
    }
}
