package org.yeasheng.common.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.ToString;

import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author yansh
 * @version 2021/4/17
 **/
@Data
@ToString
@Table(name = "product")
public class Product implements Serializable {

    private static final long serialVersionUID = 8110921087058641320L;
    @TableId(type= IdType.AUTO)
    private Integer id;
    private String name;
    private Double price;
    private String flag;
    private String goodDesc;
    private String images;
    private String goodsStock;
    private String goodsType;
}
