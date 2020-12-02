package com.xxxx.portal.controller;


import com.xxxx.rpc.pojo.TGoodsCategory;
import com.xxxx.rpc.service.TGoodsCategoryService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("goodsCategory")
public class GoodsController {
    /**
     * 注入rpc服务
     */
    @Reference(interfaceClass = TGoodsCategoryService.class)
    private TGoodsCategoryService goodsCategoryService;

    /**
     * 前台门户-所有商品分类
     * @return
     */
    @ResponseBody
    @RequestMapping("list")
    public List<TGoodsCategory> categoryList(){
        return goodsCategoryService.listCategoryService();
    }

}
