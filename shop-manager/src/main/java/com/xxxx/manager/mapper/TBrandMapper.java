package com.xxxx.manager.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xxxx.manager.pojo.TBrand;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TBrandMapper extends BaseMapper<TBrand> {
    int updateBatch(List<TBrand> list);

    int updateBatchSelective(List<TBrand> list);

    int batchInsert(@Param("list") List<TBrand> list);

    int insertOrUpdate(TBrand record);

    int insertOrUpdateSelective(TBrand record);
}