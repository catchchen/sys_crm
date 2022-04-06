package com.company.service.impl;

import com.company.mapper.DeptMapper;
import com.company.service.DeptService;
import com.company.vo.DeptVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author chenk
 * @date 2021/10/27 14:54
 * @description
 */
@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;

    /**
     * 获取部门列表
     * @return
     */
    @Override
    public List<DeptVO> getDepts() {
        return deptMapper.selectDepts();
    }
}
