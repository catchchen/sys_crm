package com.company.service.impl;

import com.company.constant.UserConst;
import com.company.dto.UserDTO;
import com.company.entity.User;
import com.company.exception.UserException;
import com.company.mapper.UserMapper;
import com.company.service.UserService;
import com.company.vo.UserVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author chenk
 * @date 2021/10/26 13:31
 * @description
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    /**
     * login
     * @param username
     * @param password
     * @return
     */
    @Override
    public User login(String username, String password) {
        return userMapper.selectUserByUsernameAndPassword(username, password);
    }

    /**
     * 通过部门名称 或用户名 查询用户
     * @param username
     * @param did 部门id
     * @return
     */
    @Override
    public List<UserVO> getByUsernameOrDid(String username, Integer did) {
        return userMapper.selectUsers(username,did);
    }

    @Override
    @Transactional // 数据增删改 需要开启事务
    public boolean removeUserByUid(Integer uid) {
        int rows = userMapper.deleteUserByUid(uid);
        if(rows > 0){
            return true;
        }else {
            logger.warn("UID为"+uid+"的数据删除失败");
            throw new UserException("数据删除失败");
        }
    }

    /**
     * 添加用户
     * @param user
     * @return
     */
    @Override
    @Transactional
    public boolean addUser(User user) {
        // service 处理业务 添加默认密码
        user.setPassword(UserConst.DEFAULT_PWD);
        // 添加默认时间
        Date now = new Date();
        user.setCreateTime(now);
        user.setUpdateTime(now);

        int rows = userMapper.insertUser(user);
        if(rows > 0) return true;
        else {
            logger.warn("添加用户失败");
            throw new UserException("添加用户数据失败");
        }
    }

    /**
     * 通过主键得到用户的信息
     * @param uid
     * @return
     */
    @Override
    public User getUserByUid(Integer uid) {
        return userMapper.selectUserByUid(uid);
    }

    @Override
    @Transactional
    public boolean editUser(User user) {
        Date now = new Date();
        user.setUpdateTime(now);
        int i = userMapper.updateUser(user);
        if(i > 0) {
            return true;
        } else {
            logger.warn("修改用户数据失败"+user);
            throw new UserException("修改用户数据失败");
        }
    }

    @Override
    @Transactional
    public boolean modifyPassword(UserDTO userDTO) {
        Integer uid = userDTO.getUid();
        User selectUserByUid = userMapper.selectUserByUid(uid);
        String password = selectUserByUid.getPassword();
        if (!password.equals(userDTO.getPassword())){
            logger.warn("输入的密码不正确");
            return false;
        }
        int i = userMapper.updateUserPassword(uid, userDTO.getNewPassword());
        if (i > 0){
            return true;
        }
        else {
            logger.warn("修改密码失败");
            throw new UserException("修改密码失败");
        }
    }
}
