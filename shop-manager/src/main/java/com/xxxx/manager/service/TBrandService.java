package com.xxxx.manager.service;

import java.util.List;
import com.xxxx.manager.pojo.TBrand;
import com.baomidou.mybatisplus.extension.service.IService;
public interface TBrandService extends IService<TBrand>{


    int updateBatch(List<TBrand> list);

    int updateBatchSelective(List<TBrand> list);

    int batchInsert(List<TBrand> list);

    int insertOrUpdate(TBrand record);

    int insertOrUpdateSelective(TBrand record);

}
