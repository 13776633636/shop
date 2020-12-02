package com.xxxx.rpc.service.impl;

import com.xxxx.common.result.ShopPageInfo;
import com.xxxx.rpc.service.SearchService;
import com.xxxx.rpc.vo.GoodsVo;
import org.apache.dubbo.config.annotation.Service;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 搜索服务实现类
 * 暴露服务
 */


@Service(interfaceClass = SearchService.class)
@Component
public class SearchServiceImpl implements SearchService {

    @Autowired
    private RestHighLevelClient restHighLevelClient;

    /**
     * 搜索
     *
     * @param searchStr
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public ShopPageInfo<GoodsVo> doSearch(String searchStr, Integer pageNum, Integer pageSize) {
        ShopPageInfo<GoodsVo> shopPageInfo = null;
        try {
            //指定索引库
            SearchRequest searchRequest = new SearchRequest("shop");
            //构建查询对象
            SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
            //设置分页的条件
            searchSourceBuilder.from((pageNum - 1) * pageSize).size(pageSize);
            //高亮显示
            HighlightBuilder highlightBuilder = new HighlightBuilder();
            //设置高亮字段，以及样式
            highlightBuilder.field("goodsName").preTags("<span style= 'color:red'>").postTags("</span>");
            searchSourceBuilder.highlighter(highlightBuilder);
            //添加查询条件
            searchSourceBuilder.query(QueryBuilders.multiMatchQuery(searchStr, "goodsName"));
            searchRequest.source(searchSourceBuilder);
            //执行请求
            List<GoodsVo> list =new ArrayList<>();
            SearchResponse response = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
            Long total = response.getHits().getTotalHits().value;
            if (0 > total) {
                return null;
            }
            SearchHit[] hits = response.getHits().getHits();
            for (SearchHit hit : hits) {
                Integer goodsId = Integer.valueOf((Integer) hit.getSourceAsMap().get("goodsId"));
                String goodsName = String.valueOf(hit.getSourceAsMap().get("goodsName"));
                String goodsNameHl = String.valueOf(hit.getHighlightFields().get("goodsName").fragments()[0]);
                BigDecimal marketPrice = new BigDecimal(String.valueOf(hit.getSourceAsMap().get("marketPrice")));
                String originalImg = String.valueOf(hit.getSourceAsMap().get("originalImg"));
                GoodsVo goodsVo = new GoodsVo(goodsId, goodsName, goodsNameHl, marketPrice, originalImg);
                list.add(goodsVo);
            }
            shopPageInfo = new ShopPageInfo<GoodsVo>(pageNum,pageSize,total.intValue());
            shopPageInfo.setResult(list);
            return shopPageInfo;
            //处理数据

        } catch (IOException e) {
            e.printStackTrace();
        }


        return null;
    }
}
