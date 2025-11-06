use operationcenter;

DROP TABLE IF EXISTS org;
DROP TABLE IF EXISTS org_type;
DROP TABLE IF EXISTS tenant;
DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS group_has_user;
DROP TABLE IF EXISTS `group`;
DROP TABLE IF EXISTS group_has_role;
DROP TABLE IF EXISTS permission;
DROP TABLE IF EXISTS role_has_permission;
DROP TABLE IF EXISTS role;
DROP TABLE IF EXISTS alarm;
DROP TABLE IF EXISTS resource;
DROP TABLE IF EXISTS event;
DROP TABLE IF EXISTS script;
DROP TABLE IF EXISTS docked_sys_type;
DROP TABLE IF EXISTS docked_sys;
DROP TABLE IF EXISTS task_resource;
DROP TABLE IF EXISTS task;

-- 创建 org 表
CREATE TABLE org (
                     id INT PRIMARY KEY,
                     tenant_id INT NOT NULL,
                     super_id INT,
                     org_type_code VARCHAR(50) NOT NULL,
                     name VARCHAR(100) NOT NULL,
                     created_at DATETIME NOT NULL,
                     created_by INT NOT NULL,
                     last_updated_at DATETIME NOT NULL,
                     last_updated_by INT NOT NULL
);

-- 创建 org_type 表
CREATE TABLE org_type (
                          code VARCHAR(10) PRIMARY KEY,
                          tenant_id INT NOT NULL,
                          name VARCHAR(10) NOT NULL,
                          created_at DATETIME NOT NULL,
                          created_by INT NOT NULL,
                          last_updated_at DATETIME NOT NULL,
                          last_updated_by INT NOT NULL
);

-- 创建 tenant 表
CREATE TABLE tenant (
                        id INT PRIMARY KEY,
                        name VARCHAR(255) NOT NULL,
                        created_at DATETIME NOT NULL,
                        created_by INT NOT NULL,
                        last_updated_at DATETIME NOT NULL,
                        last_updated_by INT NOT NULL
);

-- 创建 user 表
CREATE TABLE user (
                      id INT PRIMARY KEY,
                      tenant_id INT NOT NULL,
                      org_id INT NOT NULL,
                      name VARCHAR(50) NOT NULL,
                      phone VARCHAR(50),
                      email VARCHAR(255),
                      password VARCHAR(255) NOT NULL,
                      status VARCHAR(50) NOT NULL,
                      created_at DATETIME NOT NULL,
                      created_by INT NOT NULL,
                      last_updated_at DATETIME NOT NULL,
                      last_updated_by INT NOT NULL
);

-- 创建 group_has_user 表
CREATE TABLE group_has_user (
                                id INT PRIMARY KEY,
                                tenant_id INT NOT NULL,
                                group_id INT NOT NULL,
                                user_id INT NOT NULL,
                                created_at DATETIME NOT NULL,
                                created_by INT NOT NULL,
                                last_updated_at DATETIME NOT NULL,
                                last_updated_by INT NOT NULL
);

-- 创建 group 表
CREATE TABLE `group` (
                       id INT PRIMARY KEY,
                       tenant_id INT NOT NULL,
                       name VARCHAR(255) NOT NULL,
                       description VARCHAR(255),
                       status VARCHAR(50) NOT NULL,
                       created_at DATETIME NOT NULL,
                       created_by INT NOT NULL,
                       last_updated_at DATETIME NOT NULL,
                       last_updated_by INT NOT NULL
);

-- 创建 group_has_role 表
CREATE TABLE group_has_role (
                                id INT PRIMARY KEY,
                                tenant_id INT NOT NULL,
                                group_id INT NOT NULL,
                                role_id INT NOT NULL,
                                created_at DATETIME NOT NULL,
                                created_by INT NOT NULL,
                                last_updated_at DATETIME NOT NULL,
                                last_updated_by INT NOT NULL
);

-- 创建 permission 表
CREATE TABLE permission (
                            id INT PRIMARY KEY,
                            tenant_id INT NOT NULL,
                            title VARCHAR(255) NOT NULL,
                            description VARCHAR(255),
                            active VARCHAR(50) NOT NULL,
                            created_at DATETIME NOT NULL,
                            created_by INT NOT NULL,
                            last_updated_at DATETIME NOT NULL,
                            last_updated_by INT NOT NULL
);

-- 创建 role_has_permission 表
CREATE TABLE role_has_permission (
                                     id INT PRIMARY KEY,
                                     tenant_id INT NOT NULL,
                                     role_id INT NOT NULL,
                                     permission_id INT NOT NULL,
                                     created_at DATETIME NOT NULL,
                                     created_by INT NOT NULL,
                                     last_updated_at DATETIME NOT NULL,
                                     last_updated_by INT NOT NULL
);

-- 创建 role 表
CREATE TABLE role (
                      id INT PRIMARY KEY,
                      tenant_id INT NOT NULL,
                      name VARCHAR(255) NOT NULL,
                      description VARCHAR(255),
                      status VARCHAR(50) NOT NULL,
                      created_at DATETIME NOT NULL,
                      created_by INT NOT NULL,
                      last_updated_at DATETIME NOT NULL,
                      last_updated_by INT NOT NULL
);

-- 创建 alarm 表
CREATE TABLE alarm (
                       id INT PRIMARY KEY,
                       tenant_id INT NOT NULL,
                       resource_id INT NOT NULL,
                       alarm_type VARCHAR(50) NOT NULL,
                       description VARCHAR(255),
                       work_order_id INT,
                       handled VARCHAR(50) NOT NULL,
                       handled_by INT,
                       created_at DATETIME NOT NULL,
                       created_by INT NOT NULL,
                       last_updated_at DATETIME NOT NULL,
                       last_updated_by INT NOT NULL
);

-- 创建 resource 表
CREATE TABLE resource (
                          id INT PRIMARY KEY,
                          tenant_id INT NOT NULL,
                          docked_sys_id INT NOT NULL,
                          name VARCHAR(100) NOT NULL,
                          description VARCHAR(255),
                          cid VARCHAR(50),
                          status VARCHAR(50) NOT NULL,
                          created_at DATETIME NOT NULL,
                          created_by INT NOT NULL,
                          last_updated_at DATETIME NOT NULL,
                          last_updated_by INT NOT NULL
);

-- 创建 event 表
CREATE TABLE event (
                       id INT PRIMARY KEY,
                       tenant_id INT NOT NULL,
                       resource_id INT NOT NULL,
                       event_type VARCHAR(50) NOT NULL,
                       event_level VARCHAR(50),
                       work_order_id INT,
                       handled VARCHAR(50) NOT NULL,
                       handled_by INT,
                       created_at DATETIME NOT NULL,
                       created_by INT NOT NULL,
                       last_updated_at DATETIME NOT NULL,
                       last_updated_by INT NOT NULL
);

-- 创建 script 表
CREATE TABLE script (
                        id INT PRIMARY KEY,
                        tenant_id INT NOT NULL,
                        name VARCHAR(255) NOT NULL,
                        script_url VARCHAR(1024) NOT NULL,
                        description VARCHAR(255),
                        status VARCHAR(50) NOT NULL,
                        created_at DATETIME NOT NULL,
                        created_by INT NOT NULL,
                        last_updated_at DATETIME NOT NULL,
                        last_updated_by INT NOT NULL
);

-- 创建 docked_sys_type 表
CREATE TABLE docked_sys_type (
                                 code VARCHAR(50) PRIMARY KEY,
                                 tenant_id INT NOT NULL,
                                 name VARCHAR(50) NOT NULL,
                                 created_at DATETIME NOT NULL,
                                 created_by INT NOT NULL,
                                 last_updated_at DATETIME NOT NULL,
                                 last_updated_by INT NOT NULL
);

-- 创建 docked_sys 表
CREATE TABLE docked_sys (
                            id INT PRIMARY KEY,
                            tenant_id INT NOT NULL,
                            docked_sys_type_code VARCHAR(50) NOT NULL,
                            name VARCHAR(255) NOT NULL,
                            url VARCHAR(1024),
                            username VARCHAR(255),
                            password VARCHAR(255),
                            status VARCHAR(50) NOT NULL,
                            created_at DATETIME NOT NULL,
                            created_by INT NOT NULL,
                            last_updated_at DATETIME NOT NULL,
                            last_updated_by INT NOT NULL
);

-- 创建 task_resource 表
CREATE TABLE task_resource (
                               id INT PRIMARY KEY,
                               tenant_id INT NOT NULL,
                               task_id INT NOT NULL,
                               resource_id INT NOT NULL,
                               created_at DATETIME NOT NULL,
                               created_by INT NOT NULL,
                               last_updated_at DATETIME NOT NULL,
                               last_updated_by INT NOT NULL
);

-- 创建 task 表
CREATE TABLE task (
                      id INT PRIMARY KEY,
                      tenant_id INT NOT NULL,
                      script_id INT NOT NULL,
                      name VARCHAR(255) NOT NULL,
                      description VARCHAR(1024),
                      status VARCHAR(50) NOT NULL,
                      exec_result VARCHAR(255),
                      created_at DATETIME NOT NULL,
                      created_by INT NOT NULL,
                      last_updated_at DATETIME NOT NULL,
                      last_updated_by INT NOT NULL
);