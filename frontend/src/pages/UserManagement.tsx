import React, { useState } from 'react';
import { Typography, Spin } from 'antd';
import type { User } from '../types';
import { userApi } from '../services/api';
import CommonTable from '../components/CommonTable';
import type { ColumnsType } from 'antd/es/table';

const { Title } = Typography;

const UserManagement: React.FC = () => {
  const [users, setUsers] = useState<User[]>([]);
  const [loading, setLoading] = useState(false);

  // 获取用户列表
  // 获取用户列表
  const loadUsers = async () => {
    setLoading(true);
    try {
      const data = await userApi.getAllUsers();
      setUsers(data);
    } catch (error) {
      console.error('获取用户列表失败:', error);
    } finally {
      setLoading(false);
    }
  };
  
  // 初始化加载用户数据
  React.useEffect(() => {
    loadUsers();
  }, []);

  // 添加用户
  const handleAddUser = async (values: Partial<User>) => {
    try {
      await userApi.createUser(values as User);
      loadUsers();
    } catch (error) {
      console.error('添加用户失败:', error);
    }
  };

  // 更新用户
  const handleUpdateUser = async (user: User) => {
    await userApi.updateUser(user.id, user);
  };

  // 删除用户
  const handleDeleteUser = async (id: number) => {
    await userApi.deleteUser(id);
  };

  // 表格列配置
  const columns: ColumnsType<User> = [
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
      title: '组织ID',
      dataIndex: 'orgId',
      key: 'orgId',
    },
    {
      title: '用户名',
      dataIndex: 'name',
      key: 'name',
    },
    {
      title: '手机号',
      dataIndex: 'phone',
      key: 'phone',
    },
    {
      title: '邮箱',
      dataIndex: 'email',
      key: 'email',
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
      name: 'orgId',
      label: '组织ID',
      rules: [{ required: true, message: '请输入组织ID' }],
    },
    {
      name: 'name',
      label: '用户名',
      rules: [{ required: true, message: '请输入用户名' }],
    },
    {
      name: 'phone',
      label: '手机号',
      rules: [{ required: true, message: '请输入手机号' }],
    },
    {
      name: 'email',
      label: '邮箱',
      type: 'email',
      rules: [{ required: true, message: '请输入邮箱' }],
    },
    {
      name: 'password',
      label: '密码',
      type: 'password',
      rules: [{ required: true, message: '请输入密码' }],
    },
    {
      name: 'status',
      label: '状态',
      rules: [{ required: true, message: '请输入状态' }],
    },
  ];

  return (
    <div>
      <Title level={2}>用户管理</Title>
      {loading && <Spin tip="加载中..." />}
      <CommonTable<User>
        columns={columns}
        data={users}
        loading={loading}
        onAdd={handleAddUser}
        onUpdate={handleUpdateUser}
        onDelete={handleDeleteUser}
        formItems={formItems}
        title="用户"/>
    </div>
  );
};

export default UserManagement;