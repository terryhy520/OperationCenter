import { useState } from 'react';
import { Table, Button, Space, Modal, Form, Input, message } from 'antd';
import type { ColumnsType } from 'antd/es/table';
import type { TablePaginationConfig } from 'antd/es/table';
import { PlusOutlined, EditOutlined, DeleteOutlined } from '@ant-design/icons';

interface FormItemType {
  name: string;
  label: string;
  rules?: any[];
  placeholder?: string;
  type?: string;
}

interface CommonTableProps<T extends { id: number }> {
  columns: ColumnsType<T>;
  data: T[];
  loading: boolean;
  onAdd: (values: Partial<T>) => Promise<void>;
  onUpdate: (record: T) => Promise<void>;
  onDelete: (id: number) => Promise<void>;
  formItems: FormItemType[];
  rowKey?: string;
  pagination?: TablePaginationConfig;
  title: string;
  showActions?: boolean;
}

function CommonTable<T extends { id: number }>({
  columns,
  data,
  loading,
  onAdd,
  onUpdate,
  onDelete,
  formItems,
  rowKey = 'id',
  pagination = {
    pageSize: 10,
    showSizeChanger: true,
    showTotal: (total) => `共 ${total} 条数据`,
  },
  title,
  showActions = true,
}: CommonTableProps<T>) {
  const [isModalVisible, setIsModalVisible] = useState(false);
  const [currentRecord, setCurrentRecord] = useState<T | null>(null);
  const [isEditMode, setIsEditMode] = useState(false);
  const [form] = Form.useForm<T>();

  // 初始化数据通过外部组件的useEffect处理

  // 打开新增模态框
  const handleAdd = () => {
    form.resetFields();
    setCurrentRecord(null);
    setIsEditMode(false);
    setIsModalVisible(true);
  };

  // 打开编辑模态框
  const handleEdit = (record: T) => {
    setCurrentRecord(record);
    setIsEditMode(true);
    // 使用类型断言解决类型问题
    form.setFieldsValue(record as any);
    setIsModalVisible(true);
  };

  // 处理删除
  const handleDelete = (id: number) => {
    Modal.confirm({
      title: '确认删除',
      content: '确定要删除这条记录吗？',
      onOk: async () => {
        try {
          await onDelete(id);
          message.success('删除成功');
        } catch (error) {
          message.error('删除失败');
        }
      },
    });
  };

  // 处理表单提交
  const handleSubmit = async () => {
    try {
      const values = await form.validateFields();
      if (isEditMode && currentRecord) {
        await onUpdate({ ...currentRecord, ...values });
        message.success('更新成功');
      } else {
        await onAdd(values as T);
        message.success('添加成功');
      }
      setIsModalVisible(false);
      form.resetFields();
    } catch (error) {
      message.error(isEditMode ? '更新失败' : '添加失败');
    }
  };

  // 自定义操作列
  const actionColumn: ColumnsType<T> = showActions
    ? [
        {
          title: '操作',
          key: 'action',
          width: 120,
          render: (_: any, record: T) => (
            <Space size="middle">
              <Button
                icon={<EditOutlined />}
                size="small"
                onClick={() => handleEdit(record)}
              >
                编辑
              </Button>
              <Button
                icon={<DeleteOutlined />}
                size="small"
                danger
                onClick={() => handleDelete(record.id)}
              >
                删除
              </Button>
            </Space>
          ),
        },
      ]
    : [];

  return (
    <div className="common-table">
      <div className="table-header" style={{ marginBottom: 16, textAlign: 'right' }}>
        {showActions && (
          <Button type="primary" icon={<PlusOutlined />} onClick={handleAdd}>
            新增{title}
          </Button>
        )}
      </div>

      <Table
        columns={[...columns, ...actionColumn]}
        dataSource={data}
        rowKey={rowKey}
        pagination={pagination}
        loading={loading}
        bordered
      />

      <Modal
        title={isEditMode ? `编辑${title}` : `新增${title}`}
        open={isModalVisible}
        onOk={handleSubmit}
        onCancel={() => setIsModalVisible(false)}
        width={600}
      >
        <Form form={form} layout="vertical">
          {formItems.map((item) => (
            <Form.Item
              key={item.name}
              label={item.label}
              name={item.name as string}
              rules={item.rules}
            >
              <Input
                placeholder={item.placeholder || `请输入${item.label}`}
                type={item.type || 'text'}
              />
            </Form.Item>
          ))}
        </Form>
      </Modal>
    </div>
  );
}

export default CommonTable;