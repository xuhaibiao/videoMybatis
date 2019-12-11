package com.xu.videorental.client;

import com.xu.videorental.doMain.table.UserInfo;
import com.xu.videorental.service.ManagerService;
import com.xu.videorental.service.impl.ManagerServiceImpl;
import com.xu.videorental.util.GetDataUtil;
import com.xu.videorental.util.GuiUtil;

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
    private DefaultTableModel videoTableModel;
    private DefaultTableModel videoTableModel2;
    private DefaultTableModel fileTableModel;
    private DefaultTableModel recordTableModel;
    private DefaultTableModel userTableModel;
	private JComboBox user;
	private JComboBox user2;
	private JComboBox deposit;
	private JComboBox type;

	private DefaultTableModel noReturnTableModel;
	private DefaultComboBoxModel userComboBoxModel;
	private JScrollPane scrollPane_returnRecord;


	public AdministratorPage(String username) {
		final ManagerService managerService = new ManagerServiceImpl();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("尊敬的 " + username + " 管理员,欢迎您！");
		setBounds(100, 100, 848, 618);
		int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
		int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
		setLocation((screenWidth - 848) / 2, (screenHeight - 618) / 2);
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

		JButton btnNewButton_exit = new JButton("退出");
		btnNewButton_exit.setBackground(Color.WHITE);
		btnNewButton_exit.setBounds(14, 0, 87, 23);
		panel_exit.add(btnNewButton_exit);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(Color.WHITE);
		tabbedPane.setBounds(0, 0, 820, 570);
		panel.add(tabbedPane);

		//录像管理
		JPanel panel_videoMessage = new JPanel();
		panel_videoMessage.setBackground(Color.WHITE);
		tabbedPane.addTab("录像管理", null, panel_videoMessage, null);
		panel_videoMessage.setLayout(null);

		JScrollPane scrollPane_videoMessage = new JScrollPane();
		scrollPane_videoMessage.setBounds(60, 60, 600, 400);
		panel_videoMessage.add(scrollPane_videoMessage);

		table_videoMessage = new JTable();
		table_videoMessage.setRowHeight(35);
		table_videoMessage.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		table_videoMessage.setBackground(Color.WHITE);
		JTableHeader videoHead = table_videoMessage.getTableHeader();
		videoHead.setPreferredSize(new Dimension(videoHead.getWidth(), 35));
		videoHead.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		videoTableModel = new DefaultTableModel(GetDataUtil.getVideoData(),
				new String[]{
						"录像编号", "录像名", "价格(元/天)", "库存量"
				}) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table_videoMessage.setModel(videoTableModel);
		scrollPane_videoMessage.setViewportView(table_videoMessage);

		JButton btnNewButton_deleteVideo = new JButton("删除录像");
		btnNewButton_deleteVideo.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		btnNewButton_deleteVideo.setBackground(Color.WHITE);
		btnNewButton_deleteVideo.setBounds(674, 236, 113, 42);
		panel_videoMessage.add(btnNewButton_deleteVideo);

		JLabel lblNewLabel_type = new JLabel("修改类别:");
		lblNewLabel_type.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		lblNewLabel_type.setBounds(60, 15, 70, 24);
		panel_videoMessage.add(lblNewLabel_type);

		type = new JComboBox();
		type.setModel(new DefaultComboBoxModel(new String[]{"录像名", "价格"}));
		type.setBounds(130, 15, 70, 24);
		panel_videoMessage.add(type);

		JButton btnNewButton_updateVideo = new JButton("修改录像");
		btnNewButton_updateVideo.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		btnNewButton_updateVideo.setBackground(Color.WHITE);
		btnNewButton_updateVideo.setBounds(547, 15, 113, 27);
		panel_videoMessage.add(btnNewButton_updateVideo);


		textField_videoName = new JTextField();
		textField_videoName.setBounds(115, 480, 177, 24);
		panel_videoMessage.add(textField_videoName);
		textField_videoName.setColumns(10);

		JLabel lblNewLabel_videlName = new JLabel("录像名:");
		lblNewLabel_videlName.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		lblNewLabel_videlName.setBounds(60, 480, 72, 24);
		panel_videoMessage.add(lblNewLabel_videlName);

		JLabel lblNewLabel_price = new JLabel("价格:");
		lblNewLabel_price.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		lblNewLabel_price.setBounds(327, 480, 72, 24);
		panel_videoMessage.add(lblNewLabel_price);

		textField_price = new JTextField();
		textField_price.setBounds(367, 480, 86, 24);
		panel_videoMessage.add(textField_price);
		textField_price.setColumns(10);

		JLabel lblNewLabel_priceUnit = new JLabel("元/天");
		lblNewLabel_priceUnit.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		lblNewLabel_priceUnit.setBounds(455, 480, 72, 24);
		panel_videoMessage.add(lblNewLabel_priceUnit);

		JButton btnNewButton_addVideo = new JButton("添加录像");
		btnNewButton_addVideo.setBackground(Color.WHITE);
		btnNewButton_addVideo.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		btnNewButton_addVideo.setBounds(547, 479, 113, 27);
		panel_videoMessage.add(btnNewButton_addVideo);


		//文件管理
		JPanel panel_fileMessage = new JPanel();
		panel_fileMessage.setBackground(Color.WHITE);
		tabbedPane.addTab("文件管理", null, panel_fileMessage, null);
		panel_fileMessage.setLayout(null);

		JScrollPane scrollPane_fileMessage = new JScrollPane();
		scrollPane_fileMessage.setBounds(60, 50, 600, 400);
		panel_fileMessage.add(scrollPane_fileMessage);


		table_fileMessage = new JTable();
		table_fileMessage.setRowHeight(35);
		table_fileMessage.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		table_fileMessage.setBackground(Color.WHITE);
		JTableHeader fileHead = table_fileMessage.getTableHeader();
		fileHead.setPreferredSize(new Dimension(fileHead.getWidth(), 35));
		fileHead.setFont(new Font("微软雅黑", Font.PLAIN, 11));
		fileTableModel = new DefaultTableModel(GetDataUtil.getFileData(),
				new String[]{
						"文件编号", "录像编号", "录像名", "出借情况"
				}) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table_fileMessage.setModel(fileTableModel);
		scrollPane_fileMessage.setViewportView(table_fileMessage);

		JButton btnNewButton_deleteFile = new JButton("删除文件");
		btnNewButton_deleteFile.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		btnNewButton_deleteFile.setBackground(Color.WHITE);
		btnNewButton_deleteFile.setBounds(674, 236, 113, 42);
		panel_fileMessage.add(btnNewButton_deleteFile);


		JLabel lblNewLabel_fileVideoId = new JLabel("录像编号:");
		lblNewLabel_fileVideoId.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		lblNewLabel_fileVideoId.setBounds(209, 480, 72, 24);
		panel_fileMessage.add(lblNewLabel_fileVideoId);

		textField_fileVideoId = new JTextField();
		textField_fileVideoId.setBounds(280, 480, 50, 24);
		panel_fileMessage.add(textField_fileVideoId);
		textField_fileVideoId.setColumns(10);

		JButton btnNewButton_addFile = new JButton("添加文件");
		btnNewButton_addFile.setBackground(Color.WHITE);
		btnNewButton_addFile.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		btnNewButton_addFile.setBounds(430, 479, 113, 27);
		panel_fileMessage.add(btnNewButton_addFile);


		JPanel panel_record = new JPanel();
		panel_record.setBackground(Color.WHITE);
		tabbedPane.addTab("租赁记录", null, panel_record, null);
		panel_record.setLayout(null);

		JScrollPane scrollPane_record = new JScrollPane();
		scrollPane_record.setBounds(60, 50, 700, 430);
		panel_record.add(scrollPane_record);

		//租赁记录
		table_record = new JTable();
		table_record.setRowHeight(35);
		table_record.setBackground(Color.WHITE);
		table_record.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		JTableHeader recordHead = table_record.getTableHeader();
		recordHead.setPreferredSize(new Dimension(recordHead.getWidth(), 35));
		recordHead.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		recordTableModel = new DefaultTableModel(GetDataUtil.getAllUserRecordData(),
				new String[]{
						"记录编号", "用户名", "文件号", "租借日期", "押金", "归还日期", "结算金额"
				}) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table_record.setModel(recordTableModel);
		scrollPane_record.setViewportView(table_record);

		//用户信息
		JPanel panel_userMessage = new JPanel();
		panel_userMessage.setBackground(Color.WHITE);
		tabbedPane.addTab("用户信息", null, panel_userMessage, null);
		panel_userMessage.setLayout(null);

		JScrollPane scrollPane_userMessage = new JScrollPane();
		scrollPane_userMessage.setBounds(60, 50, 600, 300);
		panel_userMessage.add(scrollPane_userMessage);


		table_userMessage = new JTable();
		table_userMessage.setRowHeight(35);
		table_userMessage.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		table_userMessage.setBackground(Color.WHITE);
		JTableHeader userHead = table_userMessage.getTableHeader();
		userHead.setPreferredSize(new Dimension(userHead.getWidth(), 35));
		userHead.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		userTableModel = new DefaultTableModel(GetDataUtil.getAllUserInfoData(),
				new String[]{
						"用户名", "密码", "电话"
				}) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table_userMessage.setModel(userTableModel);
		scrollPane_userMessage.setViewportView(table_userMessage);

		JButton btnNewButton_deleteUser = new JButton("删除用户");
		btnNewButton_deleteUser.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		btnNewButton_deleteUser.setBackground(Color.WHITE);
		btnNewButton_deleteUser.setBounds(674, 180, 113, 42);
		panel_userMessage.add(btnNewButton_deleteUser);


		JLabel lblNewLabel_username = new JLabel("用户名:");
		lblNewLabel_username.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		lblNewLabel_username.setBounds(245, 375, 72, 24);
		panel_userMessage.add(lblNewLabel_username);

		JLabel lblNewLabel_password = new JLabel("密码:");
		lblNewLabel_password.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		lblNewLabel_password.setBounds(259, 415, 72, 24);
		panel_userMessage.add(lblNewLabel_password);

		JLabel lblNewLabel_tel = new JLabel("电话:");
		lblNewLabel_tel.setFont(new Font("微软雅黑", Font.PLAIN, 15));
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

		JButton btnNewButton_addUser = new JButton("添加用户");
		btnNewButton_addUser.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		btnNewButton_addUser.setBackground(Color.WHITE);
		btnNewButton_addUser.setBounds(325, 492, 113, 27);
		panel_userMessage.add(btnNewButton_addUser);


//用户租借模块
		JPanel panel_rent = new JPanel();
		panel_rent.setBackground(Color.WHITE);
		tabbedPane.addTab("用户租借", null, panel_rent, null);
		panel_rent.setLayout(null);

		JLabel lblNewLabel_username2 = new JLabel("用户名:");
		lblNewLabel_username2.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		lblNewLabel_username2.setBounds(150, 35, 60, 24);
		panel_rent.add(lblNewLabel_username2);

		user = new JComboBox();
		userComboBoxModel = new DefaultComboBoxModel(managerService.findAllUsername());
		user.setModel(userComboBoxModel);
		user.setBounds(210, 35, 100, 24);
		panel_rent.add(user);

		JLabel lblNewLabel_password2 = new JLabel("密码:");
		lblNewLabel_password2.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		lblNewLabel_password2.setBounds(320, 35, 40, 24);
		panel_rent.add(lblNewLabel_password2);

		passwordField_password = new JPasswordField();
		passwordField_password.setBounds(360, 35, 100, 24);
		panel_rent.add(passwordField_password);
		passwordField_password.setColumns(10);


		final JLabel lblNewLabel_deposit = new JLabel("押金:");
		lblNewLabel_deposit.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		lblNewLabel_deposit.setBounds(517, 35, 40, 24);
		panel_rent.add(lblNewLabel_deposit);

		deposit = new JComboBox();
		deposit.setModel(new DefaultComboBoxModel(new String[]{"100", "200"}));
		deposit.setBounds(557, 35, 100, 24);
		panel_rent.add(deposit);

		JScrollPane scrollPane_videoMessage2 = new JScrollPane();
		scrollPane_videoMessage2.setBounds(149, 89, 509, 329);
		panel_rent.add(scrollPane_videoMessage2);

		table_videoMessage2 = new JTable();
		table_videoMessage2.setRowHeight(35);
		table_videoMessage2.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		table_videoMessage2.setBackground(Color.WHITE);
		JTableHeader videoHead2 = table_videoMessage2.getTableHeader();
        videoHead2.setPreferredSize(new Dimension(videoHead.getWidth(), 35));
        videoHead2.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		videoTableModel2 = new DefaultTableModel(GetDataUtil.getVacantFileData(),
				new String[]{
						"录像名", "价格(元/天)", "文件号"
				}) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table_videoMessage2.setModel(videoTableModel2);
		scrollPane_videoMessage2.setViewportView(table_videoMessage2);

		JButton btnNewButton_rent = new JButton("租借");
		btnNewButton_rent.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		btnNewButton_rent.setBackground(Color.WHITE);
		btnNewButton_rent.setBounds(350, 462, 113, 42);
		panel_rent.add(btnNewButton_rent);


//用户归还模块
		JPanel panel_return = new JPanel();
		panel_return.setBackground(Color.WHITE);
		tabbedPane.addTab("用户归还", null, panel_return, null);
		panel_return.setLayout(null);

		JLabel lblNewLabel_username3 = new JLabel("用户名:");
		lblNewLabel_username3.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		lblNewLabel_username3.setBounds(100, 35, 72, 24);
		panel_return.add(lblNewLabel_username3);

		user2 = new JComboBox();
		user2.setModel(userComboBoxModel);
		user2.setBounds(160, 35, 119, 24);
		panel_return.add(user2);

		JButton button_find = new JButton("查询");
		button_find.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		button_find.setBackground(Color.WHITE);
		button_find.setBounds(588, 35, 119, 24);
		panel_return.add(button_find);

		scrollPane_returnRecord = new JScrollPane();
		scrollPane_returnRecord.setBounds(49, 89, 709, 329);
		panel_return.add(scrollPane_returnRecord);

		table_returnRecord = new JTable();
		table_returnRecord.setRowHeight(35);
		table_returnRecord.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		table_returnRecord.setBackground(Color.WHITE);
		JTableHeader returnHead = table_returnRecord.getTableHeader();
		returnHead.setPreferredSize(new Dimension(returnHead.getWidth(), 35));
		returnHead.setFont(new Font("微软雅黑", Font.PLAIN, 15));

		noReturnTableModel = new DefaultTableModel(null,
				new String[]{
						"录像名", "文件号", "租借日期", "押金", "所需租金"
				}) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table_returnRecord.setModel(noReturnTableModel);
		scrollPane_returnRecord.setViewportView(table_returnRecord);

		JButton button_return = new JButton("归还");
		button_return.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		button_return.setBackground(Color.WHITE);
		button_return.setBounds(350, 462, 113, 42);
		panel_return.add(button_return);


		GuiUtil.setTableColumnCenter(table_videoMessage);
		GuiUtil.setTableColumnCenter(table_fileMessage);
		GuiUtil.setTableColumnCenter(table_record);
		GuiUtil.setTableColumnCenter(table_userMessage);
		GuiUtil.setTableColumnCenter(table_videoMessage2);
		GuiUtil.setTableColumnCenter(table_returnRecord);

		btnNewButton_deleteVideo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int n = JOptionPane.showConfirmDialog(null, "删除录像后其相关文件与租赁记录也会一并删除，是否继续删除?", "删除录像", JOptionPane.YES_NO_OPTION);
				if (n == 0) {
					int index = table_videoMessage.getSelectedRow();
					if (index == -1) {
						JOptionPane.showMessageDialog(null, "请选择要删除的录像！", "删除失败", JOptionPane.ERROR_MESSAGE);
						return;
					} else {
						long id = Long.valueOf(String.valueOf(table_videoMessage.getValueAt(index, 0))).longValue();
						managerService.deleteVideo(id);
						//删除选中行
						videoTableModel.removeRow(index);
						//刷新
						videoTableModel.fireTableDataChanged();

						fileTableModel.setDataVector(GetDataUtil.getFileData(), new String[]{
								"文件编号", "录像编号", "录像名", "出借情况(0:已租借 1:未租借)"
						});
						recordTableModel.setDataVector(GetDataUtil.getAllUserRecordData(), new String[]{
								"记录编号", "用户名", "文件号", "租借日期", "押金", "归还日期", "租金"
						});

						videoTableModel2.setDataVector(GetDataUtil.getVacantFileData(), new String[]{
								"录像名", "价格(元/天)", "文件号"
						});

						JOptionPane.showMessageDialog(null, "删除成功！");
					}
				} else {
					return;
				}


			}
		});

		btnNewButton_updateVideo.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				int index = table_videoMessage.getSelectedRow();
				if (index == -1) {
					JOptionPane.showMessageDialog(null, "请选择要修改的录像文件！", "修改失败", JOptionPane.ERROR_MESSAGE);
					return;
				} else {
					String typeName = type.getSelectedItem().toString();
					long id = Long.valueOf(String.valueOf(table_videoMessage.getValueAt(index, 0)));
					if ("录像名".equals(typeName)) {
						Object obj = JOptionPane.showInputDialog(null,"请输入新录像名：\n","录像名修改",JOptionPane.PLAIN_MESSAGE,null,null,null);
						String newvideoName = obj.toString();
						if (newvideoName.length() == 0) {
							JOptionPane.showMessageDialog(null, "请输入录像名！", "修改失败", JOptionPane.ERROR_MESSAGE);
							return;
						} else if (newvideoName.length() > 11) {
							JOptionPane.showMessageDialog(null, "请规范输入录像名！", "修改失败", JOptionPane.ERROR_MESSAGE);
							return;
						} else if (managerService.updateVideoName(id, newvideoName)) {
							videoTableModel.setValueAt(obj, index, 1);
							videoTableModel2.setDataVector(GetDataUtil.getVacantFileData(), new String[]{
									"录像名", "价格(元/天)", "文件号"
							});
							fileTableModel.setDataVector(GetDataUtil.getFileData(), new String[]{
									"文件编号", "录像编号", "录像名", "出借情况"
							});
							videoTableModel.fireTableDataChanged();
							JOptionPane.showMessageDialog(null, "修改成功！");
						} else {
							JOptionPane.showMessageDialog(null, "修改出现错误", "修改失败", JOptionPane.ERROR_MESSAGE);
							return;
						}
					}
					if ("价格".equals(typeName)) {
						Object obj = JOptionPane.showInputDialog(null,"请输入新价格：\n","价格修改",JOptionPane.PLAIN_MESSAGE,null,null,null);
						double newvideoPrice;
						try {
							newvideoPrice = Double.parseDouble(obj.toString());
						} catch (Exception e1) {
							JOptionPane.showMessageDialog(null, "请规范输入价格！", "修改失败", JOptionPane.ERROR_MESSAGE);
							return;
						}
						if (newvideoPrice <= 0) {
							JOptionPane.showMessageDialog(null, "请规范输入价格！", "修改失败", JOptionPane.ERROR_MESSAGE);
							return;
						}else if (managerService.updateVideoPrice(id, newvideoPrice)) {
							videoTableModel.setValueAt(obj, index, 2);
							videoTableModel2.setDataVector(GetDataUtil.getVacantFileData(), new String[]{
									"录像名", "价格(元/天)", "文件号"
							});
							videoTableModel.fireTableDataChanged();
							JOptionPane.showMessageDialog(null, "修改成功！");
						} else {
							JOptionPane.showMessageDialog(null, "修改出现错误", "修改失败", JOptionPane.ERROR_MESSAGE);
							return;
						}
					}

				}

			}
		});
		btnNewButton_addVideo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String videoname = textField_videoName.getText();
				double price;
				try {
					price = Double.parseDouble(textField_price.getText());
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "请规范输入价格！", "添加失败", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if (price <= 0) {
					JOptionPane.showMessageDialog(null, "请规范输入价格！", "添加失败", JOptionPane.ERROR_MESSAGE);
					return;
				} else if (videoname.length() == 0) {
					JOptionPane.showMessageDialog(null, "请输入录像名！", "添加失败", JOptionPane.ERROR_MESSAGE);
					return;
				} else {
					if (managerService.addvideo(videoname, price)) {
						videoTableModel.setDataVector(GetDataUtil.getVideoData(), new String[]{
								"录像编号", "录像名", "价格(元/天)", "库存量"
						});
						videoTableModel.fireTableDataChanged();
						JOptionPane.showMessageDialog(null, "添加成功！");
					} else {
						JOptionPane.showMessageDialog(null, "存在同名录像！", "添加失败", JOptionPane.ERROR_MESSAGE);
						return;
					}
				}
			}
		});

		btnNewButton_deleteFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int n = JOptionPane.showConfirmDialog(null, "删除文件后其相关租赁记录也会一并删除，是否继续删除?", "删除录像", JOptionPane.YES_NO_OPTION);
				if (n == 0) {
					int index = table_fileMessage.getSelectedRow();
					if (index == -1) {
						JOptionPane.showMessageDialog(null, "请选择要删除的文件！", "删除失败", JOptionPane.ERROR_MESSAGE);
						return;
					} else {
						long id = Long.valueOf(String.valueOf(table_fileMessage.getValueAt(index, 0))).longValue();
						managerService.deleteFile(id);
						//删除选中行
						fileTableModel.removeRow(index);
						//刷新
						fileTableModel.fireTableDataChanged();
						videoTableModel.setDataVector(GetDataUtil.getVideoData(), new String[]{
								"录像编号", "录像名", "价格(元/天)", "库存量"
						});

						recordTableModel.setDataVector(GetDataUtil.getAllUserRecordData(), new String[]{
								"记录编号", "用户名", "文件号", "租借日期", "押金", "归还日期", "结算金额"
						});
						videoTableModel2.setDataVector(GetDataUtil.getVacantFileData(), new String[]{
								"录像名", "价格(元/天)", "文件号"
						});
						JOptionPane.showMessageDialog(null, "删除成功！");
					}
				} else {
					return;
				}
			}
		});
		btnNewButton_addFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				long videoId;
				try {
					videoId = Long.valueOf(String.valueOf(textField_fileVideoId.getText())).longValue();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "请规范输入录像编号！", "添加失败", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if (videoId <= 0) {
					JOptionPane.showMessageDialog(null, "请规范输入录像编号！", "添加失败", JOptionPane.ERROR_MESSAGE);
					return;
				} else if (managerService.addFile(videoId)) {
					videoTableModel.setDataVector(GetDataUtil.getVideoData(), new String[]{
							"录像编号", "录像名", "价格(元/天)", "库存量"
					});
					fileTableModel.setDataVector(GetDataUtil.getFileData(), new String[]{
							"文件编号", "录像编号", "录像名", "出借情况"
					});
					recordTableModel.setDataVector(GetDataUtil.getAllUserRecordData(), new String[]{
							"记录编号", "用户名", "文件号", "租借日期", "押金", "归还日期", "结算金额"
					});
					videoTableModel2.setDataVector(GetDataUtil.getVacantFileData(), new String[]{
							"录像名", "价格(元/天)", "文件号"
					});
					fileTableModel.fireTableDataChanged();
					JOptionPane.showMessageDialog(null, "添加成功！");
				} else {
					JOptionPane.showMessageDialog(null, "没有该编号的录像！", "添加失败", JOptionPane.ERROR_MESSAGE);
					return;
				}
			}

		});
		btnNewButton_deleteUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int n = JOptionPane.showConfirmDialog(null, "删除用户后其相关租赁记录也会一并删除，是否继续删除?", "删除用户", JOptionPane.YES_NO_OPTION);
				if (n == 0) {
					int index = table_userMessage.getSelectedRow();
					if (index == -1) {
						JOptionPane.showMessageDialog(null, "请选择要删除的用户！", "删除失败", JOptionPane.ERROR_MESSAGE);
						return;
					} else {
						managerService.deleteUser((String) table_userMessage.getValueAt(index, 0));
						//删除选中行
						userTableModel.removeRow(index);
						//刷新
						userTableModel.fireTableDataChanged();

						recordTableModel.setDataVector(GetDataUtil.getAllUserRecordData(), new String[]{
								"记录编号", "用户名", "文件号", "租借日期", "押金", "归还日期", "结算金额"
						});

						userComboBoxModel = new DefaultComboBoxModel(managerService.findAllUsername());
						user.setModel(userComboBoxModel);
						user2.setModel(userComboBoxModel);
						JOptionPane.showMessageDialog(null, "删除成功！");
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
					JOptionPane.showMessageDialog(null, "长度不能超过11位，请规范输入！", "添加失败", JOptionPane.ERROR_MESSAGE);
					return;
				} else if (username.length() == 0 || password.length() == 0 || phonenum.length() == 0) {
					JOptionPane.showMessageDialog(null, "输入不能为空，请规范输入！", "添加失败", JOptionPane.ERROR_MESSAGE);
					return;
				} else {
					UserInfo userinfo = new UserInfo();
					userinfo.setPhonenum(phonenum);
					userinfo.setUsername(username);
					userinfo.setPassword(password);
					userinfo.setRole(0);
					if (managerService.register(userinfo)) {
						userTableModel.setDataVector(GetDataUtil.getAllUserInfoData(), new String[]{
								"用户名", "密码", "电话"
						});
						userTableModel.fireTableDataChanged();

						userComboBoxModel = new DefaultComboBoxModel(managerService.findAllUsername());
						user.setModel(userComboBoxModel);
						user2.setModel(userComboBoxModel);
						JOptionPane.showMessageDialog(null, "添加成功！");
					} else {
						JOptionPane.showMessageDialog(null, "该用户名已存在！", "添加失败", JOptionPane.ERROR_MESSAGE);
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
						JOptionPane.showMessageDialog(null, "请选择要租借的录像文件！", "租借失败", JOptionPane.ERROR_MESSAGE);
						return;
					} else {
						String videoname = (String) table_videoMessage2.getValueAt(index, 0);
						long fid = Long.valueOf(String.valueOf(table_videoMessage2.getValueAt(index, 2)));
						long de = Long.valueOf(String.valueOf(deposit.getSelectedItem().toString()));
						managerService.rentVideo(username, videoname, fid, de);

						//删除改行
						videoTableModel2.removeRow(index);
						//刷新
						videoTableModel2.fireTableDataChanged();

						//录像信息 文件信息 租赁信息更新
						recordTableModel.setDataVector(GetDataUtil.getAllUserRecordData(), new String[]{
								"记录编号", "用户名", "文件号", "租借日期", "押金", "归还日期", "结算金额"
						});
						videoTableModel.setDataVector(GetDataUtil.getVideoData(), new String[]{
								"录像编号", "录像名", "价格(元/天)", "库存量"
						});
						fileTableModel.setDataVector(GetDataUtil.getFileData(), new String[]{
								"文件编号", "录像编号", "录像名", "出借情况"
						});

						JOptionPane.showMessageDialog(null, "租借成功！");

					}
				} else {
					JOptionPane.showMessageDialog(null, "请输入正确的密码！", "租借失败", JOptionPane.ERROR_MESSAGE);
					return;
				}
			}
		});

		button_find.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = user2.getSelectedItem().toString();
				noReturnTableModel.setDataVector(GetDataUtil.getNoReturnData(username),
						new String[]{
								"录像名", "文件号", "租借日期", "押金", "所需租金"
						});
			}
		});


		button_return.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = user2.getSelectedItem().toString();
				int index = table_returnRecord.getSelectedRow();
				if (index == -1) {
					JOptionPane.showMessageDialog(null, "请选择要归还的录像文件！", "归还失败", JOptionPane.ERROR_MESSAGE);
					return;
				}
				String videoname = (String) table_returnRecord.getValueAt(index, 0);
				long fid = Long.valueOf(String.valueOf(table_returnRecord.getValueAt(index, 1))).longValue();
				double amount = Double.parseDouble(table_returnRecord.getValueAt(index, 4).toString());
				managerService.retrunVideo(username, videoname, fid, amount);
				//删除选中行
				noReturnTableModel.removeRow(index);
				//刷新
				noReturnTableModel.fireTableDataChanged();

				//录像信息 文件信息 租赁信息 用户租借内表 更新
				recordTableModel.setDataVector(GetDataUtil.getAllUserRecordData(), new String[]{
						"记录编号", "用户名", "文件号", "租借日期", "押金", "归还日期", "结算金额"
				});
				videoTableModel.setDataVector(GetDataUtil.getVideoData(), new String[]{
						"录像编号", "录像名", "价格(元/天)", "库存量"
				});
				fileTableModel.setDataVector(GetDataUtil.getFileData(), new String[]{
						"文件编号", "录像编号", "录像名", "出借情况"
				});
				videoTableModel2.setDataVector(GetDataUtil.getVacantFileData(), new String[]{
						"录像名", "价格(元/天)", "文件号"
				});

				JOptionPane.showMessageDialog(null, "归还成功！");
			}
		});

		btnNewButton_exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				com.xu.videorental.client.IndexPage f1 = new com.xu.videorental.client.IndexPage();
				f1.frame.setVisible(true);

			}
		});
	}
}
