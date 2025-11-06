package com.meta.project.operationcenter.adapter.driving.restful.permissionmng.role;

import com.meta.project.operationcenter.adapter.driven.persistance.permissionmng.role.RoleRepository;
import com.meta.project.operationcenter.domain.permissionmng.role.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/roles")
public class RoleController {

    @Autowired
    private RoleRepository roleRepository;

    // 获取所有角色
    @GetMapping
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    // 根据ID获取角色
    @GetMapping("/{id}")
    public ResponseEntity<Role> getRoleById(@PathVariable int id) {
        Optional<Role> role = roleRepository.findById(id);
        return role.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // 创建新角色
    @PostMapping
    public Role createRole(@RequestBody Role role) {
        return roleRepository.save(role);
    }

    // 更新角色信息
    @PutMapping("/{id}")
    public ResponseEntity<Role> updateRole(@PathVariable int id, @RequestBody Role roleDetails) {
        Optional<Role> role = roleRepository.findById(id);
        
        if (role.isPresent()) {
            Role updatedRole = role.get();
            updatedRole.setName(roleDetails.getName());
            updatedRole.setDescription(roleDetails.getDescription());
            updatedRole.setStatus(roleDetails.getStatus());
            updatedRole.setTenantId(roleDetails.getTenantId());
            
            return ResponseEntity.ok(roleRepository.save(updatedRole));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // 删除角色
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRole(@PathVariable int id) {
        Optional<Role> role = roleRepository.findById(id);
        
        if (role.isPresent()) {
            roleRepository.delete(role.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // 根据租户ID获取角色列表
    @GetMapping("/tenant/{tenantId}")
    public List<Role> getRolesByTenantId(@PathVariable int tenantId) {
        return roleRepository.findByTenantId(tenantId);
    }
}