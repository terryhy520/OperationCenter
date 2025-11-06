package com.meta.project.operationcenter.domain.orgmng.org;

import com.meta.project.operationcenter.common.framework.domain.AuditableEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import static java.time.LocalDateTime.now;

@Entity
@Table(name = "org")
@Data
@EqualsAndHashCode(callSuper = true)
public class Org extends AuditableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private int id;

    @Column(name = "tenant_id", nullable = false)
    @Getter
    @Setter
    private int tenantId;

    @Column(name = "super_id")
    @Getter
    @Setter
    private Integer superId;

    @Column(name = "org_type_code")
    @Getter
    @Setter
    private String orgTypeCode;

    @Column(name = "name", nullable = false)
    @Getter
    @Setter
    private String name;

    public Org(LocalDateTime createdAt, int createdBy) {
        super(createdAt, createdBy);
    }
    
    public Org() {
        super(now(), 0);
    }
}
