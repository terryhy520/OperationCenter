package com.meta.project.operationcenter.domain.dockedsysmng.dockedsys;



import com.meta.project.operationcenter.common.framework.domain.AuditableEntity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
public class DockedSys extends AuditableEntity {
    @Getter
    @Setter
    private int id;
    @Getter
    @Setter
    private int tenantId;
    @Getter
    @Setter
    private String dockedSysTypeCode;
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private String uri;
    @Getter
    @Setter
    private String username;
    @Getter
    @Setter
    private String password;
    @Getter
    @Setter
    private String status;

    public DockedSys(LocalDateTime createdAt, int createdBy) {
        super(createdAt, createdBy);
    }
}
