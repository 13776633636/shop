package com.xxxx.sso.service.impl;

import com.xxxx.common.pojo.TAdmin;
import com.xxxx.common.utils.JsonUtil;
import com.xxxx.common.utils.Md5Util;
import com.xxxx.common.utils.UUIDUtil;
import com.xxxx.sso.service.SSOService;
import com.xxxx.sso.service.TAdminService;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 单点登录服务实现类
 */

@Service(interfaceClass = SSOService.class)
@Component
public class SSOServiceImpl implements SSOService {

    @Autowired
    private TAdminService adminService;
    @Autowired
    private RedisTemplate<String,String> redisTemplate;
    @Value("${user.ticket}")
    private String userTicket;


    /**
     * 登录认证方法返回ticket
     * @param admin
     * @return
     */
    @Override
    public String login(TAdmin admin) {
        if (StringUtils.isEmpty(admin.getUserName())){
            System.out.println("用户名为空");
            return null;
        }
        if (StringUtils.isEmpty(admin.getPassword())){
            System.out.println("密码为空");
            return null;
        }
        List<TAdmin> user = adminService.getByUserName(admin.getUserName());
        if (CollectionUtils.isEmpty(user) || user.size()>1){
            System.out.println("用户名或者密码错误");
            return null;
        }
        TAdmin a = user.get(0);
        if (!a.getPassword().equals(Md5Util.getMd5WithSalt(admin.getPassword(),a.getEcSalt()))){
            System.out.println("密码错误 ");
            return null;
        }
        //登录成功，返回票据信息，存cookies
        ValueOperations<String, String> stringStringValueOperations = redisTemplate.opsForValue();
        String ticke = UUIDUtil.getUUID();
        stringStringValueOperations.set(userTicket+":"+ticke, JsonUtil.object2JsonStr(a),30, TimeUnit.MINUTES);
        return ticke;
    }

    /**
     * 验证票据信息，返回用户信息
     * @param ticket
     * @return
     */
    @Override
    public TAdmin validdate(String ticket) {
        if (StringUtils.isEmpty(ticket)){
            System.out.println("票据信息不存在");
            return null;
        }
        ValueOperations<String, String> opsForValue = redisTemplate.opsForValue();
        String s = opsForValue.get(userTicket + ":" + ticket);
        if (StringUtils.isEmpty(s)){
            System.out.println("票据对应的用户信息不存在");
            return null;
        }
        return JsonUtil.jsonStr2Object(s,TAdmin.class);

    }
}
