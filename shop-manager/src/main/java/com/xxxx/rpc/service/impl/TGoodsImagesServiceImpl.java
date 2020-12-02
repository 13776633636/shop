package com.xxxx.rpc.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xxxx.common.result.BaseResult;
import com.xxxx.common.result.FileResult;
import com.xxxx.manager.mapper.TGoodsImagesMapper;
import com.xxxx.manager.pojo.TGoodsImages;
import com.xxxx.rpc.service.TGoodsImagesService;
import com.xxxx.manager.utils.AssertUtils;
import com.xxxx.manager.utils.QiniuCloudUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

@Service
public class TGoodsImagesServiceImpl extends ServiceImpl<TGoodsImagesMapper, TGoodsImages> implements TGoodsImagesService {


    @Override
    public FileResult fileUpload(MultipartFile image, HttpServletRequest request) {
        FileResult fileResult = new FileResult();
        AssertUtils.isTrue(image.isEmpty(), "文件为空，请重新上传", 500);

        //将文件转换成流
        InputStream inputStream = null;
        try {
            inputStream = image.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //设置文件名字，作为上传后的文件名字
        String imageName = UUID.randomUUID().toString();
        //以流的形式上传文件，返回message
        String message = QiniuCloudUtil.uploadImgByInputStream(inputStream, imageName);
        if (!"上传失败".equals(message)) {
            fileResult.setMessage("");
            fileResult.setSuccess("");
            fileResult.setFileUrl(message);
        }
        return fileResult;
    }

    @Override
    public BaseResult saveImages(MultipartFile image, Integer goodsId, HttpServletRequest request) {
        FileResult fileResult = fileUpload(image, request);
        String fileUrl = fileResult.getFileUrl();

        TGoodsImages goodsImages = new TGoodsImages();
        goodsImages.setImageUrl(fileUrl);
        goodsImages.setGoodsId(goodsId);

        return this.save(goodsImages) ? BaseResult.success() : BaseResult.error();
    }


}
