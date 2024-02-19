package com.baby.babycareproductsshop.entity.order;

import com.baby.babycareproductsshop.entity.user.UserEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "t_order")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iorder")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "iuser")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "iaddress")
    private AddressEntity addressEntity;

    @ManyToOne
    @JoinColumn(name = "ipayment_option")
    private PaymentOptionEntity paymentOption;

    @Column(name = "addressee_nm", length = 20)
    private String addresseeName;

    @Column(name = "phone_number", length = 13)
    private String phoneNumber;

    @Column(name = "email", length = 50)
    private String email;

    @Column(name = "process_state", nullable = false)
    private int processState;

    @Column(name = "total_price", nullable = false)
    private int totalPrice;

    @Column(name = "delivery_request", length = 100)
    private String deliveryRequest;

    @Column(name = "delete_fl", nullable = false)
    private int deleteFlag;

    @Column(name = "full_address", length = 100)
    private String fullAddress;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
