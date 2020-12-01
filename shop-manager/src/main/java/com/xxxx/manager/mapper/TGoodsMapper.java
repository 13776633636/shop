package com.xxxx.manager.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xxxx.manager.pojo.TGoods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TGoodsMapper extends BaseMapper<TGoods> {
    int updateBatch(List<TGoods> list);

    int updateBatchSelective(List<TGoods> list);

    int batchInsert(@Param("list") List<TGoods> list);

    int insertOrUpdate(TGoods record);

    int insertOrUpdateSelective(TGoods record);

    /**
     * 条件查询
     * @return
     */
    List<TGoods> querylist(TGoods goods);
}