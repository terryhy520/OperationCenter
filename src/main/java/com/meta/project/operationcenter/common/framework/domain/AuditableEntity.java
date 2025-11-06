package com.meta.project.operationcenter.common.framework.domain;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@MappedSuperclass
@Setter
@Getter
public abstract class AuditableEntity {
    @Column(name = "created_at", nullable = false, updatable = false)
    protected LocalDateTime createdAt;

    @Column(name = "created_by", nullable = false, updatable = false)
    protected int createdBy;

    @Column(name = "last_updated_at", nullable = false)
    protected LocalDateTime lastUpdatedAt;

    @Column(name = "last_updated_by", nullable = false)
    protected int lastUpdatedBy;

    public AuditableEntity(LocalDateTime createdAt, int createdBy) {
        this.createdAt = createdAt;
        this.createdBy = createdBy;
        this.lastUpdatedAt = createdAt;
        this.lastUpdatedBy = createdBy;
    }

    @PrePersist
    protected void onCreate() {
        if (this.createdAt == null) {
            this.createdAt = LocalDateTime.now();
        }
        if (this.lastUpdatedAt == null) {
            this.lastUpdatedAt = LocalDateTime.now();
        }
    }

    @PreUpdate
    protected void onUpdate() {
        this.lastUpdatedAt = LocalDateTime.now();
    }
}