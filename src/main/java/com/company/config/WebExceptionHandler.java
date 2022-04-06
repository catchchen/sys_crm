package com.company.config;

import com.company.common.Result;
import com.company.exception.UserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author chenk
 * @date 2021/11/2 13:15
 * @description
 */
@ControllerAdvice // 捕获全局的异常
@ResponseBody
public class WebExceptionHandler {
    private static Logger logger = LoggerFactory.getLogger(WebExceptionHandler.class);

    /**
     * 捕获数据校验的异常
     * @param e
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result methodArgumentNotValidException(MethodArgumentNotValidException e){
        ObjectError objectError = e.getBindingResult().getAllErrors().get(0);
        logger.warn(objectError.getDefaultMessage());
        return Result.failure().setMsg(objectError.getDefaultMessage());
    }
    /**
     * ConstraintViolationException异常的处理
     * @param e
     * @return
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public Result ConstraintViolationException(ConstraintViolationException e) {
        Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
        String message = violations.stream().map(ConstraintViolation::getMessage).collect(Collectors.joining(";"));
        // 然后提取错误提示信息进行返回
        return Result.failure().setMsg(message);
    }

    /**
     * BindException异常处理
     * @param e
     * @return
     */
    @ExceptionHandler(BindException.class)
    @ResponseBody
    public Result BindExceptionHandler(BindException e) {
        String message = e.getBindingResult().getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.joining(";"));
        return Result.failure().setMsg(message);// 流的写法 过滤数据
    }

    /**
     * 捕获用户异常类
     * @param e
     * @return
     */
    @ExceptionHandler(UserException.class)
    public Result userException(UserException e){
        logger.warn(e.getMessage());
        return Result.failure().setMsg(e.getMessage());
    }
    /**
     * 捕获异常基类，
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public Result exception(Exception e){
        logger.warn(e.getMessage());
        return Result.failure().setMsg("系统内部错误，请联系管理员");
    }
}
