package org.yeasheng.product.controller;

import org.springframework.web.bind.annotation.*;
import org.yeasheng.common.api.CommonResult;
import org.yeasheng.common.pojo.Product;
import org.yeasheng.common.service.ProductService;

import javax.annotation.Resource;

/**
 * @author yansh
 * @version 2021/4/17
 **/
@RestController
@RequestMapping("/product")
public class ProductController {

    @Resource
    private ProductService productService;

    @GetMapping("/{id}")
    public CommonResult<Product> queryProductInfoById(@PathVariable Integer id){
        Product product = productService.queryById(id);
        return CommonResult.success(product);
    }

    @PostMapping("/create")
    public CommonResult<Long> insertProduct(@RequestBody Product param){
        Long result = productService.insert(param);
        return CommonResult.success(result);
    }

}
