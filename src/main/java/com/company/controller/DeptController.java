package com.company.controller;

import com.company.common.Result;
import com.company.service.DeptService;
import com.company.vo.DeptVO;
import com.company.vo.UserVO;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author chenk
 * @date 2021/10/27 14:56
 * @description
 */
@RestController
@Api("部门类接口")
public class DeptController {
    @Autowired
    private DeptService deptService;

    /**
     *
     * @return
     */
    @RequestMapping(value = "/depts",method = RequestMethod.GET)
    public Result<UserVO> getDepts(){
        return Result.success().setMsg("").setData(deptService.getDepts());
    }
}
