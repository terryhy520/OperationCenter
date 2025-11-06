package com.meta.project.operationcenter.domain.permissionmng.permission;

import com.meta.project.operationcenter.common.framework.domain.AuditableEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import static java.time.LocalDateTime.now;

@Entity
@Table(name = "permission")
@Data
@EqualsAndHashCode(callSuper = true)
public class Permission extends AuditableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private int id;

    @Column(name = "tenant_id", nullable = false)
    @Getter
    @Setter
    private int tenantId;

    @Column(name = "title", nullable = false)
    @Getter
    @Setter
    private String title;

    @Column(name = "description")
    @Getter
    @Setter
    private String description;

    @Column(name = "active", nullable = false)
    @Getter
    @Setter
    private String active;

    public Permission(LocalDateTime createdAt, int createdBy) {
        super(createdAt, createdBy);
    }
    
    public Permission() {
        super(now(), 0);
    }
}