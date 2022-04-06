package com.company.service;

import com.company.entity.Product;
import com.company.vo.ProductVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author chenk
 * @date 2021/10/28
 * @description 功能
 */
public interface ProductService {
    /**
     * 添加用户
     * @param product
     * @return
     */
    boolean addProduct(Product product);

    /**
     * 查询所有的 商品数据
     * @return
     */
    List<ProductVO> getAllProducts(String productName,String cateName,Double price);

    Product getProduct(Long pid);
    /**
     * 伪删除 商品数据
     */
    boolean removeProductByPid(Long pid);

    /**
     * 修改产品信息
     * @param product
     * @return
     */
    boolean updateProductInfo(Product product);
}
