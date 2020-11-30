package com.xxxx.manager.controller;


import com.xxxx.common.result.BaseResult;
import com.xxxx.manager.pojo.TGoodsCategory;
import com.xxxx.manager.service.TGoodsCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("goods")
public class GoodsCategoryController {
    @Autowired
    private TGoodsCategoryService goodsCategoryService;

    /**
     * 商品管理页面
     * 分层显示
     * 跳转商品分类的列表页
     *
     * @return
     */
    @RequestMapping("category/list")
    public ModelAndView listCategory() {
        ModelAndView mv = new ModelAndView();
        List<TGoodsCategory> list = goodsCategoryService.listCategoryService();
        mv.setViewName("goods/category/category-list");
        mv.addObject("gcvList", list);
        return mv;
    }


    /*
     * 跳转商品分类的添加页面
     * */

    @RequestMapping("category/add")
    public ModelAndView addCategory() {
        //查询数据
        List<TGoodsCategory> list = goodsCategoryService.selectCategoryTopList();
        ModelAndView mv = new ModelAndView();
        //设置需要返回的视图
        mv.setViewName("goods/category/category-add");
        //将添加页面所需要的数据加入到视图中
        mv.addObject("gcList", list);

        return mv;
    }


    /**
     * 商品分类-新增分类-级联查询
     *
     * @param parentId
     * @return
     */
    @ResponseBody
    @RequestMapping("category/{parentId}")
    public List<TGoodsCategory> selectCategoryByParentId(@PathVariable Short parentId) {
        List<TGoodsCategory> list = goodsCategoryService.selectCategoryByParentId(parentId);
        return list;
    }

    /**
     * 商品分类-新增分类-保存分类
     * @param goodsCategory
     * @return
     */
    @ResponseBody
    @RequestMapping("category/save")
    public BaseResult selectList(TGoodsCategory goodsCategory) {
        System.out.println(goodsCategory);
        boolean b = goodsCategoryService.saveGoodsCategory(goodsCategory);
        return b ? BaseResult.success() : BaseResult.error();
    }


}
