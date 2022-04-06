package com.company.service.impl;

import com.company.entity.Product;
import com.company.mapper.ProductMapper;
import com.company.service.ProductService;
import com.company.utils.IdGenerator;
import com.company.vo.ProductVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author chenk
 * @date 2021/10/28 15:06
 * @description 商品
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;
    private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    @Override
    public boolean addProduct(Product product) {
        // id 自动生成
        String pid = IdGenerator.getId();
        product.setPid(Long.parseLong(pid));
        Date now = new Date();
        // 默认添加当前时间
        product.setUpdateTime(now);
        product.setCreateTime(now);
        int i = productMapper.insertProduct(product);
        if(i > 0){
            return true;
        } else{
            logger.warn("添加商品失败" + product);
            throw new RuntimeException("添加商品失败");
        }
    }

    @Override
    public List<ProductVO> getAllProducts(String productName,String cateName,Double price) {
        List<ProductVO> productVOS = productMapper.selectProducts(productName,cateName,price);
        return productVOS;
    }

    @Override
    public Product getProduct(Long pid) {
        return productMapper.selectProductByPid(pid);
    }

    @Override
    public boolean removeProductByPid(Long pid) {
        int i = productMapper.deleteProductByPid(pid);
        if(i > 0){
            return true;
        }else{
            logger.warn("删除商品失败"+pid);
            throw new RuntimeException("删除失败");
        }
    }

    @Override
    public boolean updateProductInfo(Product product) {
        product.setUpdateTime(new Date());
        int i = productMapper.updateProduct(product);
        if(i > 0){
            return true;
        }else{
            logger.warn("修改用户失败"+product);
            throw new RuntimeException("修改用户失败");
        }
    }
}
