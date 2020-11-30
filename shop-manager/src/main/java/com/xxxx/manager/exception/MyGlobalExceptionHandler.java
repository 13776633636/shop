package com.xxxx.manager.exception;



import com.xxxx.common.result.BaseResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;


@ControllerAdvice
public class MyGlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public BaseResult exceptionHandler(Exception e) {
        //Map map = new HashMap<>();
        BaseResult resultInfo = new BaseResult();

        resultInfo.setCode(500);
        resultInfo.setMessage("未解决的异常！");

        if (e instanceof MyException) {
            MyException pe = (MyException) e;
            resultInfo.setCode(pe.getCode());
            resultInfo.setMessage(pe.getMsg());
        }
        if (e instanceof NullPointerException){
            resultInfo.setCode(500);
            resultInfo.setMessage("空指针异常");

        }
        if (e instanceof IOException){
            resultInfo.setCode(500);
            resultInfo.setMessage("IOException");

        }
        return resultInfo;
    }

}
