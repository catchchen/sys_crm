package com.company.controller;

import com.company.common.Result;
import com.company.entity.Category;
import com.company.service.CategoryService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletionStage;

/**
 * @author chenk
 * @date 2021/10/31 16:27
 * @description
 */
@RestController
@Api(tags = "商品分类接口")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;
    @GetMapping("/categories")
    public Result getCategorys(){
        List<Category> categorys = categoryService.getCategories();
        return Result.success().setMsg("").setData(categorys);
    }
}
