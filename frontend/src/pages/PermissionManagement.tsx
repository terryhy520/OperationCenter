import React, { useState } from 'react';
import { Typography, Spin } from 'antd';
import type { Permission } from '../types';
import { permissionApi } from '../services/api';
import CommonTable from '../components/CommonTable';
import type { ColumnsType } from 'antd/es/table';

const { Title } = Typography;

const PermissionManagement: React.FC = () => {
  const [permissions, setPermissions] = useState<Permission[]>([]);
  const [loading, setLoading] = useState(false);

  // 获取权限列表
  const loadPermissions = async () => {
    setLoading(true);
    try {
      const data = await permissionApi.getAllPermissions();
      setPermissions(data);
    } catch (error) {
      console.error('获取权限列表失败:', error);
    } finally {
      setLoading(false);
    }
  };
  
  // 初始化加载权限数据
  React.useEffect(() => {
    loadPermissions();
  }, []);

  // 添加权限
  const handleAddPermission = async (values: Partial<Permission>) => {
    try {
      await permissionApi.createPermission(values as Permission);
      loadPermissions();
    } catch (error) {
      console.error('添加权限失败:', error);
    }
  };// 更新权限
  const handleUpdatePermission = async (permission: Permission) => {
    await permissionApi.updatePermission(permission.id, permission);
  };

  // 删除权限
  const handleDeletePermission = async (id: number) => {
    await permissionApi.deletePermission(id);
  };

  // 表格列配置
  const columns: ColumnsType<Permission> = [
    {
      title: 'ID',
      dataIndex: 'id',
      key: 'id',
    },
    {
      title: '租户ID',
      dataIndex: 'tenantId',
      key: 'tenantId',
    },
    {
      title: '权限名称',
      dataIndex: 'title',
      key: 'title',
    },
    {
      title: '权限描述',
      dataIndex: 'description',
      key: 'description',
    },
    {
      title: '激活状态',
      dataIndex: 'active',
      key: 'active',
    },
  ];

  // 表单配置
  const formItems = [
    {
      name: 'tenantId',
      label: '租户ID',
      rules: [{ required: true, message: '请输入租户ID' }],
    },
    {
      name: 'title',
      label: '权限名称',
      rules: [{ required: true, message: '请输入权限名称' }],
    },
    {
      name: 'description',
      label: '权限描述',
      rules: [{ required: true, message: '请输入权限描述' }],
    },
    {
      name: 'active',
      label: '激活状态',
      rules: [{ required: true, message: '请输入激活状态' }],
    },
  ];

  return (
    <div>
      <Title level={2}>权限管理</Title>
      {loading && <Spin tip="加载中..." />}
      <CommonTable<Permission>
        columns={columns}
        data={permissions}
        loading={loading}
        onAdd={handleAddPermission}
        onUpdate={handleUpdatePermission}
        onDelete={handleDeletePermission}
        formItems={formItems}
        title="权限"
      />
    </div>
  );
};

export default PermissionManagement;