package com.meta.project.operationcenter.adapter.driving.restful.permissionmng.permission;

import com.meta.project.operationcenter.adapter.driven.persistance.permissionmng.permission.PermissionRepository;
import com.meta.project.operationcenter.domain.permissionmng.permission.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/permissions")
public class PermissionController {

    @Autowired
    private PermissionRepository permissionRepository;

    // 获取所有权限
    @GetMapping
    public List<Permission> getAllPermissions() {
        return permissionRepository.findAll();
    }

    // 根据ID获取权限
    @GetMapping("/{id}")
    public ResponseEntity<Permission> getPermissionById(@PathVariable int id) {
        Optional<Permission> permission = permissionRepository.findById(id);
        return permission.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // 创建新权限
    @PostMapping
    public Permission createPermission(@RequestBody Permission permission) {
        return permissionRepository.save(permission);
    }

    // 更新权限信息
    @PutMapping("/{id}")
    public ResponseEntity<Permission> updatePermission(@PathVariable int id, @RequestBody Permission permissionDetails) {
        Optional<Permission> permission = permissionRepository.findById(id);
        
        if (permission.isPresent()) {
            Permission updatedPermission = permission.get();
            updatedPermission.setTitle(permissionDetails.getTitle());
            updatedPermission.setDescription(permissionDetails.getDescription());
            updatedPermission.setActive(permissionDetails.getActive());
            updatedPermission.setTenantId(permissionDetails.getTenantId());
            
            return ResponseEntity.ok(permissionRepository.save(updatedPermission));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // 删除权限
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePermission(@PathVariable int id) {
        Optional<Permission> permission = permissionRepository.findById(id);
        
        if (permission.isPresent()) {
            permissionRepository.delete(permission.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // 根据租户ID获取权限列表
    @GetMapping("/tenant/{tenantId}")
    public List<Permission> getPermissionsByTenantId(@PathVariable int tenantId) {
        return permissionRepository.findByTenantId(tenantId);
    }

    // 根据激活状态获取权限列表
    @GetMapping("/active/{active}")
    public List<Permission> getActivePermissions(@PathVariable String active) {
        return permissionRepository.findByActive(active);
    }
}