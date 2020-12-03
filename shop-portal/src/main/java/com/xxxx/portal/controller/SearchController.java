package com.xxxx.portal.controller;

import com.xxxx.common.result.ShopPageInfo;
import com.xxxx.rpc.service.SearchService;
import com.xxxx.rpc.vo.GoodsVo;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("search")
public class SearchController {
//    注入rpc服务
    @Reference(interfaceClass = SearchService.class)
    private SearchService searchService;


    @RequestMapping("index")
    public String index (String searchStr, Model model){
        model.addAttribute("searchStr", searchStr);

        return "search/doSearch";
    }

    /**
     *搜索功能
     */
    @ResponseBody
    @RequestMapping("searchGoods")
    public ShopPageInfo<GoodsVo> searchGoods(String searchStr,Integer pageNum,Integer pageSize){

        return searchService.doSearch(searchStr,pageNum,pageSize);
    }
}
