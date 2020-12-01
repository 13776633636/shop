package com.xxxx.manager.utils;


import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;

import java.io.InputStream;

/**
 * 七牛云上传文件工具类
 */
public class QiniuCloudUtil {

    // 设置需要操作的账号的AK和SK 生成上传凭证，然后准备上传
    private static final String ACCESS_KEY = "of9yGnQ55zv3kL65M5zfC8AkwEZ2JBNQT7qMoZJn";
    private static final String SECRET_KEY = "_0vsio5ajR36onaGRaolLZF1knX_ZbR7ZbY9qTDq";
    // 要上传的空间
    private static final String BUCKET_NAME = "java42-shop-project";


    private static final String DOMAIN = "http://qkmyyai8n.hd-bkt.clouddn.com/";

    //private static final String style = "自定义的图片样式";

    /**
     * 通过流的形式上传文件
     * @param inputStream  将文件先转换成流
     * @param fileName  文件名字
     * @return
     */

    public static String uploadImgByInputStream(InputStream inputStream,String fileName){




        //构造一个带指定 Region 对象的配置类
        Configuration cfg = new Configuration(Region.region0());
        //...其他参数参考类注释
        UploadManager uploadManager = new UploadManager(cfg);

        String result = null;
        //默认不指定key的情况下，以文件内容的hash值作为文件名
        String key = fileName;
        try {
            Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
            String upToken = auth.uploadToken(BUCKET_NAME);
            try {
                Response response = uploadManager.put(inputStream,key,upToken,null, null);
                if (response.statusCode == 200){//上传成功返回url
                     result =  DOMAIN+fileName;
                     return result;
                }else{
                    return "上传失败";
                }
            } catch (QiniuException ex) {
                Response r = ex.response;
                System.err.println(r.toString());
                result = "上传失败";
                try {
                    System.err.println(r.bodyString());
                } catch (QiniuException ex2) {
                    //ignore
                }
            }
        } catch (Exception ex) {
            //ignore
        }
        return result;
    }


}