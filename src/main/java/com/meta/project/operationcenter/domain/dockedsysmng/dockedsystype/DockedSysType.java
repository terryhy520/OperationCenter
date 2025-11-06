package com.meta.project.operationcenter.domain.dockedsysmng.dockedsystype;












import com.meta.project.operationcenter.common.framework.domain.AuditableEntity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
public class DockedSysType extends AuditableEntity {
    @Getter
    @Setter
    private String code;
    @Getter
    @Setter
    private int tenantId;
    @Getter
    @Setter
    private String name;

    public DockedSysType(LocalDateTime createdAt, int createdBy) {
        super(createdAt, createdBy);
    }
}