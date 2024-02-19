package com.baby.babycareproductsshop.entity.product;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "t_product_pics")
@Data
public class ProductPicEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iproduct_pics")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "iproduct", nullable = false)
    private ProductEntity productEntity;

    @Column(name = "product_pic", length = 1000, nullable = false)
    private String productPic;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

}
