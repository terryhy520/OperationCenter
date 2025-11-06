package com.meta.project.operationcenter.domain.taskmng.task;


import com.meta.project.operationcenter.common.framework.domain.AuditableEntity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
public class TaskResource extends AuditableEntity {
    @Getter
    @Setter
    private int id;
    @Getter
    @Setter
    private int tenantId;
    @Getter
    @Setter
    private int taskId;
    @Getter
    @Setter
    private int resourceId;

    public TaskResource(LocalDateTime createdAt, int createdBy) {
        super(createdAt, createdBy);
    }
}