package com.company.service;

import com.company.vo.DeptVO;

import java.util.List;

/**
 * @author chenk
 * @date 2021/10/27
 * @description 功能
 */
public interface DeptService {
    /**
     * 获取部门列表
     * @return
     */
    List<DeptVO> getDepts();

}
