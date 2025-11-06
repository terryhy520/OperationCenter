package com.meta.project.operationcenter.adapter.driving.restful.orgmng.org;

import com.meta.project.operationcenter.adapter.driven.persistance.orgmng.org.OrgRepository;
import com.meta.project.operationcenter.domain.orgmng.org.Org;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/orgs")
public class OrgController {

    @Autowired
    private OrgRepository orgRepository;

    // 获取所有组织
    @GetMapping
    public List<Org> getAllOrgs() {
        return orgRepository.findAll();
    }

    // 根据ID获取组织
    @GetMapping("/{id}")
    public ResponseEntity<Org> getOrgById(@PathVariable int id) {
        Optional<Org> org = orgRepository.findById(id);
        return org.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // 创建新组织
    @PostMapping
    public Org createOrg(@RequestBody Org org) {
        return orgRepository.save(org);
    }

    // 更新组织信息
    @PutMapping("/{id}")
    public ResponseEntity<Org> updateOrg(@PathVariable int id, @RequestBody Org orgDetails) {
        Optional<Org> org = orgRepository.findById(id);
        
        if (org.isPresent()) {
            Org updatedOrg = org.get();
            updatedOrg.setName(orgDetails.getName());
            updatedOrg.setSuperId(orgDetails.getSuperId());
            updatedOrg.setOrgTypeCode(orgDetails.getOrgTypeCode());
            updatedOrg.setTenantId(orgDetails.getTenantId());
            
            return ResponseEntity.ok(orgRepository.save(updatedOrg));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // 删除组织
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrg(@PathVariable int id) {
        Optional<Org> org = orgRepository.findById(id);
        
        if (org.isPresent()) {
            orgRepository.delete(org.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // 根据租户ID获取组织列表
    @GetMapping("/tenant/{tenantId}")
    public List<Org> getOrgsByTenantId(@PathVariable int tenantId) {
        return orgRepository.findByTenantId(tenantId);
    }

    // 根据上级组织ID获取子组织列表
    @GetMapping("/parent/{superId}")
    public List<Org> getChildOrgs(@PathVariable Integer superId) {
        return orgRepository.findBySuperId(superId);
    }

    // 根据组织类型获取组织列表
    @GetMapping("/type/{orgTypeCode}")
    public List<Org> getOrgsByType(@PathVariable String orgTypeCode) {
        return orgRepository.findByOrgTypeCode(orgTypeCode);
    }
}