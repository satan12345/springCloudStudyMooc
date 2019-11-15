package com.able.order.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by 廖师兄
 * 2017-12-10 16:07
 */
@Data
@Entity
@Table(name = "order_detail")
public class OrderDetail {

    @Id
    @Column(name = "detail_id")
    private String detailId;

    /** 订单id. */
    @Column(name = "order_id")
    private String orderId;

    /** 商品id. */
    @Column(name = "product_id")
    private String productId;

    /** 商品名称. */
    @Column(name = "product_name")
    private String productName;

    /** 商品单价. */
    @Column(name = "product_price")
    private BigDecimal productPrice;

    /** 商品数量. */
    @Column(name = "product_quantity")
    private Integer productQuantity;

    /** 商品小图. */
    @Column(name = "product_icon")
    private String productIcon;
    @Column(name = "create_time")
    private Date createTime;
    @Column(name = "update_time")
    private Date updateTime;
}
