package com.meta.project.operationcenter.domain.taskmng.task;


import com.meta.project.operationcenter.common.framework.domain.AuditableEntity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
public class Task extends AuditableEntity {
    @Getter
    @Setter
    private int id;
    @Getter
    @Setter
    private int tenantId;
    @Getter
    @Setter
    private int scriptId;
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private String description;
    @Getter
    @Setter
    private String status;
    @Getter
    @Setter
    private String execResult;

    public Task(LocalDateTime createdAt, int createdBy) {
        super(createdAt, createdBy);
    }
}