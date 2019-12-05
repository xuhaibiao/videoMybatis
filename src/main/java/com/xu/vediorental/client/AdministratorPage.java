package com.xu.vediorental.client;

import com.xu.vediorental.doMain.table.UserInfo;
import com.xu.vediorental.service.ManagerService;
import com.xu.vediorental.service.UserService;
import com.xu.vediorental.service.impl.ManagerServiceImpl;
import com.xu.vediorental.util.GetDataUtil;
import com.xu.vediorental.util.GuiUtil;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;


public class AdministratorPage extends JFrame {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdministratorPage window = new AdministratorPage("xhb");
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private JPanel contentPane;
	private JTable table_videoMessage;
	private JTable table_videoMessage2;
	private JTextField textField_videoName;
	private JTextField textField_price;
	private JTable table_fileMessage;
	private JTextField textField_fileVideoId;
	private JTable table_record;
	private JTable table_userMessage;
	private JTable table_returnRecord;

	private JTextField textField_userName;
	private JTextField textField_password;
	private JPasswordField passwordField_password;
	private JTextField textField_tel;
    private DefaultTableModel vedioTableModel;
    private DefaultTableModel vedioTableModel2;
    private DefaultTableModel fileTableModel;
    private DefaultTableModel recordTableModel;
    private DefaultTableModel userTableModel;
	private JComboBox user;
	private JComboBox user2;

	private DefaultTableModel noReturnTableModel;
	private DefaultComboBoxModel userComboBoxModel;
	private JScrollPane scrollPane_returnRecord;


	public AdministratorPage(String username) {
        final ManagerService managerService = new ManagerServiceImpl();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("�𾴵� "+username+" ����Ա,��ӭ����");
		setBounds(100, 100, 848, 618);
		int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
		int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
		setLocation((screenWidth - 848)/2, (screenHeight-618)/2);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel panel_exit = new JPanel();
		panel_exit.setBackground(Color.WHITE);
		panel_exit.setBounds(733, 0, 87, 23);
		panel.add(panel_exit);
		panel_exit.setLayout(null);
		
		JButton btnNewButton_exit = new JButton("�˳�");
		btnNewButton_exit.setBackground(Color.WHITE);
		btnNewButton_exit.setBounds(14, 0, 87, 23);
		panel_exit.add(btnNewButton_exit);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(Color.WHITE);
		tabbedPane.setBounds(0, 0, 820, 570);
		panel.add(tabbedPane);
		
		JPanel panel_videoMessage = new JPanel();
		panel_videoMessage.setBackground(Color.WHITE);
		tabbedPane.addTab("¼�����", null, panel_videoMessage, null);
		panel_videoMessage.setLayout(null);
		
		JScrollPane scrollPane_videoMessage = new JScrollPane();
		scrollPane_videoMessage.setBounds(60, 50, 600, 400);
		panel_videoMessage.add(scrollPane_videoMessage);


		table_videoMessage = new JTable();
        table_videoMessage.setRowHeight(35);
		table_videoMessage.setFont(new Font("΢���ź�", Font.PLAIN, 15));
		table_videoMessage.setBackground(Color.WHITE);
		JTableHeader VedioHead = table_videoMessage.getTableHeader();
		VedioHead.setPreferredSize(new Dimension(VedioHead.getWidth(), 35));
		VedioHead.setFont(new Font("΢���ź�", Font.PLAIN, 15));
		vedioTableModel = new DefaultTableModel(GetDataUtil.getVedioData(),
                new String[] {
                        "¼����", "¼����", "�۸�(Ԫ/��)", "�����"
                }){
            @Override
            public boolean isCellEditable(int row, int column)
            {
                return false;
            }
        };
		table_videoMessage.setModel(vedioTableModel);
		scrollPane_videoMessage.setViewportView(table_videoMessage);
		
		JButton btnNewButton_deleteVideo = new JButton("ɾ��¼��");
		btnNewButton_deleteVideo.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		btnNewButton_deleteVideo.setBackground(Color.WHITE);
		btnNewButton_deleteVideo.setBounds(674, 236, 113, 42);
		panel_videoMessage.add(btnNewButton_deleteVideo);

		textField_videoName = new JTextField();
		textField_videoName.setBounds(115, 480, 177, 24);
		panel_videoMessage.add(textField_videoName);
		textField_videoName.setColumns(10);
		
		JLabel lblNewLabel_videlName = new JLabel("¼����:");
		lblNewLabel_videlName.setFont(new Font("΢���ź�", Font.PLAIN, 15));
		lblNewLabel_videlName.setBounds(60, 480, 72, 24);
		panel_videoMessage.add(lblNewLabel_videlName);
		
		JLabel lblNewLabel_price = new JLabel("�۸�:");
		lblNewLabel_price.setFont(new Font("΢���ź�", Font.PLAIN, 15));
		lblNewLabel_price.setBounds(327, 480, 72, 24);
		panel_videoMessage.add(lblNewLabel_price);
		
		textField_price = new JTextField();
		textField_price.setBounds(367, 480, 86, 24);
		panel_videoMessage.add(textField_price);
		textField_price.setColumns(10);
		
		JLabel lblNewLabel_priceUnit = new JLabel("Ԫ/��");
		lblNewLabel_priceUnit.setFont(new Font("΢���ź�", Font.PLAIN, 15));
		lblNewLabel_priceUnit.setBounds(455, 480, 72, 24);
		panel_videoMessage.add(lblNewLabel_priceUnit);
		
		JButton btnNewButton_addVideo = new JButton("����¼��");
		btnNewButton_addVideo.setBackground(Color.WHITE);
		btnNewButton_addVideo.setFont(new Font("΢���ź�", Font.PLAIN, 15));
		btnNewButton_addVideo.setBounds(547, 479, 113, 27);
		panel_videoMessage.add(btnNewButton_addVideo);


		
		JPanel panel_fileMessage = new JPanel();
		panel_fileMessage.setBackground(Color.WHITE);
		tabbedPane.addTab("�ļ�����", null, panel_fileMessage, null);
		panel_fileMessage.setLayout(null);
		
		JScrollPane scrollPane_fileMessage = new JScrollPane();
		scrollPane_fileMessage.setBounds(60, 50, 600, 400);
		panel_fileMessage.add(scrollPane_fileMessage);


        table_fileMessage = new JTable();
		table_fileMessage.setRowHeight(35);
		table_fileMessage.setFont(new Font("΢���ź�", Font.PLAIN, 15));
		table_fileMessage.setBackground(Color.WHITE);
		JTableHeader fileHead = table_fileMessage.getTableHeader();
		fileHead.setPreferredSize(new Dimension(fileHead.getWidth(), 35));
		fileHead.setFont(new Font("΢���ź�", Font.PLAIN, 11));
		fileTableModel = new DefaultTableModel(GetDataUtil.getFileData(),
                new String[] {
                        "�ļ����","¼����", "¼����", "�������(0:����� 1:δ���)"
                }){
            @Override
            public boolean isCellEditable(int row, int column)
            {
                return false;
            }
        };
		table_fileMessage.setModel(fileTableModel);
		scrollPane_fileMessage.setViewportView(table_fileMessage);
		
		JButton btnNewButton_deleteFile = new JButton("ɾ���ļ�");
		btnNewButton_deleteFile.setFont(new Font("΢���ź�", Font.PLAIN, 15));
		btnNewButton_deleteFile.setBackground(Color.WHITE);
		btnNewButton_deleteFile.setBounds(674, 236, 113, 42);
		panel_fileMessage.add(btnNewButton_deleteFile);



		JLabel lblNewLabel_fileVideoId = new JLabel("¼����:");
        lblNewLabel_fileVideoId.setFont(new Font("΢���ź�", Font.PLAIN, 15));
        lblNewLabel_fileVideoId.setBounds(209, 480, 72, 24);
		panel_fileMessage.add(lblNewLabel_fileVideoId);
		
		textField_fileVideoId = new JTextField();
        textField_fileVideoId.setBounds(280, 480, 50, 24);
		panel_fileMessage.add(textField_fileVideoId);
        textField_fileVideoId.setColumns(10);
		
		JButton btnNewButton_addFile = new JButton("�����ļ�");
		btnNewButton_addFile.setBackground(Color.WHITE);
		btnNewButton_addFile.setFont(new Font("΢���ź�", Font.PLAIN, 15));
		btnNewButton_addFile.setBounds(430, 479, 113, 27);
		panel_fileMessage.add(btnNewButton_addFile);


		JPanel panel_record = new JPanel();
		panel_record.setBackground(Color.WHITE);
		tabbedPane.addTab("���޼�¼", null, panel_record, null);
		panel_record.setLayout(null);
		
		JScrollPane scrollPane_record = new JScrollPane();
		scrollPane_record.setBounds(60, 50, 700, 430);
		panel_record.add(scrollPane_record);


		table_record = new JTable();
        table_record.setRowHeight(35);
		table_record.setBackground(Color.WHITE);
		table_record.setFont(new Font("΢���ź�", Font.PLAIN, 15));
		JTableHeader recordHead = table_record.getTableHeader();
		recordHead.setPreferredSize(new Dimension(recordHead.getWidth(), 35));
		recordHead.setFont(new Font("΢���ź�", Font.PLAIN, 15));
		recordTableModel = new DefaultTableModel( GetDataUtil.getAllUserRecordData(),
                new String[] {
                        "��¼���", "�û���",  "�ļ���", "�������", "�黹����", "���"
                }){
            @Override
            public boolean isCellEditable(int row, int column)
            {
                return false;
            }
        };
		table_record.setModel(recordTableModel);
		scrollPane_record.setViewportView(table_record);
		
		JPanel panel_userMessage = new JPanel();
		panel_userMessage.setBackground(Color.WHITE);
		tabbedPane.addTab("�û���Ϣ", null, panel_userMessage, null);
		panel_userMessage.setLayout(null);
		
		JScrollPane scrollPane_userMessage = new JScrollPane();
		scrollPane_userMessage.setBounds(60, 50, 600, 300);
		panel_userMessage.add(scrollPane_userMessage);


		table_userMessage = new JTable();
		table_userMessage.setRowHeight(35);
		table_userMessage.setFont(new Font("΢���ź�", Font.PLAIN, 15));
		table_userMessage.setBackground(Color.WHITE);
		JTableHeader userHead = table_userMessage.getTableHeader();
		userHead.setPreferredSize(new Dimension(userHead.getWidth(), 35));
		userHead.setFont(new Font("΢���ź�", Font.PLAIN, 15));
		userTableModel = new DefaultTableModel(GetDataUtil.getAllUserInfoData(),
                new String[] {
                        "�û���", "����", "�绰"
                }){
            @Override
            public boolean isCellEditable(int row, int column)
            {
                return false;
            }
        };
		table_userMessage.setModel(userTableModel);
		scrollPane_userMessage.setViewportView(table_userMessage);
		
		JButton btnNewButton_deleteUser = new JButton("ɾ���û�");
		btnNewButton_deleteUser.setFont(new Font("΢���ź�", Font.PLAIN, 15));
		btnNewButton_deleteUser.setBackground(Color.WHITE);
		btnNewButton_deleteUser.setBounds(674, 180, 113, 42);
		panel_userMessage.add(btnNewButton_deleteUser);


		JLabel lblNewLabel_username = new JLabel("�û���:");
		lblNewLabel_username.setFont(new Font("΢���ź�", Font.PLAIN, 15));
		lblNewLabel_username.setBounds(245, 375, 72, 24);
		panel_userMessage.add(lblNewLabel_username);
		
		JLabel lblNewLabel_password = new JLabel("����:");
		lblNewLabel_password.setFont(new Font("΢���ź�", Font.PLAIN, 15));
		lblNewLabel_password.setBounds(259, 415, 72, 24);
		panel_userMessage.add(lblNewLabel_password);
		
		JLabel lblNewLabel_tel = new JLabel("�绰:");
		lblNewLabel_tel.setFont(new Font("΢���ź�", Font.PLAIN, 15));
		lblNewLabel_tel.setBounds(259, 455, 72, 24);
		panel_userMessage.add(lblNewLabel_tel);
		
		textField_userName = new JTextField();
		textField_userName.setBounds(302, 376, 170, 24);
		panel_userMessage.add(textField_userName);
		textField_userName.setColumns(10);
		
		textField_password = new JTextField();
		textField_password.setBounds(302, 417, 170, 24);
		panel_userMessage.add(textField_password);
		textField_password.setColumns(10);
		
		textField_tel = new JTextField();
		textField_tel.setBounds(302, 455, 170, 24);
		panel_userMessage.add(textField_tel);
		textField_tel.setColumns(10);
		
		JButton btnNewButton_addUser = new JButton("�����û�");
		btnNewButton_addUser.setFont(new Font("΢���ź�", Font.PLAIN, 15));
		btnNewButton_addUser.setBackground(Color.WHITE);
		btnNewButton_addUser.setBounds(325, 492, 113, 27);
		panel_userMessage.add(btnNewButton_addUser);


//�û����ģ��
        JPanel panel_rent = new JPanel();
        panel_rent.setBackground(Color.WHITE);
        tabbedPane.addTab("�û����", null, panel_rent, null);
        panel_rent.setLayout(null);

		JLabel lblNewLabel_username2 = new JLabel("�û���:");
		lblNewLabel_username2.setFont(new Font("΢���ź�", Font.PLAIN, 15));
		lblNewLabel_username2.setBounds(150, 20, 60, 24);
		panel_rent.add(lblNewLabel_username2);

		user = new JComboBox();
		userComboBoxModel = new DefaultComboBoxModel(managerService.findAllUsername());
		user.setModel(userComboBoxModel);
		user.setBounds(210, 20, 119, 24);
		panel_rent.add(user);

		JLabel lblNewLabel_password2 = new JLabel("����:");
		lblNewLabel_password2.setFont(new Font("΢���ź�", Font.PLAIN, 15));
		lblNewLabel_password2.setBounds(444, 20, 60, 24);
		panel_rent.add(lblNewLabel_password2);

		passwordField_password = new JPasswordField();
		passwordField_password.setBounds(487, 20, 170, 24);
		panel_rent.add(passwordField_password);
		passwordField_password.setColumns(10);

		JScrollPane scrollPane_videoMessage2 = new JScrollPane();
		scrollPane_videoMessage2.setBounds(149, 69, 509, 329);
		panel_rent.add(scrollPane_videoMessage2);

		table_videoMessage2 = new JTable();
		table_videoMessage2.setRowHeight(35);
		table_videoMessage2.setFont(new Font("΢���ź�", Font.PLAIN, 15));
		table_videoMessage2.setBackground(Color.WHITE);
		JTableHeader vedioHead = table_videoMessage2.getTableHeader();
		vedioHead.setPreferredSize(new Dimension(vedioHead.getWidth(), 35));
		vedioHead.setFont(new Font("΢���ź�", Font.PLAIN, 15));
		vedioTableModel2 = new DefaultTableModel(GetDataUtil.getVacantFileData(),
				new String[] {
						"¼����", "�۸�(Ԫ/��)", "�ļ���"
				}){
			@Override
			public boolean isCellEditable(int row, int column)
			{
				return false;
			}
		};
		table_videoMessage2.setModel(vedioTableModel2);
		scrollPane_videoMessage2.setViewportView(table_videoMessage2);

		JButton btnNewButton_rent = new JButton("���");
		btnNewButton_rent.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		btnNewButton_rent.setBackground(Color.WHITE);
		btnNewButton_rent.setBounds(350, 442, 113, 42);
		panel_rent.add(btnNewButton_rent);


//�û��黹ģ��
		JPanel panel_return = new JPanel();
		panel_return.setBackground(Color.WHITE);
		tabbedPane.addTab("�û��黹", null, panel_return, null);
		panel_return.setLayout(null);

		JLabel lblNewLabel_username3 = new JLabel("�û���:");
		lblNewLabel_username3.setFont(new Font("΢���ź�", Font.PLAIN, 15));
		lblNewLabel_username3.setBounds(100, 20, 72, 24);
		panel_return.add(lblNewLabel_username3);

		user2 = new JComboBox();
		user2.setModel(userComboBoxModel);
		user2.setBounds(160, 20, 119, 24);
		panel_return.add(user2);

		JButton button_find = new JButton("��ѯ");
		button_find.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		button_find.setBackground(Color.WHITE);
		button_find.setBounds(588, 20, 119, 24);
		panel_return.add(button_find);

		scrollPane_returnRecord = new JScrollPane();
		scrollPane_returnRecord.setBounds(99, 69, 609, 329);
		panel_return.add(scrollPane_returnRecord);

		table_returnRecord = new JTable();
		table_returnRecord.setRowHeight(35);
		table_returnRecord.setFont(new Font("΢���ź�", Font.PLAIN, 15));
		table_returnRecord.setBackground(Color.WHITE);
		JTableHeader returnHead = table_returnRecord.getTableHeader();
		returnHead.setPreferredSize(new Dimension(returnHead.getWidth(), 35));
		returnHead.setFont(new Font("΢���ź�", Font.PLAIN, 15));

		noReturnTableModel = new DefaultTableModel(null,
				new String[] {
						"¼����", "�ļ���", "�������", "�������"
				}){
			@Override
			public boolean isCellEditable(int row, int column)
			{
				return false;
			}
		};
		table_returnRecord.setModel(noReturnTableModel);
		scrollPane_returnRecord.setViewportView(table_returnRecord);

		JButton button_return = new JButton("�黹");
		button_return.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		button_return.setBackground(Color.WHITE);
		button_return.setBounds(350, 442, 113, 42);
		panel_return.add(button_return);



		GuiUtil.setTableColumnCenter(table_videoMessage);
		GuiUtil.setTableColumnCenter(table_fileMessage);
		GuiUtil.setTableColumnCenter(table_record);
		GuiUtil.setTableColumnCenter(table_userMessage);
		GuiUtil.setTableColumnCenter(table_videoMessage2);
		GuiUtil.setTableColumnCenter(table_returnRecord);

        btnNewButton_deleteVideo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
				int n = JOptionPane.showConfirmDialog(null, "ɾ��¼���������ļ������޼�¼Ҳ��һ��ɾ�����Ƿ����ɾ��?", "ɾ��¼��",JOptionPane.YES_NO_OPTION);
				if (n == 0) {
					int index = table_videoMessage.getSelectedRow();
					if (index == -1) {
						JOptionPane.showMessageDialog(null, "��ѡ��Ҫɾ����¼��", "ɾ��ʧ��", JOptionPane.ERROR_MESSAGE);
						return;
					} else {
						long id = Long.valueOf(String.valueOf(table_videoMessage.getValueAt(index, 0))).longValue();
						managerService.deleteVedio(id);
						//ɾ��ѡ����
						vedioTableModel.removeRow(index);
						//ˢ��
						vedioTableModel.fireTableDataChanged();

						fileTableModel.setDataVector(GetDataUtil.getFileData(), new String[]{
								"�ļ����", "¼����", "¼����", "�������(0:����� 1:δ���)"
						});
						recordTableModel.setDataVector(GetDataUtil.getAllUserRecordData(), new String[]{
								"��¼���", "�û���", "�ļ���", "�������", "�黹����", "���"
						});

						vedioTableModel2.setDataVector(GetDataUtil.getVacantFileData(),new String[] {
								"¼����", "�۸�(Ԫ/��)", "�ļ���"
						});

						JOptionPane.showMessageDialog(null, "ɾ���ɹ���");
					}
				} else {
					return;
				}


            }
        });
        btnNewButton_addVideo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String vedioname = textField_videoName.getText();
				double price;
				try {
					price = Double.parseDouble(textField_price.getText());
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "��淶����۸�", "����ʧ��", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if (price <= 0) {
					JOptionPane.showMessageDialog(null, "��淶����۸�", "����ʧ��", JOptionPane.ERROR_MESSAGE);
					return;
				} else {
					if (managerService.addVedio(vedioname, price)) {
						vedioTableModel.setDataVector(GetDataUtil.getVedioData(), new String[]{
								"¼����", "¼����", "�۸�(Ԫ/��)", "�����"
						});
						vedioTableModel.fireTableDataChanged();
						JOptionPane.showMessageDialog(null, "���ӳɹ���");
					} else {
						JOptionPane.showMessageDialog(null, "����ͬ��¼��", "����ʧ��", JOptionPane.ERROR_MESSAGE);
						return;
					}
				}
            }
        });

        btnNewButton_deleteFile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
				int n = JOptionPane.showConfirmDialog(null, "ɾ���ļ�����������޼�¼Ҳ��һ��ɾ�����Ƿ����ɾ��?", "ɾ��¼��",JOptionPane.YES_NO_OPTION);
				if (n == 0) {
					int index = table_fileMessage.getSelectedRow();
					if (index == -1) {
						JOptionPane.showMessageDialog(null, "��ѡ��Ҫɾ�����ļ���", "ɾ��ʧ��", JOptionPane.ERROR_MESSAGE);
						return;
					} else {
						long id = Long.valueOf(String.valueOf(table_fileMessage.getValueAt(index, 0))).longValue();
						managerService.deleteFile(id);
						//ɾ��ѡ����
						fileTableModel.removeRow(index);
						//ˢ��
						fileTableModel.fireTableDataChanged();
						vedioTableModel.setDataVector(GetDataUtil.getVedioData(), new String[]{
								"¼����", "¼����", "�۸�(Ԫ/��)", "�����"
						});

						recordTableModel.setDataVector(GetDataUtil.getAllUserRecordData(), new String[]{
								"��¼���", "�û���", "�ļ���", "�������", "�黹����", "���"
						});
						vedioTableModel2.setDataVector(GetDataUtil.getVacantFileData(),new String[] {
								"¼����", "�۸�(Ԫ/��)", "�ļ���"
						});
						JOptionPane.showMessageDialog(null, "ɾ���ɹ���");
					}
				} else {
					return;
				}
            }
        });
        btnNewButton_addFile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
				long vedioId;
				try {
					vedioId = Long.valueOf(String.valueOf(textField_fileVideoId.getText())).longValue();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "��淶����¼���ţ�", "����ʧ��", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if (vedioId <= 0) {
						JOptionPane.showMessageDialog(null, "��淶����¼���ţ�", "����ʧ��", JOptionPane.ERROR_MESSAGE);
						return;
					} else if (managerService.addFile(vedioId)) {
						vedioTableModel.setDataVector(GetDataUtil.getVedioData(), new String[]{
								"¼����", "¼����", "�۸�(Ԫ/��)", "�����"
						});
						fileTableModel.setDataVector(GetDataUtil.getFileData(), new String[]{
								"�ļ����", "¼����", "¼����", "�������(0:����� 1:δ���)"
						});
						recordTableModel.setDataVector(GetDataUtil.getAllUserRecordData(), new String[]{
								"��¼���", "�û���", "�ļ���", "�������", "�黹����", "���"
						});
						vedioTableModel2.setDataVector(GetDataUtil.getVacantFileData(),new String[] {
							"¼����", "�۸�(Ԫ/��)", "�ļ���"
						});
						fileTableModel.fireTableDataChanged();
						JOptionPane.showMessageDialog(null, "���ӳɹ���");
					} else {
						JOptionPane.showMessageDialog(null, "û�иñ�ŵ�¼��", "����ʧ��", JOptionPane.ERROR_MESSAGE);
						return;
					}
				}

        });
        btnNewButton_deleteUser.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
				int n = JOptionPane.showConfirmDialog(null, "ɾ���û�����������޼�¼Ҳ��һ��ɾ�����Ƿ����ɾ��?", "ɾ���û�",JOptionPane.YES_NO_OPTION);
				if (n == 0) {
					int index = table_userMessage.getSelectedRow();
					if (index == -1) {
						JOptionPane.showMessageDialog(null, "��ѡ��Ҫɾ�����û���", "ɾ��ʧ��", JOptionPane.ERROR_MESSAGE);
						return;
					} else {
						managerService.deleteUser((String) table_userMessage.getValueAt(index, 0));
						//ɾ��ѡ����
						userTableModel.removeRow(index);
						//ˢ��
						userTableModel.fireTableDataChanged();

						recordTableModel.setDataVector(GetDataUtil.getAllUserRecordData(), new String[]{
								"��¼���", "�û���", "�ļ���", "�������", "�黹����", "���"
						});

						userComboBoxModel = new DefaultComboBoxModel(managerService.findAllUsername());
						user.setModel(userComboBoxModel);
						user2.setModel(userComboBoxModel);
						JOptionPane.showMessageDialog(null, "ɾ���ɹ���");
					}
				}
            }
        });
        btnNewButton_addUser.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = textField_userName.getText();
                String password = textField_password.getText();
                String phonenum = textField_tel.getText();
                if (username.length() > 11 || password.length() > 11 || phonenum.length() > 11) {
                    JOptionPane.showMessageDialog(null, "���Ȳ��ܳ���11λ����淶���룡","����ʧ��", JOptionPane.ERROR_MESSAGE);
                    return;
                } else if (username.length() == 0 || password.length() == 0 || phonenum.length() == 0) {
                    JOptionPane.showMessageDialog(null, "���벻��Ϊ�գ���淶���룡","����ʧ��", JOptionPane.ERROR_MESSAGE);
                    return;
                } else {
                    UserInfo userinfo = new UserInfo();
					userinfo.setPhonenum(phonenum);
					userinfo.setUsername(username);
					userinfo.setPassword(password);
					userinfo.setRole(0);
                    if (managerService.register(userinfo)) {
                        userTableModel.setDataVector(GetDataUtil.getAllUserInfoData(), new String[]{
								"�û���", "����", "�绰"
                        });
                        userTableModel.fireTableDataChanged();

						userComboBoxModel = new DefaultComboBoxModel(managerService.findAllUsername());
						user.setModel(userComboBoxModel);
						user2.setModel(userComboBoxModel);
                        JOptionPane.showMessageDialog(null, "���ӳɹ���");
                    } else {
                        JOptionPane.showMessageDialog(null, "���û����Ѵ��ڣ�","����ʧ��", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
		btnNewButton_rent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = user.getSelectedItem().toString();
				String password = String.valueOf(passwordField_password.getPassword());
				if (managerService.login(username, password, 0)) {
					int index = table_videoMessage2.getSelectedRow();
					if (index == -1) {
						JOptionPane.showMessageDialog(null, "��ѡ��Ҫ����¼���ļ���", "���ʧ��", JOptionPane.ERROR_MESSAGE);
						return;
					} else {
						String vedioname = (String) table_videoMessage2.getValueAt(index, 0);
						long fid = Long.valueOf(String.valueOf(table_videoMessage2.getValueAt(index, 2)));
						managerService.rentVedio(username, vedioname, fid);

						//ɾ������
						vedioTableModel2.removeRow(index);
						//ˢ��
						vedioTableModel2.fireTableDataChanged();

						//¼����Ϣ �ļ���Ϣ ������Ϣ����
						recordTableModel.setDataVector(GetDataUtil.getAllUserRecordData(), new String[]{
								"��¼���", "�û���", "�ļ���", "�������", "�黹����", "���"
						});
						vedioTableModel.setDataVector(GetDataUtil.getVedioData(), new String[]{
								"¼����", "¼����", "�۸�(Ԫ/��)", "�����"
						});
						fileTableModel.setDataVector(GetDataUtil.getFileData(), new String[]{
								"�ļ����", "¼����", "¼����", "�������(0:����� 1:δ���)"
						});

						JOptionPane.showMessageDialog(null, "���ɹ���");

					}
				} else {
					JOptionPane.showMessageDialog(null, "��������ȷ�����룡", "���ʧ��", JOptionPane.ERROR_MESSAGE);
					return;
				}
			}
		});

		button_find.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = user2.getSelectedItem().toString();
				noReturnTableModel.setDataVector(GetDataUtil.getNoReturnData(username),
						new String[] {
								"¼����", "�ļ���", "�������", "�������"
						});
			}
		});


		button_return.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = user2.getSelectedItem().toString();
				int index = table_returnRecord.getSelectedRow();
				if (index == -1) {
					JOptionPane.showMessageDialog(null, "��ѡ��Ҫ�黹��¼���ļ���","�黹ʧ��", JOptionPane.ERROR_MESSAGE);
					return;
				}
				String vedioname = (String) table_returnRecord.getValueAt(index, 0);
				long fid = Long.valueOf(String.valueOf(table_returnRecord.getValueAt(index, 1))).longValue();
				double amount =Double.parseDouble(table_returnRecord.getValueAt(index, 3).toString());
				managerService.retrunVedio(username,vedioname,fid,amount);
				//ɾ��ѡ����
				noReturnTableModel.removeRow(index);
				//ˢ��
				noReturnTableModel.fireTableDataChanged();

				//¼����Ϣ �ļ���Ϣ ������Ϣ �û�����ڱ� ����
				recordTableModel.setDataVector(GetDataUtil.getAllUserRecordData(), new String[]{
						"��¼���", "�û���", "�ļ���", "�������", "�黹����", "���"
				});
				vedioTableModel.setDataVector(GetDataUtil.getVedioData(), new String[]{
						"¼����", "¼����", "�۸�(Ԫ/��)", "�����"
				});
				fileTableModel.setDataVector(GetDataUtil.getFileData(), new String[]{
						"�ļ����", "¼����", "¼����", "�������(0:����� 1:δ���)"
				});
				vedioTableModel2.setDataVector(GetDataUtil.getVacantFileData(),new String[] {
						"¼����", "�۸�(Ԫ/��)", "�ļ���"
				});

				JOptionPane.showMessageDialog(null, "�黹�ɹ���");
			}
		});

		btnNewButton_exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				IndexPage f1=new IndexPage();
				f1.frame.setVisible(true);

			}
		});


    }
}