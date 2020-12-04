package com.xxxx.rpc.service.impl;


import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.tencentcloudapi.common.profile.ClientProfile;
import com.tencentcloudapi.common.profile.HttpProfile;
import com.tencentcloudapi.sms.v20190711.SmsClient;
import com.tencentcloudapi.sms.v20190711.models.SendSmsRequest;
import com.tencentcloudapi.sms.v20190711.models.SendSmsResponse;
import com.xxxx.common.result.BaseResult;
import com.xxxx.rpc.service.SendMessageService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;


/**
 * 暴露发送短信的服务
 *
 */
@Component
@Service(interfaceClass = SendMessageService.class)
public class SendMessageServiceImpl implements SendMessageService {
    @Override
    public BaseResult sendMessage(String phoneNumber) {


        try {
            //实例化认证对象，获取签名串
            Credential cred = new Credential("AKID0r5Io62VAhX6eYiYZS6VdWK3b1HWtIkx", "5vXhAf0GOec9qoLcryqaAO2byB7pIUTd");
            //实例化Httoprofile对象，调用短信发送的接口的url
            HttpProfile httpProfile = new HttpProfile();
            httpProfile.setEndpoint("sms.tencentcloudapi.com");
//            实例化clientprofile对象
            ClientProfile clientProfile = new ClientProfile();
            clientProfile.setHttpProfile(httpProfile);
//            实例化sms客户端
            SmsClient client = new SmsClient(cred, "", clientProfile);

            SendSmsRequest req = new SendSmsRequest();
            String[] phoneNumberSet1 = {"86"+phoneNumber};
            req.setPhoneNumberSet(phoneNumberSet1);

            req.setTemplateID("795462");
            req.setSmsSdkAppid("1400455942");
            req.setSign("爱玩爱笑");
//            发送请求
            SendSmsResponse resp = client.SendSms(req);
            if ("ok".equalsIgnoreCase(resp.getSendStatusSet()[0].getCode())){
                return BaseResult.success();
            }
            System.out.println(SendSmsResponse.toJsonString(resp));
        } catch (TencentCloudSDKException e) {
            System.out.println(e.toString());
        }
        return BaseResult.error();

    }
}
