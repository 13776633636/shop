package com.xxxx.manager.service.impl;

import java.util.List;
import com.xxxx.common.pojo.TAdmin;
import com.baomidou.mybatisplus.extension.service.IService;
public interface TAdminService extends IService<TAdmin>{


    int updateBatch(List<TAdmin> list);

    int batchInsert(List<TAdmin> list);

    int insertOrUpdate(TAdmin record);

    int insertOrUpdateSelective(TAdmin record);

}
