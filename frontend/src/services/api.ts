import axios from 'axios';
import type { AxiosInstance, AxiosResponse } from 'axios';
import type { User, Role, Permission, Group, Org } from '../types';

// 创建axios实例
const api: AxiosInstance = axios.create({
  baseURL: 'http://localhost:8080/api',
  timeout: 10000,
  headers: {
    'Content-Type': 'application/json',
  },
});

// 请求拦截器
api.interceptors.request.use(
  (config) => {
    // 可以在这里添加token等认证信息
    const token = localStorage.getItem('token');
    if (token) {
      config.headers.Authorization = `Bearer ${token}`;
    }
    return config;
  },
  (error) => {
    return Promise.reject(error);
  }
);

// 响应拦截器
api.interceptors.response.use(
  (response: AxiosResponse) => {
    return response.data;
  },
  (error) => {
    console.error('API请求错误:', error);
    return Promise.reject(error);
  }
);

// 用户相关API
export const userApi = {
  // 获取所有用户
  getAllUsers: (): Promise<User[]> => api.get('/users'),
  
  // 根据ID获取用户
  getUserById: (id: number): Promise<User> => api.get(`/users/${id}`),
  
  // 创建用户
  createUser: (user: User): Promise<User> => api.post('/users', user),
  
  // 更新用户
  updateUser: (id: number, user: User): Promise<User> => api.put(`/users/${id}`, user),
  
  // 删除用户
  deleteUser: (id: number): Promise<void> => api.delete(`/users/${id}`),
  
  // 根据租户ID获取用户
  getUsersByTenantId: (tenantId: number): Promise<User[]> => api.get(`/users/tenant/${tenantId}`),
  
  // 根据组织ID获取用户
  getUsersByOrgId: (orgId: number): Promise<User[]> => api.get(`/users/org/${orgId}`),
};

// 角色相关API
export const roleApi = {
  // 获取所有角色
  getAllRoles: (): Promise<Role[]> => api.get('/roles'),
  
  // 根据ID获取角色
  getRoleById: (id: number): Promise<Role> => api.get(`/roles/${id}`),
  
  // 创建角色
  createRole: (role: Role): Promise<Role> => api.post('/roles', role),
  
  // 更新角色
  updateRole: (id: number, role: Role): Promise<Role> => api.put(`/roles/${id}`, role),
  
  // 删除角色
  deleteRole: (id: number): Promise<void> => api.delete(`/roles/${id}`),
  
  // 根据租户ID获取角色
  getRolesByTenantId: (tenantId: number): Promise<Role[]> => api.get(`/roles/tenant/${tenantId}`),
};

// 权限相关API
export const permissionApi = {
  // 获取所有权限
  getAllPermissions: (): Promise<Permission[]> => api.get('/permissions'),
  
  // 根据ID获取权限
  getPermissionById: (id: number): Promise<Permission> => api.get(`/permissions/${id}`),
  
  // 创建权限
  createPermission: (permission: Permission): Promise<Permission> => api.post('/permissions', permission),
  
  // 更新权限
  updatePermission: (id: number, permission: Permission): Promise<Permission> => api.put(`/permissions/${id}`, permission),
  
  // 删除权限
  deletePermission: (id: number): Promise<void> => api.delete(`/permissions/${id}`),
  
  // 根据租户ID获取权限
  getPermissionsByTenantId: (tenantId: number): Promise<Permission[]> => api.get(`/permissions/tenant/${tenantId}`),
  
  // 根据激活状态获取权限
  getActivePermissions: (active: string): Promise<Permission[]> => api.get(`/permissions/active/${active}`),
};

// 组相关API
export const groupApi = {
  // 获取所有组
  getAllGroups: (): Promise<Group[]> => api.get('/groups'),
  
  // 根据ID获取组
  getGroupById: (id: number): Promise<Group> => api.get(`/groups/${id}`),
  
  // 创建组
  createGroup: (group: Group): Promise<Group> => api.post('/groups', group),
  
  // 更新组
  updateGroup: (id: number, group: Group): Promise<Group> => api.put(`/groups/${id}`, group),
  
  // 删除组
  deleteGroup: (id: number): Promise<void> => api.delete(`/groups/${id}`),
  
  // 根据租户ID获取组
  getGroupsByTenantId: (tenantId: number): Promise<Group[]> => api.get(`/groups/tenant/${tenantId}`),
};

// 组织相关API
export const orgApi = {
  // 获取所有组织
  getAllOrgs: (): Promise<Org[]> => api.get('/orgs'),
  
  // 根据ID获取组织
  getOrgById: (id: number): Promise<Org> => api.get(`/orgs/${id}`),
  
  // 创建组织
  createOrg: (org: Org): Promise<Org> => api.post('/orgs', org),
  
  // 更新组织
  updateOrg: (id: number, org: Org): Promise<Org> => api.put(`/orgs/${id}`, org),
  
  // 删除组织
  deleteOrg: (id: number): Promise<void> => api.delete(`/orgs/${id}`),
  
  // 根据租户ID获取组织
  getOrgsByTenantId: (tenantId: number): Promise<Org[]> => api.get(`/orgs/tenant/${tenantId}`),
  
  // 根据上级组织ID获取子组织
  getChildOrgs: (superId: number): Promise<Org[]> => api.get(`/orgs/parent/${superId}`),
  
  // 根据组织类型获取组织
  getOrgsByType: (orgTypeCode: string): Promise<Org[]> => api.get(`/orgs/type/${orgTypeCode}`),
};

export default api;