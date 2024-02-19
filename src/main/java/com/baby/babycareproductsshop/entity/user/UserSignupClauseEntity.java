package com.baby.babycareproductsshop.entity.user;

import com.baby.babycareproductsshop.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "t_signup_clause")
public class UserSignupClauseEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "BIGINT UNSIGNED")
    private Long iclause;

    @Column(length = 50)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String contents;

    @Column(columnDefinition = "CHAR(1) CHECK IN ('Y', 'N')")
    private String required;
}
