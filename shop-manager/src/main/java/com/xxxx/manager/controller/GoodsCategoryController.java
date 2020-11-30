package com.xxxx.manager.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("goods")
public class GoodsCategoryController {


   @RequestMapping("category/list")
   public String listCategory() {
        return "goods/category/category-list";
   }

    @RequestMapping("category/add")
    public String addCategory() {
        return "goods/category/category-add";
    }

}
