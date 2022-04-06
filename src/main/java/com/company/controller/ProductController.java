package com.company.controller;

import com.company.common.Result;
import com.company.common.ResultPage;
import com.company.entity.Product;
import com.company.service.ProductService;
import com.company.vo.ProductVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @author chenk
 * @date 2021/10/28 15:14
 * @description
 */
@RestController
@Api(value = "productController",tags = "产品相关接口")
public class ProductController {
    @Autowired
    private ProductService productService;

    /**
     * 通过 条件查询语句 参数可以不传递 动态sql 不传忽略该条件 并对查询的数据分页处理
     * @param title 商品名
     * @param cate 分类名称
     * @param price 价格
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping("/products")
    public ResultPage getProducts(
            @RequestParam(value = "productName",required = false) String title,
            @RequestParam(value = "productCate",required = false) String cate, // 分类
            @RequestParam(value = "productPrice",required = false) Double price,
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum, // 做分页处理 默认 一页五条数据
            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<ProductVO> allProducts = productService.getAllProducts(title,cate,price);
        PageInfo<ProductVO> voPageInfo = new PageInfo<>(allProducts);
//   不进行分页   return Result.success().setMsg("").setData(voPageInfo.getList());
        return ResultPage.success()
                .setMsg("")
                .setData(voPageInfo.getList())
                .setTotal(voPageInfo.getTotal());
    }

    @RequestMapping(value = "/addProduct" ,method = RequestMethod.POST)
    public Result addProduction(@RequestBody Product product){
        boolean b = productService.addProduct(product);
        if(b){
            return Result.success().setMsg("");
        }
        return Result.failure().setMsg("添加失败");
    }

    @RequestMapping("/product/{pid}")
    public Result getProduct(@PathVariable Long pid){
        Product product = productService.getProduct(pid);
        return Result.success().setMsg("").setData(product);
    }
    @RequestMapping("/deleteProduct/{uid}")
    public Result removeProduct(@PathVariable("uid") Long uid){
        productService.removeProductByPid(uid);
        return Result.success().setMsg("");
    }

    @RequestMapping(value = "/editProduct",method = RequestMethod.POST)
    public Result editProduct(@RequestBody Product product){
        productService.updateProductInfo(product);
        return Result.success().setMsg("");
    }
}
