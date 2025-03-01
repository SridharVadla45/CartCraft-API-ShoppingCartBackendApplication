package com.sridhar.dev.shopping_cart.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.OffsetDateTime;

@MappedSuperclass
@Data
public class BaseEntity {
    @CreatedDate
    @Column(updatable = false)
    private OffsetDateTime createdAt;

    @CreatedBy
    @Column(updatable = false)
    private String createdBy;

    @LastModifiedBy
    @Column(insertable = false)
    private String updatedBy;

    @LastModifiedDate
    @Column(insertable = false)
    private OffsetDateTime updatedAt;

}
