package com.meta.project.operationcenter.adapter.driven.persistance.permissionmng.group;

import com.meta.project.operationcenter.domain.permissionmng.group.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepository<Group, Integer> {
    // 根据租户ID查找组列表
    java.util.List<Group> findByTenantId(int tenantId);
    
    // 根据名称查找组
    Group findByName(String name);
}