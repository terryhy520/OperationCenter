use operationcenter;
-- 向 org 表插入测试数据
INSERT INTO org (id, tenant_id, super_id, org_type_code, name, created_at, created_by, last_updated_at, last_updated_by)
VALUES
    (1, 1, NULL, 'ENTP', '示例企业', NOW(), 1, NOW(), 1),
    (2, 1, 1, 'DEVGRP', '开发一组', NOW(), 1, NOW(), 1);

-- 向 org_type 表插入测试数据
INSERT INTO org_type (code, tenant_id, name, created_at, created_by, last_updated_at, last_updated_by)
VALUES
    ('ENTP', 1, '企业', NOW(), 1, NOW(), 1),
    ('DEVGRP', 1, '开发组', NOW(), 1, NOW(), 1);

-- 向 tenant 表插入测试数据
INSERT INTO tenant (id, name, created_at, created_by, last_updated_at, last_updated_by)
VALUES
    (1, '示例租户', NOW(), 1, NOW(), 1);

-- 向 user 表插入测试数据
INSERT INTO user (id, tenant_id, org_id, name, phone, email, password, status, created_at, created_by, last_updated_at, last_updated_by)
VALUES
    (1, 1, 1, 'sysadmin', '13800000000', 'zhangsan@example.com', 'password123', 'active', NOW(), 1, NOW(), 1),
    (2, 1, 2, '李四', '13900000000', 'lisi@example.com', 'password456', 'active', NOW(), 1, NOW(), 1);

-- 向 group_has_user 表插入测试数据
INSERT INTO group_has_user (id, tenant_id, group_id, user_id, created_at, created_by, last_updated_at, last_updated_by)
VALUES
    (1, 1, 1, 1, NOW(), 1, NOW(), 1),
    (2, 1, 1, 2, NOW(), 1, NOW(), 1);

-- 向 group 表插入测试数据
INSERT INTO `group` (id, tenant_id, name, description, status, created_at, created_by, last_updated_at, last_updated_by)
VALUES
    (1, 1, '管理员组', '管理员用户组', 'active', NOW(), 1, NOW(), 1);

-- 向 group_has_role 表插入测试数据
INSERT INTO group_has_role (id, tenant_id, group_id, role_id, created_at, created_by, last_updated_at, last_updated_by)
VALUES
    (1, 1, 1, 1, NOW(), 1, NOW(), 1),
    (2, 1, 1, 2, NOW(), 1, NOW(), 1);

-- 向 permission 表插入测试数据
INSERT INTO permission (id, tenant_id, title, description, active, created_at, created_by, last_updated_at, last_updated_by)
VALUES
    (1, 1, '查看资源', '允许查看系统资源', 'yes', NOW(), 1, NOW(), 1),
    (2, 1, '修改资源', '允许修改系统资源', 'yes', NOW(), 1, NOW(), 1);

-- 向 role_has_permission 表插入测试数据
INSERT INTO role_has_permission (id, tenant_id, role_id, permission_id, created_at, created_by, last_updated_at, last_updated_by)
VALUES
    (1, 1, 1, 1, NOW(), 1, NOW(), 1),
    (2, 1, 1, 2, NOW(), 1, NOW(), 1);

-- 向 role 表插入测试数据
INSERT INTO role (id, tenant_id, name, description, status, created_at, created_by, last_updated_at, last_updated_by)
VALUES
    (1, 1, '管理员角色', '系统管理员角色', 'active', NOW(), 1, NOW(), 1);

-- 向 alarm 表插入测试数据
INSERT INTO alarm (id, tenant_id, resource_id, alarm_type, description, work_order_id, handled, handled_by, created_at, created_by, last_updated_at, last_updated_by)
VALUES
    (1, 1, 1, '资源异常', '资源出现异常情况', NULL, 'no', NULL, NOW(), 1, NOW(), 1);

-- 向 resource 表插入测试数据
INSERT INTO resource (id, tenant_id, docked_sys_id, name, description, cid, status, created_at, created_by, last_updated_at, last_updated_by)
VALUES
    (1, 1, 1, '示例资源', '这是一个示例资源', 'CID123', 'active', NOW(), 1, NOW(), 1);

-- 向 event 表插入测试数据
INSERT INTO event (id, tenant_id, resource_id, event_type, event_level, work_order_id, handled, handled_by, created_at, created_by, last_updated_at, last_updated_by)
VALUES
    (1, 1, 1, '资源访问', '低', NULL, 'no', NULL, NOW(), 1, NOW(), 1);

-- 向 script 表插入测试数据
INSERT INTO script (id, tenant_id, name, script_url, description, status, created_at, created_by, last_updated_at, last_updated_by)
VALUES
    (1, 1, '示例脚本', 'http://example.com/script1', '示例脚本描述', 'active', NOW(), 1, NOW(), 1);

-- 向 docked_sys_type 表插入测试数据
INSERT INTO docked_sys_type (code, tenant_id, name, created_at, created_by, last_updated_at, last_updated_by)
VALUES
    ('SYS_TYPE1', 1, '第三方系统类型1', NOW(), 1, NOW(), 1);

-- 向 docked_sys 表插入测试数据
INSERT INTO docked_sys (id, tenant_id, docked_sys_type_code, name, url, username, password, status, created_at, created_by, last_updated_at, last_updated_by)
VALUES
    (1, 1, 'SYS_TYPE1', '示例第三方系统', 'http://example.com/thirdsys', 'user1', 'pass1', 'active', NOW(), 1, NOW(), 1);

-- 向 task_resource 表插入测试数据
INSERT INTO task_resource (id, tenant_id, task_id, resource_id, created_at, created_by, last_updated_at, last_updated_by)
VALUES
    (1, 1, 1, 1, NOW(), 1, NOW(), 1);

-- 向 task 表插入测试数据
INSERT INTO task (id, tenant_id, script_id, name, description, status, exec_result, created_at, created_by, last_updated_at, last_updated_by)
VALUES
    (1, 1, 1, '示例任务', '任务描述', 'active', '未执行', NOW(), 1, NOW(), 1);