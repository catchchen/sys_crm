package com.company.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author chenk
 * @date 2021/11/4 8:57
 * @description
 */
@ApiModel("分类视图模型数据")
public class CategoryVO {
    @ApiModelProperty(value = "分类ID")
    private Integer cid;
    @ApiModelProperty(value = "分类")
    private String cateName;
}
