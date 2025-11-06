import React from 'react';
import { Typography, Card, Row, Col, Statistic } from 'antd';
import { UserOutlined, TeamOutlined, LockOutlined, ClusterOutlined, BuildOutlined } from '@ant-design/icons';

const { Title, Paragraph } = Typography;

const Home: React.FC = () => {
  return (
    <div>
      <Title level={2}>欢迎使用 OperationCenter</Title>
      <Paragraph>
        OperationCenter 是一个完整的权限管理系统，支持用户、角色、权限、组和组织的全面管理。
        本系统采用多租户架构设计，为企业提供灵活的权限控制解决方案。
      </Paragraph>
      
      <div style={{ marginTop: 32 }}>
        <Title level={4}>系统概览</Title>
        <Row gutter={[16, 16]}>
          <Col span={6}>
            <Card>
              <Statistic
                title="用户管理"
                value={0}
                prefix={<UserOutlined />}
                suffix="个用户"
              />
            </Card>
          </Col>
          <Col span={6}>
            <Card>
              <Statistic
                title="角色管理"
                value={0}
                prefix={<TeamOutlined />}
                suffix="个角色"
              />
            </Card>
          </Col>
          <Col span={6}>
            <Card>
              <Statistic
                title="权限管理"
                value={0}
                prefix={<LockOutlined />}
                suffix="个权限"
              />
            </Card>
          </Col>
          <Col span={6}>
            <Card>
              <Statistic
                title="组管理"
                value={0}
                prefix={<ClusterOutlined />}
                suffix="个组"
              />
            </Card>
          </Col>
          <Col span={6}>
            <Card>
              <Statistic
                title="组织管理"
                value={0}
                prefix={<BuildOutlined />}
                suffix="个组织"
              />
            </Card>
          </Col>
        </Row>
      </div>
      
      <div style={{ marginTop: 32 }}>
        <Title level={4}>快速操作</Title>
        <Paragraph>
          请通过左侧导航菜单访问各个功能模块，开始使用系统进行权限管理操作。
        </Paragraph>
      </div>
    </div>
  );
};

export default Home;