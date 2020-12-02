package com.xxxx.rpc.service;

import com.xxxx.manager.pojo.TGoodsCategory;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface TGoodsCategoryService extends IService<TGoodsCategory>{

    /**
     * 商品管理页面
     * 分层显示
     * 跳转商品分类的列表页
     *
     * @return
     */
    List<TGoodsCategory> listCategoryService();

    /**
     * 查询顶级分类
     * @return
     */
    List<TGoodsCategory> selectCategoryTopList();


    /**
     * 商品分类-新增分类-级联查询
     *
     */
    List<TGoodsCategory> selectCategoryByParentId(Short parentId);


    /**
     * 保存分类
     * @param goodsCategory
     * @return
     */
    boolean saveGoodsCategory(TGoodsCategory goodsCategory);
}
