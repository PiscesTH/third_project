package com.baby.babycareproductsshop.entity;

import jakarta.persistence.EntityListeners;
import lombok.Data;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Data
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity extends CreatedAtEntity{
    @LastModifiedDate
    private LocalDateTime updatedAt;
}
