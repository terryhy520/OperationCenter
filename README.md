# OperationCenter

## 项目简介
OperationCenter是一个基于Spring Boot的权限管理系统，提供完整的多租户权限管理解决方案，支持用户、角色、权限、组织和用户组的管理功能。

## 技术栈
- **后端框架**：Spring Boot 3.x
- **ORM框架**：Spring Data JPA + Hibernate
- **数据库**：MySQL 8.x
- **构建工具**：Maven
- **API风格**：RESTful
- **JDK版本**：JDK 17+

## 核心功能

### 1. 用户管理
- 用户CRUD操作
- 按租户ID查询用户
- 用户与组织、用户组关联

### 2. 角色管理
- 角色CRUD操作
- 按租户ID查询角色
- 角色与权限关联

### 3. 权限管理
- 权限CRUD操作
- 按租户ID、标题、激活状态查询权限

### 4. 组织管理
- 组织CRUD操作
- 支持组织层级结构
- 按租户ID、上级组织ID、组织类型查询

### 5. 用户组管理
- 用户组CRUD操作
- 用户与组关联管理
- 按租户ID查询用户组

## API接口文档

### 用户管理 API
- `GET /api/users` - 获取用户列表
- `GET /api/users/by-tenant/{tenantId}` - 按租户ID查询用户
- `POST /api/users` - 创建新用户
- `GET /api/users/{id}` - 获取用户详情
- `PUT /api/users/{id}` - 更新用户信息
- `DELETE /api/users/{id}` - 删除用户

### 角色管理 API
- `GET /api/roles` - 获取角色列表
- `GET /api/roles/by-tenant/{tenantId}` - 按租户ID查询角色
- `POST /api/roles` - 创建新角色
- `GET /api/roles/{id}` - 获取角色详情
- `PUT /api/roles/{id}` - 更新角色信息
- `DELETE /api/roles/{id}` - 删除角色

### 权限管理 API
- `GET /api/permissions` - 获取权限列表
- `GET /api/permissions/by-tenant/{tenantId}` - 按租户ID查询权限
- `GET /api/permissions/by-tenant-active/{tenantId}/{active}` - 按租户ID和激活状态查询权限
- `POST /api/permissions` - 创建新权限
- `GET /api/permissions/{id}` - 获取权限详情
- `PUT /api/permissions/{id}` - 更新权限信息
- `DELETE /api/permissions/{id}` - 删除权限

### 组织管理 API
- `GET /api/orgs` - 获取组织列表
- `GET /api/orgs/by-tenant/{tenantId}` - 按租户ID查询组织
- `GET /api/orgs/by-super-id/{superId}` - 按上级组织ID查询子组织
- `GET /api/orgs/by-type/{orgTypeCode}` - 按组织类型查询组织
- `POST /api/orgs` - 创建新组织
- `GET /api/orgs/{id}` - 获取组织详情
- `PUT /api/orgs/{id}` - 更新组织信息
- `DELETE /api/orgs/{id}` - 删除组织

### 用户组管理 API
- `GET /api/groups` - 获取用户组列表
- `GET /api/groups/by-tenant/{tenantId}` - 按租户ID查询用户组
- `POST /api/groups` - 创建新用户组
- `GET /api/groups/{id}` - 获取用户组详情
- `PUT /api/groups/{id}` - 更新用户组信息
- `DELETE /api/groups/{id}` - 删除用户组

## 快速开始

### 1. 环境要求
- JDK 17或更高版本
- Maven 3.6+ 或 Gradle 7+
- MySQL 8.0+

### 2. 数据库配置
在 `application.yml` 中配置数据库连接信息：

```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/operation_center?useSSL=false&serverTimezone=UTC&characterEncoding=utf8
    username: root
    password: your_password
    driver-class-name: com.mysql.cj.jdbc.Driver
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
    format_sql: true
    database-platform: org.hibernate.dialect.MySQL8Dialect
```

### 3. 启动项目

```bash
# 使用Maven启动
mvn spring-boot:run

# 或打包后运行
mvn clean package
java -jar target/operationcenter-0.0.1-SNAPSHOT.jar
```

### 4. 访问系统
项目启动后，可通过以下地址访问：
- 应用地址：http://localhost:8080
- API文档：可集成Swagger（需要额外配置）

## 项目结构

```
src/main/java/com/meta/project/operationcenter/
├── adapter/
│   └── driving/
│       └── restful/               # REST API接口
│           ├── permissionmng/      # 权限管理相关API
│           └── orgmng/             # 组织管理相关API
├── domain/                         # 领域模型
│   ├── permissionmng/              # 权限管理领域
│   │   ├── user/                   # 用户相关
│   │   ├── role/                   # 角色相关
│   │   ├── permission/             # 权限相关
│   │   └── group/                  # 用户组相关
│   └── orgmng/                     # 组织管理领域
│       └── org/                    # 组织相关
├── common/                         # 公共组件
│   └── framework/                  # 框架基础类
└── OperationcenterApplication.java # 应用启动类
```

## 多租户支持
系统支持多租户架构，所有核心业务实体都包含tenantId字段，便于数据隔离和权限控制。

## 开发说明

### 添加新功能
1. 创建领域模型（Entity）
2. 实现数据访问层（Repository）
3. 添加REST API接口（Controller）
4. 配置必要的JPA映射和验证

### 测试
系统启动后，可以使用Postman或其他API测试工具调用接口进行测试。

## 许可证
MIT License
