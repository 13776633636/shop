package com.xxxx.portal.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xxxx.common.pojo.TAdmin;
import com.xxxx.common.result.BaseResult;
import com.xxxx.common.utils.Md5Util;
import com.xxxx.common.utils.RandomUtil;
import com.xxxx.portal.mapper.TAdminMapper;
import com.xxxx.portal.service.TAdminService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;


@Service
public class TAdminServiceImpl extends ServiceImpl<TAdminMapper, TAdmin> implements TAdminService {

    /**
     * 用户注册
     * @param admin
     * @return
     */

    @Override
    public BaseResult saveUser(TAdmin admin) {
        String random1 = RandomUtil.getRandom1();
        admin.setEcSalt(random1);
        String password = Md5Util.getMd5WithSalt(admin.getPassword(), random1);
        admin.setPassword(password);
        admin.setAddTime((int) LocalDateTime.now().toEpochSecond(ZoneOffset.of("+8")));
        admin.setAddTime((int) System.currentTimeMillis());
        admin.setLastLogin(1473055070);
        admin.setLastIp("183.14.137.252");
        admin.setNavList("商品列表|goods.php?act=list,订单列表|order.php?act=list,用户评论|comment_manage.php?act=list,会员列表|users.php?act=list,商店设置|shop_config.php?act=list_edit");
       return this.save(admin)?BaseResult.success():BaseResult.error();
    }
}
