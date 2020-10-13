package com.xu.util;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import net.coobird.thumbnailator.name.Rename;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @author mashenglin
 */
public class ImageUtil {
    /**
     * 随机数对象
     */
    private  static  final  Random r=new Random();
    /**
     * 格式化当前的时间
     */
    private static final SimpleDateFormat dateFormat=new SimpleDateFormat("yyyyMMddHHmmss");
    /**
     *  得到的是 ClassPath的绝对URI路径
     */
    private static  String basePath=Thread.currentThread().getContextClassLoader().getResource("").getPath();
    /**
     *处理传入的文件
     * @param thumbnail 传入的文件对象
     * @param targetAddr 图片存储路径
     * @return 文件的绝对路径
     */
 public static String generateThumbnail(File thumbnail, String targetAddr) {
     //文件的随即名
     String realFileName = getRandomFileName();
     // 获取文件扩展名
     String extension = getFileExtension(thumbnail);
     //如果文件夹不存在，创建文件夹
     makeDirPath(targetAddr);
     //文件夹存在，将传入的文件存放在对应的文件夹下
     String relativeAddr=targetAddr+realFileName+extension;
     File dest=new File(PathUtil.getImgBasePath()+relativeAddr);
     //使用工具Thumbnails处理图片
     try{
         /**
          * watermark(位置，水印图，透明度)
          */
         //由于获取到的路径是/F:/CampusShop/target/test-classes/，进行处理
         String os=System.getProperty("os.name");
         if((os.toLowerCase().startsWith("win"))&&basePath.charAt(0)=='/'){
             basePath=basePath.substring(1);
             System.out.println(basePath);
         }
         String watermark=basePath+"watermark.jpg";
         Thumbnails.of(thumbnail).size(1280, 1024)
                 .watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File(watermark)),0.5f)
                 .outputQuality(0.8f).toFile(dest);
     }
     catch (Exception e){
     throw  new RuntimeException("创建缩略图失败"+ e.toString());
     }
     return  relativeAddr;
 }

    /**
     * 创建目标目录上涉及的文件
     * @param targetAddr
     */
    private static void makeDirPath(String targetAddr) {
        //获取用户的
        String  realFileParentPath=PathUtil.getImgBasePath()+targetAddr;
        File dirPath=new File(realFileParentPath);

        if(!dirPath.exists()){
            dirPath.mkdirs();
        }
    }

    /**
     * 获取图片的扩展名
     * @param thumbnail 用户传入的文件
     * @return
     */
    private static String getFileExtension(File thumbnail) {
        //客户端传入的原始名称
        String thumbnailName = thumbnail.getName();
        return  thumbnailName.substring(thumbnailName.lastIndexOf('.'));
    }

    /**
     * 文件的我重复的名称
     * @return 图片的名称
     */
    private static String getRandomFileName() {
     //获取随机的五位数
        int randomNum= r.nextInt(99999-10000)+10000;
     //获取当前的时间值
        String nowTime=dateFormat.format(new Date());
        return  nowTime+randomNum;
    }

}
