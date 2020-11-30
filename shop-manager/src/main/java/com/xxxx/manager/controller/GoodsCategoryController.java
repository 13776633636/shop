package com.xxxx.manager.controller;


import com.xxxx.manager.pojo.TGoodsCategory;
import com.xxxx.manager.service.TGoodsCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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
     *  分层显示
     *  跳转商品分类的列表页
     * @return
     */
   @RequestMapping("category/list")
   public ModelAndView listCategory() {
       ModelAndView mv = new ModelAndView();
       List<TGoodsCategory> list = goodsCategoryService.listCategoryService();
       mv.setViewName( "goods/category/category-list");
       mv.addObject("gcvList",list);
        return mv;
   }
   /*
   *
   * 跳转商品分类的添加页面
   * */
    @RequestMapping("category/add")
    public ModelAndView addCategory() {
       List <TGoodsCategory> list = goodsCategoryService.selectCategoryTopList();

        ModelAndView mv = new ModelAndView();
        mv.setViewName( "goods/category/category-add");
        mv.addObject("gcvList",list);

        return mv;
    }

    @ResponseBody
    @RequestMapping("category/{parentId}")

    /**
     * 商品添加-上级分类-顶级分类对应的子分类
     * @param parentId
     * @return
     */
    @ResponseBody
    @RequestMapping("category/{parentId}")
    public List<TGoodsCategory> selectCategoryByParentId(@PathVariable Short parentId){
        List<TGoodsCategory> list = goodsCategoryService.selectCategoryByParentId(parentId);
        return  list;
    }
    @ResponseBody
    @RequestMapping("")
    public Model selectList(Model model){

       return model;
    }


}
