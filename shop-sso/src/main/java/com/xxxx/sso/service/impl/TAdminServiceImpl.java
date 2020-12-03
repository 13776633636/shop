package com.xxxx.sso.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xxxx.common.pojo.TAdmin;
import com.xxxx.sso.mapper.TAdminMapper;
import com.xxxx.sso.service.TAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TAdminServiceImpl extends ServiceImpl<TAdminMapper, TAdmin> implements TAdminService {
    @Autowired
    private TAdminMapper adminMapper;

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

    @Override
    public List<TAdmin> getByUserName(String userName) {
        List<TAdmin> user = adminMapper.selectByName(userName);
        return user;
    }
}
