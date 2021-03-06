package com.xxxx.manager.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xxxx.manager.mapper.TBrandMapper;
import java.util.List;
import com.xxxx.manager.pojo.TBrand;
import com.xxxx.manager.service.TBrandService;
@Service
public class TBrandServiceImpl extends ServiceImpl<TBrandMapper, TBrand> implements TBrandService{

    @Override
    public int updateBatch(List<TBrand> list) {
        return baseMapper.updateBatch(list);
    }
    @Override
    public int updateBatchSelective(List<TBrand> list) {
        return baseMapper.updateBatchSelective(list);
    }
    @Override
    public int batchInsert(List<TBrand> list) {
        return baseMapper.batchInsert(list);
    }
    @Override
    public int insertOrUpdate(TBrand record) {
        return baseMapper.insertOrUpdate(record);
    }
    @Override
    public int insertOrUpdateSelective(TBrand record) {
        return baseMapper.insertOrUpdateSelective(record);
    }
}
