package org.yeasheng.product.dto;

import lombok.Data;

/**
 * @author yansh
 * @version 2021/4/17
 **/
@Data
public class ProductInsertReq {

    private String name;

    private Double price;

    private String flag;

    private String goodDesc;

    private String images;

    private String goodsStock;

    private String goodsType;
}
