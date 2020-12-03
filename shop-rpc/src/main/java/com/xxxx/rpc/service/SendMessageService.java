package com.xxxx.rpc.service;

import com.xxxx.common.result.BaseResult;

/**
 * 短信发送服务
 */
public interface SendMessageService {
    BaseResult sendMessage(String phoneNumber);
}
