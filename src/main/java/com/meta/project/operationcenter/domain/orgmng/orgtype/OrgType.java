package com.meta.project.operationcenter.domain.orgmng.orgtype;

import com.meta.project.operationcenter.common.framework.domain.AuditableEntity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

public class OrgType extends AuditableEntity {
    @Getter
    @Setter
    private String code;
    @Getter
    @Setter
    private int tenantId;
    @Getter
    @Setter
    private String name;

    public OrgType(LocalDateTime createdAt, int createdBy) {
        super(createdAt, createdBy);
    }
}
