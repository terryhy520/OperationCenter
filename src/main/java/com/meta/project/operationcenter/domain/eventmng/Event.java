package com.meta.project.operationcenter.domain.eventmng;

import com.meta.project.operationcenter.common.framework.domain.AuditableEntity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
public class Event extends AuditableEntity {
    @Getter
    @Setter
    private int id;
    @Getter
    @Setter
    private int tenantId;
    @Getter
    @Setter
    private int resourceId;
    @Getter
    @Setter
    private String eventType;
    @Getter
    @Setter
    private String eventLevel;
    @Getter
    @Setter
    private Integer workOrderId;
    @Getter
    @Setter
    private String handled;
    @Getter
    @Setter
    private Integer handledBy;

    public Event(LocalDateTime createdAt, int createdBy) {
        super(createdAt, createdBy);
    }
}
