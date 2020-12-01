package com.xxxx.manager.controller;


import com.xxxx.common.result.FileResult;
import com.xxxx.manager.service.TGoodsImagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("fileUpload")
public class GoodsImageController {

    @Autowired
    private TGoodsImagesService goodsImagesService;

    @RequestMapping("save")
    public FileResult fileUpload(@RequestParam(value = "file") MultipartFile image, HttpServletRequest request) {
        FileResult fileResult = goodsImagesService.fileUpload(image, request);
        System.out.println(fileResult.getFileUrl());
        return fileResult;

    }



}
