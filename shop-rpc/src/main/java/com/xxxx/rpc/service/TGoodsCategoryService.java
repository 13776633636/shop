package com.xxxx.rpc.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.xxxx.rpc.pojo.TGoodsCategory;

import java.util.List;

public interface TGoodsCategoryService extends IService<TGoodsCategory> {

    /**
     * 商品管理页面
     * 分层显示
     * 跳转商品分类的列表页
     * @return
     */
    List<TGoodsCategory> listCategoryService();

}
