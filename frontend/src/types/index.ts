// 用户模型
export interface User {
  id: number;
  tenantId: number;
  orgId: number;
  name: string;
  phone: string;
  email: string;
  password: string;
  status: string;
}

// 角色模型
export interface Role {
  id: number;
  tenantId: number;
  name: string;
  description: string;
  status: string;
}

// 权限模型
export interface Permission {
  id: number;
  tenantId: number;
  title: string;
  description: string;
  active: string;
}

// 组模型
export interface Group {
  id: number;
  tenantId: number;
  name: string;
  description: string;
  status: string;
}

// 组织模型
export interface Org {
  id: number;
  tenantId: number;
  name: string;
  superId: number;
  orgTypeCode: string;
}

// 分页请求参数
export interface PageRequest {
  page: number;
  size: number;
  [key: string]: any;
}

// 分页响应结果
export interface PageResponse<T> {
  content: T[];
  totalElements: number;
  totalPages: number;
  size: number;
  number: number;
}