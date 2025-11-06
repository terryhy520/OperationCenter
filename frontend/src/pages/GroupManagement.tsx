import React, { useState } from 'react';
import { Typography, Spin } from 'antd';
import type { Group } from '../types';
import { groupApi } from '../services/api';
import CommonTable from '../components/CommonTable';
import type { ColumnsType } from 'antd/es/table';

const { Title } = Typography;

const GroupManagement: React.FC = () => {
  const [groups, setGroups] = useState<Group[]>([]);
  const [loading, setLoading] = useState(false);

  // 获取组列表
  const loadGroups = async () => {
    setLoading(true);
    try {
      const data = await groupApi.getAllGroups();
      setGroups(data);
    } catch (error) {
      console.error('获取组列表失败:', error);
    } finally {
      setLoading(false);
    }
  };
  
  // 初始化加载组数据
  React.useEffect(() => {
    loadGroups();
  }, []);

  // 添加组
  const handleAddGroup = async (values: Partial<Group>) => {
    try {
      await groupApi.createGroup(values as Group);
      loadGroups();
    } catch (error) {
      console.error('添加组失败:', error);
    }
  };// 更新组
  const handleUpdateGroup = async (group: Group) => {
    await groupApi.updateGroup(group.id, group);
  };

  // 删除组
  const handleDeleteGroup = async (id: number) => {
    await groupApi.deleteGroup(id);
  };

  // 表格列配置
  const columns: ColumnsType<Group> = [
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
      title: '组名称',
      dataIndex: 'name',
      key: 'name',
    },
    {
      title: '组描述',
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
      label: '组名称',
      rules: [{ required: true, message: '请输入组名称' }],
    },
    {
      name: 'description',
      label: '组描述',
      rules: [{ required: true, message: '请输入组描述' }],
    },
    {
      name: 'status',
      label: '状态',
      rules: [{ required: true, message: '请输入状态' }],
    },
  ];

  return (
    <div>
      <Title level={2}>组管理</Title>
      {loading && <Spin tip="加载中..." />}
      <CommonTable<Group>
        columns={columns}
        data={groups}
        loading={loading}
        onAdd={handleAddGroup}
        onUpdate={handleUpdateGroup}
        onDelete={handleDeleteGroup}
        formItems={formItems}
        title="组"
      />
    </div>
  );
};

export default GroupManagement;