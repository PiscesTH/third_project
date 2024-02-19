package com.baby.babycareproductsshop.entity.user;

import com.baby.babycareproductsshop.entity.CreatedAtEntity;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

@Data
@Entity
@Table(name = "t_user_agreements")
public class UserAgreementsEntity extends CreatedAtEntity {
    @EmbeddedId
    private UserAgreementsIds userAgreementsIds;

    @ManyToOne
    @MapsId("iclause")
    @JoinColumn(name = "iclause", referencedColumnName = "iclause", columnDefinition = "BIGINT UNSIGNED")
    private UserSignupClauseEntity userSignupClauseEntity;

    @ManyToOne
    @MapsId("iuser")
    @JoinColumn(name = "iuser", referencedColumnName = "iuser", columnDefinition = "BIGINT UNSIGNED")
    private UserEntity userEntity;

    @Column(columnDefinition = "CHAR(1) CHECK IN ('Y', 'N')")
    @ColumnDefault("Y")
    private String agreement;
}
