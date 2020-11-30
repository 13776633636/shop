package com.xxxx.manager.utils;


import com.xxxx.manager.exception.MyException;

public class AssertUtils {

    public static void isTrue(boolean flag, String msg, Integer code) {
        if (flag) {
           throw new MyException(msg,code);
        }
    }



}


