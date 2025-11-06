import React, { useState } from 'react';
import { Layout, Menu, Typography } from 'antd';
import { Outlet, Link, useLocation } from 'react-router-dom';
import {
  UserOutlined,
  TeamOutlined,
  LockOutlined,
  ClusterOutlined,
  HomeOutlined,
} from '@ant-design/icons';

const { Header, Sider, Content } = Layout;
const { Title } = Typography;

const MainLayout: React.FC = () => {
  const [collapsed, setCollapsed] = useState(false);
  const location = useLocation();

  const menuItems = [
    {
      key: '/',
      icon: <HomeOutlined />,
      label: <Link to="/">首页</Link>,
    },
    {
      key: '/users',
      icon: <UserOutlined />,
      label: <Link to="/users">用户管理</Link>,
    },
    {
      key: '/roles',
      icon: <TeamOutlined />,
      label: <Link to="/roles">角色管理</Link>,
    },
    {
      key: '/permissions',
      icon: <LockOutlined />,
      label: <Link to="/permissions">权限管理</Link>,
    },
    {
      key: '/groups',
      icon: <ClusterOutlined />,
      label: <Link to="/groups">组管理</Link>,
    },
    {
      key: '/orgs',
      icon: <TeamOutlined />,
      label: <Link to="/orgs">组织管理</Link>,
    },
  ];

  return (
    <Layout style={{ minHeight: '100vh' }}>
      <Sider
        collapsible
        collapsed={collapsed}
        onCollapse={(value) => setCollapsed(value)}
      >
        <div className="logo" style={{ padding: '20px', textAlign: 'center' }}>
          <Title level={4} style={{ color: 'white', margin: 0 }}>
            {collapsed ? 'OP' : 'OperationCenter'}
          </Title>
        </div>
        <Menu
          theme="dark"
          mode="inline"
          selectedKeys={[location.pathname]}
          items={menuItems}
        />
      </Sider>
      <Layout className="site-layout">
        <Header className="site-layout-background" style={{ padding: 0 }} />
        <Content
          className="site-layout-background"
          style={{
            margin: '24px 16px',
            padding: 24,
            minHeight: 280,
            background: 'white',
          }}
        >
          <Outlet />
        </Content>
      </Layout>
    </Layout>
  );
};

export default MainLayout;