package com.xxxx.portal.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xxxx.portal.pojo.TAdmin;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TAdminMapper extends BaseMapper<TAdmin> {
    int updateBatch(List<TAdmin> list);

    int updateBatchSelective(List<TAdmin> list);

    int batchInsert(@Param("list") List<TAdmin> list);

    int insertOrUpdate(TAdmin record);

    int insertOrUpdateSelective(TAdmin record);
}