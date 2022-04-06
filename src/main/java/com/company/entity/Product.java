package com.company.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author chenk
 * @date 2021/10/28 14:52
 * @description
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
        private Long pid;
        private Integer cid;
        private String title;
        private Double price; // 价格
        private String specification; // 规格
        private String img;
        private Integer stock; // 库存
        private String desc;
        private Date createTime; // 创建时间
        private Date updateTime; // 更新时间
}
