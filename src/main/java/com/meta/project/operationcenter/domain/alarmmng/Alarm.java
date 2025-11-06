package com.meta.project.operationcenter.domain.alarmmng;

import com.meta.project.operationcenter.common.framework.domain.AuditableEntity;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
public class Alarm extends AuditableEntity {
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
    private String alarmType;
    @Getter
    @Setter
    private String description;
    @Getter
    @Setter
    private Integer workOrderId;
    @Getter
    @Setter
    private String handled;
    @Getter
    @Setter
    private Integer handledBy;

    public Alarm(LocalDateTime createdAt, int createdBy) {
        super(createdAt, createdBy);
    }
}
