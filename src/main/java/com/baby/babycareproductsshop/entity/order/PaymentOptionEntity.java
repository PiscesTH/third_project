package com.baby.babycareproductsshop.entity.order;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "t_payment_option")
public class PaymentOptionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ipayment_option")
    private Long id;

    @Column(name = "payment_option", length = 20, nullable = false)
    private String paymentOption;

    @Column(name = "created_at", nullable = false)
    private LocalDate createdAt;
}
