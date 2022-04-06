package com.company.mapper;

import com.company.entity.Category;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author chenk
 * @date 2021/10/29
 * @description 功能
 */
@Mapper
public interface CategoryMapper {
    List<Category> selectCategorys();
}
