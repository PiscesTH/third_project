package com.baby.babycareproductsshop.entity.product;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "t_product")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iproduct")
    private Long id;

    @Column(name = "imain", nullable = false)
    private Long mainCategoryId;

    @Column(name = "imiddle", nullable = false)
    private Long middleCategoryId;

    @Column(name = "product_nm", length = 150, nullable = false)
    private String productName;

    @Column(name = "product_details", length = 1000)
    private String productDetails;

    @Column(name = "recommand_age", nullable = false)
    private Integer recommendedAge;

    @Column(name = "price", nullable = false)
    private Integer price;

    @Column(name = "rep_pic", length = 1000)
    private String representativePicture;

    @Column(name = "remained_cnt", nullable = false)
    private Integer remainedCount;

    @Column(name = "new_fl", nullable = false)
    private Integer newFlag;

    @Column(name = "rc_fl", nullable = false)
    private Integer recommendationFlag;

    @Column(name = "pop_fl", nullable = false)
    private Integer popularityFlag;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

}
