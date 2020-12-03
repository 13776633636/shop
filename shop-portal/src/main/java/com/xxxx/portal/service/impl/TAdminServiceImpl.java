package com.xxxx.portal.service.impl;

import org.springframework.stereotype.Service;

import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xxxx.portal.pojo.TAdmin;
import com.xxxx.portal.mapper.TAdminMapper;
import com.xxxx.portal.service.TAdminService;
@Service
public class TAdminServiceImpl extends ServiceImpl<TAdminMapper, TAdmin> implements TAdminService{

    @Override
    public int updateBatch(List<TAdmin> list) {
        return baseMapper.updateBatch(list);
    }
    @Override
    public int updateBatchSelective(List<TAdmin> list) {
        return baseMapper.updateBatchSelective(list);
    }
    @Override
    public int batchInsert(List<TAdmin> list) {
        return baseMapper.batchInsert(list);
    }
    @Override
    public int insertOrUpdate(TAdmin record) {
        return baseMapper.insertOrUpdate(record);
    }
    @Override
    public int insertOrUpdateSelective(TAdmin record) {
        return baseMapper.insertOrUpdateSelective(record);
    }
}
