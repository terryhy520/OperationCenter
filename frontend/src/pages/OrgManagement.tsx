import React, { useState } from 'react';
import { Typography, Spin } from 'antd';
import type { Org } from '../types';
import { orgApi } from '../services/api';
import CommonTable from '../components/CommonTable';
import type { ColumnsType } from 'antd/es/table';

const { Title } = Typography;

const OrgManagement: React.FC = () => {
  const [orgs, setOrgs] = useState<Org[]>([]);
  const [loading, setLoading] = useState(false);

  // 获取组织列表
  const loadOrgs = async () => {
    setLoading(true);
    try {
      const data = await orgApi.getAllOrgs();
      setOrgs(data);
    } catch (error) {
      console.error('获取组织列表失败:', error);
    } finally {
      setLoading(false);
    }
  };
  
  // 初始化加载组织数据
  React.useEffect(() => {
    loadOrgs();
  }, []);

  // 添加组织
  const handleAddOrg = async (values: Partial<Org>) => {
    try {
      await orgApi.createOrg(values as Org);
      loadOrgs();
    } catch (error) {
      console.error('添加组织失败:', error);
    }
  };// 更新组织
  const handleUpdateOrg = async (org: Org) => {
    await orgApi.updateOrg(org.id, org);
  };

  // 删除组织
  const handleDeleteOrg = async (id: number) => {
    await orgApi.deleteOrg(id);
  };

  // 表格列配置
  const columns: ColumnsType<Org> = [
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
      title: '组织名称',
      dataIndex: 'name',
      key: 'name',
    },
    {
      title: '上级组织ID',
      dataIndex: 'superId',
      key: 'superId',
    },
    {
      title: '组织类型',
      dataIndex: 'orgTypeCode',
      key: 'orgTypeCode',
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
      label: '组织名称',
      rules: [{ required: true, message: '请输入组织名称' }],
    },
    {
      name: 'superId',
      label: '上级组织ID',
      rules: [{ required: true, message: '请输入上级组织ID' }],
    },
    {
      name: 'orgTypeCode',
      label: '组织类型',
      rules: [{ required: true, message: '请输入组织类型' }],
    },
  ];

  return (
    <div>
      <Title level={2}>组织管理</Title>
      {loading && <Spin tip="加载中..." />}
      <CommonTable<Org>
        columns={columns}
        data={orgs}
        loading={loading}
        onAdd={handleAddOrg}
        onUpdate={handleUpdateOrg}
        onDelete={handleDeleteOrg}
        formItems={formItems}
        title="组织"
      />
    </div>
  );
};

export default OrgManagement;