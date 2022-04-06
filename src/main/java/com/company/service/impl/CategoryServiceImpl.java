package com.company.service.impl;

import com.company.entity.Category;
import com.company.mapper.CategoryMapper;
import com.company.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author chenk
 * @date 2021/10/31 16:30
 * @description
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;
    @Override
    public List<Category> getCategories() {
        return categoryMapper.selectCategorys();
    }
}
