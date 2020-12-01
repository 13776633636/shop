package com.xxxx.manager.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xxxx.common.result.BaseResult;
import com.xxxx.manager.pojo.TGoods;

import java.util.List;
public interface TGoodsService extends IService<TGoods>{



    int updateBatch(List<TGoods> list);

    int updateBatchSelective(List<TGoods> list);

    int batchInsert(List<TGoods> list);

    int insertOrUpdate(TGoods record);

    int insertOrUpdateSelective(TGoods record);

    /**
     * 查询所有的goods
     * @return
     */
    BaseResult selectList(TGoods goods);
}
