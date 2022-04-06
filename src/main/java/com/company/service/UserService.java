package com.company.service;

import com.company.dto.UserDTO;
import com.company.entity.User;
import com.company.vo.UserVO;

import java.util.List;

/**
 * @author chenk
 * @date 2021/10/26 13:29
 * @description
 */
public interface UserService {
    /**
     * login
     * @param username
     * @param password
     * @return
     */
    User login(String username, String password);

    /**
     * 通过部门名称 或用户名 查询用户
     * @param username
     * @param did
     * @return
     */
    List<UserVO> getByUsernameOrDid(String username,Integer did);

    /**
     * 通过主键删除用户
     * @param uid
     * @return
     */
    boolean removeUserByUid(Integer uid);
    /**
     * 添加用户
     */
    boolean addUser(User user);

    /**
     * 通过主键获取用户信息
     * @param uid
     * @return
     */
    User getUserByUid(Integer uid);

//     boolean modifyUser(User user);
    // get search find
    // remove
    boolean editUser(User user);

    /**
     * 根据传输过来 传输对象 更改密码
     * @param userDTO
     * @return
     */
    boolean modifyPassword(UserDTO userDTO);
}
