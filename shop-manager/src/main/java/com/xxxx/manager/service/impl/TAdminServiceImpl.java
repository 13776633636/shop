package com.xxxx.manager.service.impl;

import org.springframework.stereotype.Service;

import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xxxx.manager.mapper.TAdminMapper;
import com.xxxx.common.pojo.TAdmin;

@Service
public class TAdminServiceImpl extends ServiceImpl<TAdminMapper, TAdmin> implements TAdminService{

    @Override
    public int updateBatch(List<TAdmin> list) {
        return baseMapper.updateBatch(list);
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
