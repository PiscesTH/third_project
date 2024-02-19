package com.baby.babycareproductsshop.entity.order;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "t_refund")
public class RefundEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "irefund")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idetails", nullable = false)
    private OrderDetailsEntity orderDetailsEntity;

    @Column(name = "contents", length = 200, nullable = false)
    private String contents;

    @Column(name = "refund_cnt", nullable = false)
    private int refundCount;

    @Column(name = "refund_price", nullable = false)
    private int refundPrice;

    @Column(name = "complete_fl", nullable = false)
    private boolean completeFlag;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

}
