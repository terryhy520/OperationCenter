package com.meta.project.operationcenter.domain.resourcemng;


import com.meta.project.operationcenter.common.framework.domain.AuditableEntity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
public class Resource extends AuditableEntity {
    @Getter
    @Setter
    private int id;
    @Getter
    @Setter
    private int tenantId;
    @Getter
    @Setter
    private int dockedSysId;
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private String description;
    @Getter
    @Setter
    private String cid;
    @Getter
    @Setter
    private String status;

    public Resource(LocalDateTime createdAt, int createdBy) {
        super(createdAt, createdBy);
    }
}