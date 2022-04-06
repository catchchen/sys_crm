package com.company.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author chenk
 * @date 2021/10/28 14:56
 * @description
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {
        private Integer cid;
        private String cateName;
        private Date createTime;
        private Date updateTime;
}
