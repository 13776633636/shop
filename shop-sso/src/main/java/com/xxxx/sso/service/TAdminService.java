package com.xxxx.sso.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xxxx.common.pojo.TAdmin;

import java.util.List;
public interface TAdminService extends IService<TAdmin>{


    int updateBatch(List<TAdmin> list);

    int batchInsert(List<TAdmin> list);

    int insertOrUpdate(TAdmin record);

    int insertOrUpdateSelective(TAdmin record);

    List<TAdmin> getByUserName(String userName);
}
