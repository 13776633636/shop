package com.xxxx.rpc.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xxxx.rpc.pojo.TGoodsCategory;

import java.util.List;

public interface TGoodsCategoryMapper extends BaseMapper<TGoodsCategory> {
    List<TGoodsCategory> listCategoryService();
}