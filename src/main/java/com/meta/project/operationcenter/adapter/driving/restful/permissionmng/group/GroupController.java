package com.meta.project.operationcenter.adapter.driving.restful.permissionmng.group;

import com.meta.project.operationcenter.adapter.driven.persistance.permissionmng.group.GroupRepository;
import com.meta.project.operationcenter.domain.permissionmng.group.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/groups")
public class GroupController {

    @Autowired
    private GroupRepository groupRepository;

    // 获取所有组
    @GetMapping
    public List<Group> getAllGroups() {
        return groupRepository.findAll();
    }

    // 根据ID获取组
    @GetMapping("/{id}")
    public ResponseEntity<Group> getGroupById(@PathVariable int id) {
        Optional<Group> group = groupRepository.findById(id);
        return group.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // 创建新组
    @PostMapping
    public Group createGroup(@RequestBody Group group) {
        return groupRepository.save(group);
    }

    // 更新组信息
    @PutMapping("/{id}")
    public ResponseEntity<Group> updateGroup(@PathVariable int id, @RequestBody Group groupDetails) {
        Optional<Group> group = groupRepository.findById(id);
        
        if (group.isPresent()) {
            Group updatedGroup = group.get();
            updatedGroup.setName(groupDetails.getName());
            updatedGroup.setDescription(groupDetails.getDescription());
            updatedGroup.setStatus(groupDetails.getStatus());
            updatedGroup.setTenantId(groupDetails.getTenantId());
            
            return ResponseEntity.ok(groupRepository.save(updatedGroup));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // 删除组
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGroup(@PathVariable int id) {
        Optional<Group> group = groupRepository.findById(id);
        
        if (group.isPresent()) {
            groupRepository.delete(group.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // 根据租户ID获取组列表
    @GetMapping("/tenant/{tenantId}")
    public List<Group> getGroupsByTenantId(@PathVariable int tenantId) {
        return groupRepository.findByTenantId(tenantId);
    }
}