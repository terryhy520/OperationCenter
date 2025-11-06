package com.meta.project.operationcenter.domain.permissionmng.role;

import com.meta.project.operationcenter.domain.permissionmng.permission.Permission;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "role_has_permission")
@Data
public class RoleHasPermission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "role_id", nullable = false)
    private int roleId;

    @Column(name = "permission_id", nullable = false)
    private int permissionId;

    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Role role;

    @ManyToOne
    @JoinColumn(name = "permission_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Permission permission;
}