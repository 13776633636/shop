package com.xxxx.portal.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.xxxx.common.pojo.TAdmin;
import com.xxxx.common.result.BaseResult;

import java.util.List;

public interface TAdminService extends IService<TAdmin> {

    /**
     * 用户保存
     */
    BaseResult saveUser(com.xxxx.common.pojo.TAdmin admin);
}
