package com.company.mapper;

import com.company.vo.DeptVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author chenk
 * @date 2021/10/27 14:50
 * @description
 */
@Mapper
public interface DeptMapper {
    /**
     * 查询部门数据
     * @return
     */
    List<DeptVO> selectDepts();
}
