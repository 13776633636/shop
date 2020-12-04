package com.xxxx.sso.service.impl;

import com.xxxx.common.pojo.Admin;
import com.xxxx.common.pojo.AdminExample;
import com.xxxx.common.utils.JsonUtil;
import com.xxxx.common.utils.Md5Util;
import com.xxxx.common.utils.UUIDUtil;
import com.xxxx.sso.mapper.AdminMapper;
import com.xxxx.sso.service.SSOService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;
@Service(interfaceClass = SSOService.class)
@Component
public class SSOServiceImpl implements SSOService {

    @Resource
    private AdminMapper adminMapper;

    @Resource
    private RedisTemplate<String, String> redisTemplate;
    @Value("${user.ticket}")
    private String userTicket;

    @Override
    public String login(Admin admin) {
        if (StringUtils.isEmpty(admin.getUserName().trim())){
            System.out.println("用户名不能为空！");
            return null;
        }
        if (StringUtils.isEmpty(admin.getPassword())) {
            System.out.println("密码不能为空！");
            return null;
        }
        AdminExample example=new AdminExample();
        example.createCriteria().andUserNameEqualTo(admin.getUserName());
        List<Admin>list=adminMapper.selectByExample(example);
        System.out.println(list.toString());
        if (CollectionUtils.isEmpty(list)||list.size()>1){
            System.out.println("用户名或密码错误！");
            return null;
        }
        Admin a=list.get(0);
        if (!a.getPassword().equals(Md5Util.getMd5WithSalt(admin.getPassword(),a.getEcSalt()))){
            System.out.println("用户名或密码错误！");
            return null;
        }

        //用户名和密码正确，返回票据
        //生成票据信息返回cookie，页面能借助票据ticket
        ValueOperations<String,String>valueOperations=redisTemplate.opsForValue();
        String ticket= UUIDUtil.getUUID();
        //设置30分钟后过期
        valueOperations.set(userTicket+":"+ticket, JsonUtil.object2JsonStr(a),30, TimeUnit.MINUTES);
        return ticket;
    }

    @Override
    public Admin validate(String ticket) {
        if (StringUtils.isEmpty(ticket)){
            return null;
        }
        ValueOperations<String,String>valueOperations=redisTemplate.opsForValue();
        String adminJson= valueOperations.get(userTicket + ":" + ticket);
        if (StringUtils.isEmpty(adminJson)){
            return null;
        }

        return  JsonUtil.jsonStr2Object(adminJson,Admin.class);
    }

    @Override
    public void logout(String ticket) {
        redisTemplate.delete(userTicket+":"+ticket);
    }
}
