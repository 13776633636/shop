package com.xxxx.manager.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xxxx.manager.pojo.TGoodsCategory;
import com.xxxx.manager.mapper.TGoodsCategoryMapper;
import com.xxxx.manager.service.TGoodsCategoryService;

@Service
public class TGoodsCategoryServiceImpl extends ServiceImpl<TGoodsCategoryMapper, TGoodsCategory> implements TGoodsCategoryService {

    @Autowired
    private TGoodsCategoryMapper goodsCategoryMapper;

    @Override
    public List<TGoodsCategory> listCategoryService() {
        List<TGoodsCategory> resultList = new ArrayList<>();

        List<TGoodsCategory> list = goodsCategoryMapper.listCategoryService();
        System.out.println(list);


        for (TGoodsCategory goodsCategory : list) {
            int id = goodsCategory.getId();
            List<TGoodsCategory> child = new ArrayList<>();
            for (TGoodsCategory deptChild : list) {
                if (id == deptChild.getParentId()) {
                    child.add(deptChild);
                }
            }
            goodsCategory.setChildren(child);
            if (goodsCategory.getParentId() == 0) {
                resultList.add(goodsCategory);
            }
        }
        System.out.println(resultList);
        return resultList;


    }

    /*查询所有顶级分类
     * */
    @Override
    public List<TGoodsCategory> selectCategoryTopList() {
        List<TGoodsCategory> list = goodsCategoryMapper.selectCategoryTopList();
        return list;
    }

    /*
     * 商品分类-新增分类-级联查询
     * */
    @Override
    public List<TGoodsCategory> selectCategoryByParentId(Short parentId) {
        List<TGoodsCategory> list = goodsCategoryMapper.selectCategoryByParentId(parentId);
        return list;
    }
}
