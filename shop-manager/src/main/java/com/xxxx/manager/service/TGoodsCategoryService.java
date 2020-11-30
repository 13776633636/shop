package com.xxxx.manager.service;

import com.xxxx.manager.pojo.TGoodsCategory;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface TGoodsCategoryService extends IService<TGoodsCategory>{

    List<TGoodsCategory> listCategoryService();

    /*查询顶级分类
    * */
    List<TGoodsCategory> selectCategoryTopList();

    /*
     * 商品分类-新增分类-级联查询
     * */
    List<TGoodsCategory> selectCategoryByParentId(Short parentId);

}
