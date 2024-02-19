package com.baby.babycareproductsshop.entity.product;

import com.baby.babycareproductsshop.entity.user.UserEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "t_wish_list")
public class WishListEntity {
    @EmbeddedId
    private WishListId id;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "iuser")
    private UserEntity userEntity;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "iproduct")
    private ProductEntity product;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;
}
