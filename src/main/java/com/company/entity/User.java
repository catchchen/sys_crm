package com.company.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author chenk
 * @date 2021/10/26 13:12
 * @description
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer uid;
    private String username;
    @JsonIgnore
    private String password;
    private String email;
    private String phone;
    private Integer did;
    @JsonIgnore
    private Date createTime;
    @JsonIgnore
    private Date updateTime;
}
