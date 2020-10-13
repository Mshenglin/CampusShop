package com.xu.util;

/**
 * 路径工具
 * @author ma
 */
public class PathUtil {
    /**
     * 获取操作系统的分隔符
     */
    private static String separator=System.getProperty("file.separator");
    /**
     *得到图片的基础路径
     */
public  static  String getImgBasePath(){
    //获得操作系统的信息
    String os=System.getProperty("os.name");
    //基础路径
    String bathPath="";
    //判断系统是否是window
    if(os.toLowerCase().startsWith("win")){
        //设置基础路径
        bathPath="D:/CampusShop";
    }
    //其他操作系统
    else {
        bathPath="/home/CampusShop";
    }
    //替换分割符
    bathPath=bathPath.replace("/", separator);
return  bathPath;
}
/**
 * 获取照片店铺路径
 */
public static String getShopImagePath(long shopId){
    String imagePath="/uplode/item/shop"+shopId+"/";
    return  imagePath.replace("/", separator);
}
}

