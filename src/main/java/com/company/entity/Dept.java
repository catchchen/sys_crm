package com.company.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author chenk
 * @date 2021/10/26 13:17
 * @description
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dept {
    private Integer did;
    private String deptName;
    private Date established;
    private Date createTime;
    private Date updateTime;
    private String createBy;
    private String updateBy;
}
