package com.company.common;

import com.company.constant.Status;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

/**
 * @author chenk
 * @date 2021/10/26 13:39
 * @description
 */
@ToString
@ApiModel(value = "通用返回结果")
public class Result<T> {

    @ApiModelProperty(value = "响应码")
    private Integer status;
    @ApiModelProperty(value = "响应信息")
    private String msg;
    @ApiModelProperty(value = "响应数据")
    private T data;

    public Result() {
    }

    public Integer getStatus() {
        return status;
    }

    public Result setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public Result setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public T getData() {
        return data;
    }

    public Result setData(T data) {
        this.data = data;
        return this;
    }

    /**
     * request success 响应结果
     * @return
     */
    public static Result success(){
        return new Result().setStatus(Status.SUCCESS_CODE);
    }

    /**
     * request failure 的结果
     * @return
     */
    public static Result failure(){
        return new Result().setStatus(Status.FAILURE_CODE);
    }
}
