package com.company.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author chenk
 * @date 2021/10/27 14:47
 * @description 展示的数据 只需要先前台 展示他的部门名称
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "部门视图模型类")
public class DeptVO {
    @ApiModelProperty(value = "部门id")
    private Integer did;
    @ApiModelProperty(value = "部门名")
    private String deptName;
}
