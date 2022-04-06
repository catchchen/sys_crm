package com.company.controller;

import com.company.common.Result;
import com.company.common.ResultPage;
import com.company.constant.UserConst;
import com.company.dto.UserDTO;
import com.company.entity.User;
import com.company.service.UserService;
import com.company.vo.UserVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author chenk
 * @date 2021/10/26 13:36
 * @description
 */

@RestController
@Api(value = "UserController", tags = "用户相关接口文档")
public class UserController {
    @Autowired
    private UserService userService;
    // 日志
    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Result login(@RequestBody @Valid UserDTO userDTO){
        User user = userService.login(userDTO.getUsername(), userDTO.getPassword());
        Result<User> result;
        if(user != null){
            result = Result.success().setMsg(UserConst.LOGIN_SECCESS).setData(user);
        }else{
            logger.warn("登陆失败,账号："+userDTO.getUsername()+",密码："+userDTO.getPassword());
            result = Result.failure().setMsg(UserConst.LOGIN_FAILURE);
        }
          return result;
    }

    /**
     *  根据 username 或 deptId查询 所有的用户
     * @param username
     * @param did
     * @returnusername
     */
    @ApiOperation(value ="通过用户名或部门id查询用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name="username",value = "用户名",required = false),
            @ApiImplicitParam(name="did",value = "部门ID",required = false),
            @ApiImplicitParam(name = "pageNum",value = "页码",required = true),
            @ApiImplicitParam(name = "pageSize",value = "每页条数",required = true)
    })
    @RequestMapping(value = "/users",method = RequestMethod.GET)
    public ResultPage getUsers(@RequestParam(value = "username",required = false) String username,
                               @RequestParam(value = "did",required = false) Integer did,
                               @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum, // 做分页处理 默认 一页五条数据
                               @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize// 每页 的条数
                               ){
        PageHelper.startPage(pageNum,pageSize);
        List<UserVO> userVOs = userService.getByUsernameOrDid(username, did);
        PageInfo<UserVO> pageInfo = new PageInfo<>(userVOs);
        return ResultPage
                .success()
                .setMsg("")
                .setData(pageInfo.getList())
                .setTotal(pageInfo.getTotal());
    }



    @RequestMapping(value = "/deleteUser/{uid}",method = RequestMethod.GET)
    public Result removeUser(@PathVariable("uid") Integer uid){
        boolean bool = userService.removeUserByUid(uid);
        return Result.success().setMsg(UserConst.DELETE_USER_SUCCESS);
    }

    /**
     * 添加用户
     * @param user
     * @return
     */
    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    public Result addUser(@RequestBody User user){
        userService.addUser(user);
        return Result.success().setMsg(UserConst.ADD_USER_SUCCESS);
    }
    // 陈凯麒 start
    @RequestMapping("/getUser/{uid}")
    public Result getUser(@PathVariable("uid") Integer uid){
        User user = userService.getUserByUid(uid);
        if(user != null) {
            return Result.success().setMsg("").setData(user);
        }
        return Result.failure().setMsg("");
    }
    /**
     * 修改用户信息
     * @param user
     * @return
     */
    @RequestMapping("/editUser")
    public Result editUser(@RequestBody User user){
        userService.editUser(user);
        return Result.success().setMsg(UserConst.EDIT_USER_SUCCESS);
    }
    // 陈凯麒 end

    @RequestMapping(value = "/editPassword",method = RequestMethod.POST)
    public Result editPassword(@RequestBody UserDTO userDTO){
        userService.modifyPassword(userDTO);
        return Result.success().setMsg("");
    }
}
