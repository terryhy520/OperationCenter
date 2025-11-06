package com.meta.project.operationcenter.adapter.driven.persistance.permissionmng.permission;

import com.meta.project.operationcenter.domain.permissionmng.permission.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, Integer> {
    // 根据租户ID查找权限列表
    java.util.List<Permission> findByTenantId(int tenantId);
    
    // 根据标题查找权限
    Permission findByTitle(String title);
    
    // 根据是否激活状态查找权限
    java.util.List<Permission> findByActive(String active);
}