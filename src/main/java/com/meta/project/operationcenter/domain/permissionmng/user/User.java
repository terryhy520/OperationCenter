package com.meta.project.operationcenter.domain.permissionmng.user;

import com.meta.project.operationcenter.common.framework.domain.AuditableEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

import static java.time.LocalDateTime.now;

@Entity
@Table(name = "user")
@Data
@EqualsAndHashCode(callSuper = true)
public class User extends AuditableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Getter
    @Setter
    private int id;
    
    @Column(name = "tenant_id", nullable = false)
    @Getter
    @Setter
    private int tenantId;
    
    @Column(name = "org_id", nullable = false)
    @Getter
    @Setter
    private int orgId;
    
    @Column(name = "name", nullable = false)
    @Getter
    @Setter
    private String name;
    
    @Column(name = "phone")
    @Getter
    @Setter
    private String phone;
    
    @Column(name = "email")
    @Getter
    @Setter
    private String email;
    
    @Column(name = "password", nullable = false)
    @Getter
    @Setter
    private String password;
    
    @Column(name = "status", nullable = false)
    @Getter
    @Setter
    private String status;

    public User(LocalDateTime createdAt, int createdBy) {
        super(createdAt, createdBy);
    }

    public User() {
        super(now(),0);
    }
}