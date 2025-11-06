
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import { ConfigProvider } from 'antd';
import zhCN from 'antd/locale/zh_CN';
import MainLayout from './layouts/MainLayout';
import Home from './pages/Home';
import UserManagement from './pages/UserManagement';
import RoleManagement from './pages/RoleManagement';
import PermissionManagement from './pages/PermissionManagement';
import GroupManagement from './pages/GroupManagement';
import OrgManagement from './pages/OrgManagement';
import './App.css';

function App() {
  return (
    <ConfigProvider locale={zhCN}>
      <Router>
        <Routes>
          <Route path="/" element={<MainLayout />}>
            <Route index element={<Home />} />
            <Route path="users" element={<UserManagement />} />
            <Route path="roles" element={<RoleManagement />} />
            <Route path="permissions" element={<PermissionManagement />} />
            <Route path="groups" element={<GroupManagement />} />
            <Route path="orgs" element={<OrgManagement />} />
          </Route>
        </Routes>
      </Router>
    </ConfigProvider>
  );
}

export default App
