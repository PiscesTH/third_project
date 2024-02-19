package com.baby.babycareproductsshop.entity.order;

import com.baby.babycareproductsshop.entity.user.UserEntity;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "t_address")
public class AddressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iaddress")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "iuser")
    private UserEntity user;

    @Column(name = "zip_code", length = 200, nullable = false)
    private String zipCode;

    @Column(name = "address", length = 50, nullable = false)
    private String address;

    @Column(name = "address_detail", length = 50, nullable = false)
    private String addressDetail;

    @Column(name = "default_address_fl", nullable = false)
    private int defaultAddressFlag;

}
