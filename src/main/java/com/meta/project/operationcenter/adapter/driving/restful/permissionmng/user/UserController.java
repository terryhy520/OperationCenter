package com.meta.project.operationcenter.adapter.driving.restful.permissionmng.user;

import com.meta.project.operationcenter.adapter.driven.persistance.permissionmng.user.UserRepository;
import com.meta.project.operationcenter.domain.permissionmng.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // 获取所有用户
    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // 根据ID获取用户
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable int id) {
        Optional<User> user = userRepository.findById(id);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // 创建新用户
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    // 更新用户信息
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable int id, @RequestBody User userDetails) {
        Optional<User> user = userRepository.findById(id);
        
        if (user.isPresent()) {
            User updatedUser = user.get();
            updatedUser.setName(userDetails.getName());
            updatedUser.setPhone(userDetails.getPhone());
            updatedUser.setEmail(userDetails.getEmail());
            updatedUser.setPassword(userDetails.getPassword());
            updatedUser.setStatus(userDetails.getStatus());
            updatedUser.setTenantId(userDetails.getTenantId());
            updatedUser.setOrgId(userDetails.getOrgId());
            
            return ResponseEntity.ok(userRepository.save(updatedUser));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // 删除用户
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable int id) {
        Optional<User> user = userRepository.findById(id);
        
        if (user.isPresent()) {
            userRepository.delete(user.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // 根据租户ID获取用户列表
    @GetMapping("/tenant/{tenantId}")
    public List<User> getUsersByTenantId(@PathVariable int tenantId) {
        return userRepository.findByTenantId(tenantId);
    }

    // 根据组织ID获取用户列表
    @GetMapping("/org/{orgId}")
    public List<User> getUsersByOrgId(@PathVariable int orgId) {
        return userRepository.findByOrgId(orgId);
    }
}