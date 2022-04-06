package com.company.common;

import com.company.constant.Status;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.ToString;

/**
 * @author chenk
 * @date 2021/10/28 11:25
 * @description
 */
// 查询的分类数据
@ToString
@ApiModel(value = "通用返回结果带分页")
public class ResultPage<T> {
    @ApiModelProperty(value = "响应状态")
    private Integer status;
    @ApiModelProperty(value = "响应消息")
    private String msg;
    @ApiModelProperty(value = "响应总条数")
    private Long total;// 查询的总数
    @ApiModelProperty(value = "响应数据")
    private T data;

    public Integer getStatus() {
        return status;
    }

    public ResultPage setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public ResultPage setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public Long getTotal() {
        return total;
    }

    public ResultPage setTotal(Long total) {
        this.total = total;
        return this;
    }

    public T getData() {
            return data;
        }

    public ResultPage setData(T data) {
        this.data = data;
        return this;
    }
    /**
     * request success 响应结果
     * @return
     */
    public static ResultPage success(){
        return new ResultPage().setStatus(Status.SUCCESS_CODE);
    }

    /**
     * request failure 的结果
     * @return
     */
    public static ResultPage failure(){
        return new ResultPage().setStatus(Status.FAILURE_CODE);
    }
}

