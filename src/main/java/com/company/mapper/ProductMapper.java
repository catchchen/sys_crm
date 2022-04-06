package com.company.mapper;

import com.company.entity.Product;
import com.company.vo.ProductVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author chenk
 * @date 2021/10/28
 * @description 功能
 */
@Mapper
public interface ProductMapper {
    /**
     * 将传入的对象 添加到数据库
     * @param product
     * @return
     */
    int insertProduct(Product product);

    /**
     *查询出所有的商品 以 view object list在页面中显示
     */
    List<ProductVO> selectProducts(@Param("title") String productName, @Param("cateName") String cateName, @Param("price") Double price);

    /**
     * 通过pid查询产品
     * @param pid
     * @return
     */
    Product selectProductByPid(@Param("pid") Long pid);
    /**
     * 假删除数据
     * @param pid 商品 id
     * @return
     */
    int deleteProductByPid(@Param("pid") Long pid);

    int updateProduct(Product product);
}
