package com.baby.babycareproductsshop.entity.product;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "t_main_category")
public class MainCategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "imain")
    private Long id;

    @Column(name = "main_category", nullable = false)
    private String mainCategoryName;

    @Column(name = "created_at", nullable = false)
    private LocalDate createdAt;

}
