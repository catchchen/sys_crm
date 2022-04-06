package com.company.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 用于和前端的传输  向外围提供需要的字段
 * @author chenk
 * @date 2021/10/26 16:22
 * @description userdto Data Transfer Object类 数据传输对象
 * 用于登录 和 修改密码
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    // 后端值的校验
    private Integer uid;
    @NotNull(message = "{user.username}")
    @Size(min = 5,max = 18,message = "用户名必须在5到18个字符之间")
    private String username;
    @NotNull(message = "密码不能为空")
    @Size(min = 5,max = 18,message = "密码长度必须在5到18个字符之间")
    private String password;
    private String newPassword;
}
