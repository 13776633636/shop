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


        try{

            Credential cred = new Credential("AKIDxg9PXY2G0Z0A5kkLN9mE1YonWJrG3FqC", "HvJT5RWP2PUTCo9EFzShg6OgiSwpTqUy");

            HttpProfile httpProfile = new HttpProfile();
            httpProfile.setEndpoint("sms.tencentcloudapi.com");

            ClientProfile clientProfile = new ClientProfile();
            clientProfile.setHttpProfile(httpProfile);

            SmsClient client = new SmsClient(cred, "", clientProfile);

            SendSmsRequest req = new SendSmsRequest();
            String[] phoneNumberSet1 = {"8613776633636"};
            req.setPhoneNumberSet(phoneNumberSet1);

            req.setTemplateID("791387");
            req.setSmsSdkAppid("1400456423");
            req.setSign("java永远滴神");

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
