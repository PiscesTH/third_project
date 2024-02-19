package com.baby.babycareproductsshop.entity.review;

import com.baby.babycareproductsshop.entity.order.OrderEntity;
import com.baby.babycareproductsshop.entity.product.ProductEntity;
import com.baby.babycareproductsshop.entity.user.UserEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "t_review")
public class ReviewEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ireview")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "iorder", nullable = false)
    private OrderEntity order;

    @ManyToOne
    @JoinColumn(name = "iproduct", nullable = false)
    private ProductEntity product;

    @ManyToOne
    @JoinColumn(name = "iuser")
    private UserEntity user;

    @Column(name = "req_review_pic", length = 1000)
    private String reviewPictureUrl;

    @Column(name = "contents", length = 300)
    private String contents;

    @Column(name = "product_score", nullable = false)
    private int productScore;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;
}
