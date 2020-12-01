package com.xxxx.manager.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xxxx.common.result.FileResult;
import com.xxxx.manager.pojo.TGoodsImages;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

public interface TGoodsImagesService extends IService<TGoodsImages>{

    /**
     * 图片上传功能
     * @param image 前端传的图片文件
     * @param request 请求
     * @return
     */
    FileResult fileUpload(MultipartFile image, HttpServletRequest request);
}
