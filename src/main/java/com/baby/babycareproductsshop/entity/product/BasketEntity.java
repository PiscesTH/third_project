package com.baby.babycareproductsshop.entity.product;

import com.baby.babycareproductsshop.entity.user.UserEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "t_basket")
public class BasketEntity {
    @EmbeddedId
    private BasketId id;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "iuser")
    private UserEntity user;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "iproduct")
    private ProductEntity product;

    @Column(name = "product_cnt", nullable = false)
    private int productCount;

    @Column(name = "price", nullable = false)
    private int price;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;
}
