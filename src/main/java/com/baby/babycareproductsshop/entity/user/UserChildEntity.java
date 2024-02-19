package com.baby.babycareproductsshop.entity.user;

import com.baby.babycareproductsshop.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Data
@Entity
@Table(name = "t_user_child")
public class UserChildEntity extends BaseEntity {
    @Id
    @Column(columnDefinition = "BIGINT UNSIGNED")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ichild;

    @ManyToOne
    @JoinColumn(name = "iuser", referencedColumnName = "iuser", columnDefinition = "BIGINT UNSIGNED")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private UserEntity userEntity;

    @Column(columnDefinition = "CHAR(1) CHECK IN ('Y', 'M'")
    private String gender;

    @ManyToOne
    @JoinColumn(name = "ichild_age", referencedColumnName = "ichild_age", columnDefinition = "BIGINT UNSIGNED")
    private UserChildAgeEntity userChildAgeEntity;
}
