package com.meta.project.operationcenter.adapter.driven.persistance.permissionmng.role;

import com.meta.project.operationcenter.domain.permissionmng.role.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    // 根据租户ID查找角色列表
    java.util.List<Role> findByTenantId(int tenantId);
    
    // 根据名称查找角色
    Role findByName(String name);
}