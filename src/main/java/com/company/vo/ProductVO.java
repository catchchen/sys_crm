package com.company.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author chenk
 * @date 2021/10/28 16:35
 * @description
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "商品视图模型类")
public class ProductVO {
    @ApiModelProperty("商品id")
    private Long pid; // 商品id
    @ApiModelProperty("分类名")
    private String cateName; // 分类名
    @ApiModelProperty("商品名")
    private String title; // 商品名称
    @ApiModelProperty("价格")
    private Double price; // 价格
    @ApiModelProperty("图片地址")
    private String img; // 图片地址 网络或本地资源
    @ApiModelProperty("规格")
    private String specification; // 规格
    @ApiModelProperty("库存")
    private Integer stock;  // 库存
    @ApiModelProperty("描述")
    private String desc; // 描述
    @ApiModelProperty("创建时间")
    private Date createTime; // 创建(上架)时间
}
