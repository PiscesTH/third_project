package com.baby.babycareproductsshop.entity.order;

import com.baby.babycareproductsshop.entity.product.ProductEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "t_order_details")
public class OrderDetailsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idetails")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "iorder", nullable = false)
    private OrderEntity order;

    @ManyToOne
    @JoinColumn(name = "iproduct", nullable = false)
    private ProductEntity product;

    @Column(name = "product_cnt", nullable = false)
    private Integer productCnt;

    @Column(name = "product_price", nullable = false)
    private Integer productPrice;

    @Column(name = "product_total_price", nullable = false)
    private Integer productTotalPrice;

    @Column(name = "refund_fl", nullable = false)
    private Integer refundFl;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
