package com.meta.project.operationcenter.adapter.driven.persistance.orgmng.org;

import com.meta.project.operationcenter.domain.orgmng.org.Org;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrgRepository extends JpaRepository<Org, Integer> {
    // 根据租户ID查找组织列表
    java.util.List<Org> findByTenantId(int tenantId);
    
    // 根据上级组织ID查找子组织
    java.util.List<Org> findBySuperId(Integer superId);
    
    // 根据组织类型代码查找组织
    java.util.List<Org> findByOrgTypeCode(String orgTypeCode);
    
    // 根据组织名称查找组织
    Org findByName(String name);
}