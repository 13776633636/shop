package com.xxxx.portal.service;

import com.xxxx.common.result.BaseResult;

public interface CaptchaService {

    BaseResult captcha(String ticket, String randStr);

}
