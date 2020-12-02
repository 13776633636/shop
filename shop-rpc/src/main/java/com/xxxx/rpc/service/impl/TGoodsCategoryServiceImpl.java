package com.xxxx.rpc.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xxxx.rpc.mapper.TGoodsCategoryMapper;
import com.xxxx.rpc.pojo.TGoodsCategory;
import com.xxxx.rpc.service.TGoodsCategoryService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Service(interfaceClass = TGoodsCategoryService.class)
@Component
public class TGoodsCategoryServiceImpl extends ServiceImpl<TGoodsCategoryMapper, TGoodsCategory> implements TGoodsCategoryService {

    @Autowired
    private TGoodsCategoryMapper goodsCategoryMapper;

    /**
     * 商品管理页面
     * 分层显示
     * 跳转商品分类的列表页
     *
     * @return
     */
    @Override
    public List<TGoodsCategory> listCategoryService() {
        List<TGoodsCategory> resultList = new ArrayList<>();

        //去redis中查询

        //去数据库查询数据
        List<TGoodsCategory> list = goodsCategoryMapper.listCategoryService();
        System.out.println(list);


        //对数据进行层级关系处理
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




}
