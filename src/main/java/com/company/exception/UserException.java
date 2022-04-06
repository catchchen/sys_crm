package com.company.exception;

/**
 * @author chenk
 * @date 2021/11/2 13:23
 * @description 用户异常类
 */
public class UserException extends RuntimeException{
    public UserException(String message) {
        super(message);
    }
}
