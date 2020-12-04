package com.xxxx.portal.service.impl;

import com.tencentcloudapi.bri.v20190328.models.BRIRequest;
import com.tencentcloudapi.captcha.v20190722.CaptchaClient;
import com.tencentcloudapi.captcha.v20190722.models.DescribeCaptchaResultRequest;
import com.tencentcloudapi.captcha.v20190722.models.DescribeCaptchaResultResponse;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.tencentcloudapi.common.profile.ClientProfile;
import com.tencentcloudapi.common.profile.HttpProfile;
import com.xxxx.common.result.BaseResult;
import com.xxxx.portal.service.CaptchaService;

import com.tencentcloudapi.common.Credential;
import org.springframework.stereotype.Service;

@Service
public class CaptchaServiceImpl implements CaptchaService {
    @Override
    public BaseResult captcha(String ticket, String randStr) {


        try {

            Credential cred = new Credential("AKID0r5Io62VAhX6eYiYZS6VdWK3b1HWtIkx", "5vXhAf0GOec9qoLcryqaAO2byB7pIUTd");

            HttpProfile httpProfile = new HttpProfile();
            httpProfile.setEndpoint("captcha.tencentcloudapi.com");

            ClientProfile clientProfile = new ClientProfile();
            clientProfile.setHttpProfile(httpProfile);

            CaptchaClient client = new CaptchaClient(cred, "", clientProfile);

            DescribeCaptchaResultRequest req = new DescribeCaptchaResultRequest();
            req.setCaptchaType(9L);
            req.setUserIp("127.0.0.1");
            req.setRandstr(randStr);
            req.setCaptchaAppId(2095788030L);
            req.setAppSecretKey("0GSmVfwQqnB4tV8NJNrz4-w**");
            req.setTicket(ticket);

            DescribeCaptchaResultResponse resp = client.DescribeCaptchaResult(req);

            System.out.println(DescribeCaptchaResultResponse.toJsonString(resp));
            if ("ok".equalsIgnoreCase(resp.getCaptchaMsg())){
                return BaseResult.success();
            }else {
                return BaseResult.error();
            }
        } catch (TencentCloudSDKException e) {
            System.out.println(e.toString());
        }


        return null;

    }







}
