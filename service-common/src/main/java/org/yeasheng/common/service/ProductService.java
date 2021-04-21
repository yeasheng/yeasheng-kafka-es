package org.yeasheng.common.service;

import org.yeasheng.common.pojo.Product;

/**
 * @author yansh
 * @version 2021/4/20
 **/
public interface ProductService {

    Product queryById(Integer id);

    Long insert(Product product);
}
