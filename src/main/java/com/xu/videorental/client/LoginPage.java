package com.xu.videorental.client;

import com.xu.videorental.service.UserService;
import com.xu.videorental.service.impl.UserServiceImpl;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginPage extends JFrame {
	private JPanel contentPane;
	private JTextField textField_name;
	private JPasswordField passwordField_password;
	private JComboBox comboBox;

	public LoginPage() {
		final UserService userService = new UserServiceImpl();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("登录界面");
		setBounds(100, 100, 817, 644);
		int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
		int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
		setLocation((screenWidth - 817)/2, (screenHeight-644)/2);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 800, 600);
		contentPane.add(panel);
		panel.setLayout(null);
		
		textField_name = new JTextField();
		textField_name.setBounds(360, 180, 138, 24);
		panel.add(textField_name);
		textField_name.setColumns(10);
		
		passwordField_password =new JPasswordField();
		passwordField_password.setColumns(10);
		passwordField_password.setBounds(360, 242, 138, 24);
		panel.add(passwordField_password);

		JLabel lblNewLabel_Slogan = new JLabel("####欢迎登录####");
		lblNewLabel_Slogan.setFont(new Font("微软雅黑", Font.PLAIN, 30));
		lblNewLabel_Slogan.setBounds(280, 50, 500, 50);
		panel.add(lblNewLabel_Slogan);

		JLabel lblNewLabel_name = new JLabel("用户名:");
		lblNewLabel_name.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		lblNewLabel_name.setBounds(302, 179, 60, 20);
		panel.add(lblNewLabel_name);
		
		JLabel lblNewLabel_password = new JLabel("密码:");
		lblNewLabel_password.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		lblNewLabel_password.setBounds(302, 241, 60, 20);
		panel.add(lblNewLabel_password);

		JLabel label = new JLabel("角色:");
		label.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		label.setBounds(302, 303, 60, 20);
		panel.add(label);

		JButton btnNewButton_login = new JButton("登 录");
		btnNewButton_login.setForeground(Color.BLACK);
		btnNewButton_login.setBackground(Color.WHITE);
		btnNewButton_login.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		btnNewButton_login.setBounds(283, 362, 113, 42);
		panel.add(btnNewButton_login);
		
		JButton btnNewButton_back = new JButton("返 回");
		btnNewButton_back.setBackground(Color.WHITE);
		btnNewButton_back.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		btnNewButton_back.setBounds(427, 362, 113, 42);
		panel.add(btnNewButton_back);

		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"会员", "管理员"}));
		comboBox.setBounds(360, 300, 119, 24);
		panel.add(comboBox);

		btnNewButton_login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String username = textField_name.getText();
				String password = String.valueOf(passwordField_password.getPassword());
				long role = "会员".equals(comboBox.getSelectedItem().toString()) ? 0 : 1;

				if (username.length() > 11 || password.length() > 11) {
					JOptionPane.showMessageDialog(null, "长度不能超过11位，请规范输入！","登录失败", JOptionPane.ERROR_MESSAGE);
					return;
				} else if (username.length() == 0 || password.length() == 0) {
					JOptionPane.showMessageDialog(null, "输入不能为空，请规范输入！", "登录失败", JOptionPane.ERROR_MESSAGE);
					return;
				} else {
					if (role == 0) {
						if (userService.login(username, password, role)) {
							setVisible(false);
							UserPage userPage = new UserPage(username);
							userPage.setVisible(true);
						} else {
							JOptionPane.showMessageDialog(null, "请保证信息正确！", "登录失败", JOptionPane.ERROR_MESSAGE);
							textField_name.setText("");
							passwordField_password.setText("");
						}
					} else {
						if (userService.login(username, password, role)) {
							setVisible(false);
							AdministratorPage administratorPage = new AdministratorPage(username);
							administratorPage.setVisible(true);
						} else {
							JOptionPane.showMessageDialog(null, "请保证信息正确！", "登录失败", JOptionPane.ERROR_MESSAGE);
							textField_name.setText("");
							passwordField_password.setText("");
						}
					}
				}


			}
		});

		btnNewButton_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				IndexPage index = new IndexPage();
				index.frame.setVisible(true);
			}
		});
	}
}
