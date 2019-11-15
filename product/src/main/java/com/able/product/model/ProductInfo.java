package com.able.product.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by 廖师兄
 * 2017-12-09 21:23
 */
@Data
@Table(name = "product_info")
@Entity
public class ProductInfo {

    @javax.persistence.Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private String productId;

    /** 名字. */
    @Column(name = "product_name")
    private String productName;

    /** 单价. */
    @Column(name = "product_price")
    private BigDecimal productPrice;

    /** 库存. */
    @Column(name = "product_stock")
    private Integer productStock;

    /** 描述. */
    @Column(name = "product_description")
    private String productDescription;

    /** 小图. */
    @Column(name="product_icon")
    private String productIcon;

    /** 状态, 0正常1下架. */
    @Column(name = "product_status")
    private Integer productStatus;

    /** 类目编号. */
    @Column(name = "category_type")
    private Integer categoryType;
    @Column(name = "create_time")
    private Date createTime;
    @Column(name = "update_time")
    private Date updateTime;
}
