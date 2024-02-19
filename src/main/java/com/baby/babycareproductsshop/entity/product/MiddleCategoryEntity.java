package com.baby.babycareproductsshop.entity.product;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "t_middle_category")
@Data
public class MiddleCategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "imiddle")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "imain")
    private MainCategoryEntity mainCategoryEntity;

    @Column(name = "middle_category", nullable = false)
    private String middleCategoryName;

    @Column(name = "created_at", nullable = false)
    private LocalDate createdAt;
}
