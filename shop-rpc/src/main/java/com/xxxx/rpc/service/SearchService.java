package com.xxxx.rpc.service;


import com.xxxx.common.result.ShopPageInfo;
import com.xxxx.rpc.vo.GoodsVo;

/**
 *
 * 搜索服务
 *
 */
public interface SearchService {

    ShopPageInfo<GoodsVo> doSearch(String searchStr, Integer pageNum, Integer pageSize);
}
