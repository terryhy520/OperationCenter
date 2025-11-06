package com.meta.project.operationcenter.domain.permissionmng.group;



import com.meta.project.operationcenter.common.framework.domain.AuditableEntity;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

import static java.time.LocalDateTime.now;

@Entity
@Table(name = "`group`")
@EqualsAndHashCode(callSuper = true)
public class Group extends AuditableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private int id;
    
    @Column(name = "tenant_id", nullable = false)
    @Getter
    @Setter
    private int tenantId;
    
    @Column(name = "name", nullable = false)
    @Getter
    @Setter
    private String name;
    
    @Column(name = "description")
    @Getter
    @Setter
    private String description;
    
    @Column(name = "status")
    @Getter
    @Setter
    private String status;

    public Group(LocalDateTime createdAt, int createdBy) {
        super(createdAt, createdBy);
    }

    public Group() {
        super(now(),1);
    }
}