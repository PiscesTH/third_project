package com.baby.babycareproductsshop.entity.product;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Embeddable
@EqualsAndHashCode
public class WishListId implements Serializable {
    @Column(name = "iuser")
    private Long userId;

    @Column(name = "iproduct")
    private Long productId;
}
