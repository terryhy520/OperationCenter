package com.meta.project.operationcenter.domain.tenantmng;
import com.meta.project.operationcenter.common.framework.domain.AuditableEntity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

public class Tenant extends AuditableEntity {
    @Getter
    @Setter
    private int id;
    @Getter
    @Setter
    private String name;

    public Tenant(LocalDateTime createdAt, int createdBy) {
        super(createdAt, createdBy);
    }
}
