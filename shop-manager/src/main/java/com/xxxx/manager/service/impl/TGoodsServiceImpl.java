package com.xxxx.manager.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xxxx.common.result.BaseResult;
import com.xxxx.manager.mapper.TGoodsMapper;
import com.xxxx.manager.pojo.TGoods;
import com.xxxx.manager.service.TGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TGoodsServiceImpl extends ServiceImpl<TGoodsMapper, TGoods> implements TGoodsService {

    @Autowired
    private TGoodsMapper goodsMapper;

    @Override
    public int updateBatch(List<TGoods> list) {
        return baseMapper.updateBatch(list);
    }

    @Override
    public int updateBatchSelective(List<TGoods> list) {
        return baseMapper.updateBatchSelective(list);
    }

    @Override
    public int batchInsert(List<TGoods> list) {
        return baseMapper.batchInsert(list);
    }

    @Override
    public int insertOrUpdate(TGoods record) {
        return baseMapper.insertOrUpdate(record);
    }

    @Override
    public int insertOrUpdateSelective(TGoods record) {
        return baseMapper.insertOrUpdateSelective(record);
    }

    @Override
    public BaseResult selectList(TGoods goods) {
        BaseResult baseResult = new BaseResult();
        //开启分页
        PageHelper.startPage(goods.getPageNum(), goods.getPageSize());
        List<TGoods> list = goodsMapper.querylist(goods);
        PageInfo<TGoods> pageInfo = new PageInfo<>(list);
        //System.out.println(pageInfo);

        baseResult.setCode(200);
        baseResult.setMessage("");
        baseResult.setPageInfo(pageInfo);

        return baseResult;
    }

    /**
     * 新增商品
     *
     * @param goods
     * @return
     */
    @Override
    public BaseResult savegoods(TGoods goods) {
        BaseResult baseResult = new BaseResult();
        int i = goodsMapper.insertOrUpdateSelective(goods);
        Integer goodsId = goods.getGoodsId();
        baseResult.setMessage(goodsId.toString());
        baseResult.setCode(200);
        return baseResult;
    }

}
