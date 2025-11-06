package com.meta.project.operationcenter.domain.permissionmng.group;

import com.meta.project.operationcenter.common.framework.domain.AuditableEntity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
public class GroupHasRole extends AuditableEntity {
    @Getter
    @Setter
    private int id;
    @Getter
    @Setter
    private int tenantId;
    @Getter
    @Setter
    private int groupId;
    @Getter
    @Setter
    private int roleId;

    public GroupHasRole(LocalDateTime createdAt, int createdBy) {
        super(createdAt, createdBy);
    }
}
