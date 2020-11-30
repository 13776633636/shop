package com.xxxx.manager.service.impl;


import com.xxxx.manager.utils.AssertUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;


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

    /**
     * 查询所有顶级分类
     */
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

    /**
     * 保存分类
     * @param goodsCategory
     * @return
     */
    @Override
    public boolean saveGoodsCategory(TGoodsCategory goodsCategory) {
        Byte sortOrder = goodsCategory.getSortOrder();
        if (sortOrder==null){
            goodsCategory.setSortOrder((byte) 50);
        }
        AssertUtils.isTrue(goodsCategory.getSortOrder() < 0 | goodsCategory.getSortOrder()>100,"请输入0-100之间的显示排序！",500);
        AssertUtils.isTrue(goodsCategory.getIsShow()==null,"是否展示不能为空",500);
        AssertUtils.isTrue(goodsCategory.getName()==null,"分类名称不能为空",500);
        return goodsCategoryMapper.saveGoodsCategory(goodsCategory) > 0 ? true : false;
    }


}
