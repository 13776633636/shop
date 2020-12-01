package com.xxxx.manager.service.impl;

import com.xxxx.common.result.BaseResult;
import com.xxxx.manager.utils.AssertUtils;
import com.xxxx.manager.utils.QiniuCloudUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xxxx.manager.pojo.TGoodsImages;
import com.xxxx.manager.mapper.TGoodsImagesMapper;
import com.xxxx.manager.service.TGoodsImagesService;
import org.springframework.web.multipart.MultipartFile;

@Service
public class TGoodsImagesServiceImpl extends ServiceImpl<TGoodsImagesMapper, TGoodsImages> implements TGoodsImagesService {

    @Autowired
    private TGoodsImagesMapper goodsImagesMapper;

    @Override
    public BaseResult fileUpload(MultipartFile image, HttpServletRequest request) {
        AssertUtils.isTrue(image.isEmpty(), "文件为空，请重新上传", 500);
        try {
            byte[] bytes = image.getBytes();
            String imageName = UUID.randomUUID().toString();
            try {
                //使用base64方式上传到七牛云
                String imageUrl = QiniuCloudUtil.put64image(bytes, imageName);
                //url设置进数据库
                //当前是登录状态
                //获取当前用户信息——admin id; update!

                TGoodsImages goodsImages = new TGoodsImages();
                goodsImages.setImageUrl(imageUrl);

                /**
                 *确定id
                 */
                goodsImages.setGoodsId(1);
                //保存到数据库
                this.save(goodsImages);
                return BaseResult.success();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return BaseResult.success();
        } catch (IOException e) {
            return BaseResult.error();
        }

    }
}
