package com.able.product.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by 廖师兄
 * 2017-12-09 21:37
 */
@Data
@Entity
@Table(name = "product_category")
public class ProductCategory {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Integer categoryId;

    /** 类目名字. */
    @Column(name = "category_name")
    private String categoryName;

    /** 类目编号. */
    @Column(name = "category_type")
    private Integer categoryType;
    @Column(name = "create_time")
    private Date createTime;
    @Column(name = "update_time")
    private Date updateTime;
}
