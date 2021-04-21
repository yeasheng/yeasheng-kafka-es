package org.yeasheng.search.service;

import org.springframework.stereotype.Service;
import org.yeasheng.common.mapper.ProductMapper;
import org.yeasheng.common.pojo.Product;
import org.yeasheng.common.service.ProductService;

import javax.annotation.Resource;

/**
 * @author yansh
 * @version 2021/4/20
 **/
@Service
public class ProductElasticsearchServiceImpl implements ProductService {
    @Resource
    ProductMapper productMapper;
    @Override
    public Product queryById(Integer id) {
        return productMapper.selectById(id);
    }

    @Override
    public Long insert(Product product) {
        return null;
    }
}
