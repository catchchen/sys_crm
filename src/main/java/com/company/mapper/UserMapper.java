package com.company.mapper;

import com.company.dto.UserDTO;
import com.company.entity.User;
import com.company.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author chenk
 * @date 2021/10/26
 * @description 功能
 */
@Mapper // 启动类中添加包扫描也可以
public interface UserMapper {
    /**
     * find User for login
     * @param username
     * @param password
     * @return
     */
    User selectUserByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

    /**
     * 根据 username 或 deptName查询 所有的用户
     * @param username
     * @param did
     * @return
     */
    List<UserVO> selectUsers(@Param("username") String username,
                             @Param("did") Integer did);

    /**
     * 通过主键删除
     * @param uid
     * @return
     */
    int deleteUserByUid(@Param("uid") Integer uid);

    /**
     * 添加用户
     * @param user 传入要添加的对象
     * @return
     */
    int insertUser(User user);

    /**
     * 通过主键 查询用户
     * @param uid
     * @return
     */
    User selectUserByUid(@Param("uid") Integer uid);

    /**
     * 根据传输过来的用户对象 修改用户
     * @param user
     * @return
     */
    int updateUser(User user);

    /**
     * 通过 uid
     * 修改用户密码
     * @param uid 用户id
     * @param newPassword
     * @return
     */
    int updateUserPassword(@Param("uid") Integer uid,@Param("newPassword") String newPassword);

}
