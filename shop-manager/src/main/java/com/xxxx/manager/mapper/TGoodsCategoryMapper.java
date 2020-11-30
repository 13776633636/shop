package com.xxxx.manager.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xxxx.manager.pojo.TGoodsCategory;

import java.util.List;

public interface TGoodsCategoryMapper extends BaseMapper<TGoodsCategory> {
    List<TGoodsCategory> listCategoryService();

    List<TGoodsCategory> selectCategoryTopList();

    /*
    * 商品分类-新增分类-级联查询
    * */
    List<TGoodsCategory> selectCategoryByParentId(Short parentId);

    /**
     * 保存分类
     * @param goodsCategory
     * @return
     */
    int saveGoodsCategory(TGoodsCategory goodsCategory);
}