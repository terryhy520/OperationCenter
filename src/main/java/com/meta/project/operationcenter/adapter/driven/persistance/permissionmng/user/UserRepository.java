package com.meta.project.operationcenter.adapter.driven.persistance.permissionmng.user;

import com.meta.project.operationcenter.domain.permissionmng.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    // 根据用户名查找用户
    User findByName(String name);
    
    // 根据手机号查找用户
    User findByPhone(String phone);
    
    // 根据租户ID查找用户列表
    java.util.List<User> findByTenantId(int tenantId);
    
    // 根据组织ID查找用户列表
    java.util.List<User> findByOrgId(int orgId);
}