package com.meta.project.operationcenter.domain.taskmng.script;

import com.meta.project.operationcenter.common.framework.domain.AuditableEntity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
public class Script extends AuditableEntity {
    @Getter
    @Setter
    private int id;
    @Getter
    @Setter
    private int tenantId;
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private String scriptUri;
    @Getter
    @Setter
    private String description;
    @Getter
    @Setter
    private String status;

    public Script(LocalDateTime createdAt, int createdBy) {
        super(createdAt, createdBy);
    }
}
