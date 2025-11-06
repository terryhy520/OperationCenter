import React, { useState } from 'react';
import { Typography, Spin } from 'antd';
import type { Role } from '../types';
import { roleApi } from '../services/api';
import CommonTable from '../components/CommonTable';
import type { ColumnsType } from 'antd/es/table';

const { Title } = Typography;

const RoleManagement: React.FC = () => {
  const [roles, setRoles] = useState<Role[]>([]);
  const [loading, setLoading] = useState(false);

  // 获取角色列表
  const loadRoles = async () => {
    setLoading(true);
    try {
      const data = await roleApi.getAllRoles();
      setRoles(data);
    } catch (error) {
      console.error('获取角色列表失败:', error);
    } finally {
      setLoading(false);
    }
  };
  
  // 初始化加载角色数据
  React.useEffect(() => {
    loadRoles();
  }, []);

  // 添加角色
  const handleAddRole = async (values: Partial<Role>) => {
    try {
      await roleApi.createRole(values as Role);
      loadRoles();
    } catch (error) {
      console.error('添加角色失败:', error);
    }
  }; // 更新角色
  const handleUpdateRole = async (role: Role) => {
    await roleApi.updateRole(role.id, role);
  };

  // 删除角色
  const handleDeleteRole = async (id: number) => {
    await roleApi.deleteRole(id);
  };

  // 表格列配置
  const columns: ColumnsType<Role> = [
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
      title: '角色名称',
      dataIndex: 'name',
      key: 'name',
    },
    {
      title: '角色描述',
      dataIndex: 'description',
      key: 'description',
    },
    {
      title: '状态',
      dataIndex: 'status',
      key: 'status',
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
      name: 'name',
      label: '角色名称',
      rules: [{ required: true, message: '请输入角色名称' }],
    },
    {
      name: 'description',
      label: '角色描述',
      rules: [{ required: true, message: '请输入角色描述' }],
    },
    {
      name: 'status',
      label: '状态',
      rules: [{ required: true, message: '请输入状态' }],
    },
  ];

  return (
    <div>
      <Title level={2}>角色管理</Title>
      {loading && <Spin tip="加载中..." />}
      <CommonTable<Role>
        columns={columns}
        data={roles}
        loading={loading}
        onAdd={handleAddRole}
        onUpdate={handleUpdateRole}
        onDelete={handleDeleteRole}
        formItems={formItems}
        title="角色"
      />
    </div>
  );
};

export default RoleManagement;