package com.company.vo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.ValidationEvent;

/**
 * @author chenk
 * @date 2021/10/26 16:26
 * @description Value Object 称 view Object
 * 用于展示的数据 user 需要展示他的部门名称
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "用户视图模型类")
public class UserVO {
    @ApiModelProperty(value = "用户ID")
    private Integer uid;
    @ApiModelProperty(value = "用户名")
    private String username;
    @ApiModelProperty(value = "邮箱")
    private String email;
    @ApiModelProperty(value = "电话")
    private String phone;
    @ApiModelProperty(value = "部门ID")
    private Integer did;
    @ApiModelProperty(value = "部门名称")
    private String deptName;
}