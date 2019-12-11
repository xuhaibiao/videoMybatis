package com.xu.videorental.client;

import com.xu.videorental.service.UserService;
import com.xu.videorental.service.impl.UserServiceImpl;
import com.xu.videorental.util.GetDataUtil;
import com.xu.videorental.util.GuiUtil;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class IndexPage {
	public JFrame frame;
	private JTable table;
	DefaultTableModel indexTableModel;

	public IndexPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
        UserService userService = new UserServiceImpl();
        frame = new JFrame();
        frame.setTitle("Â¼Ïñ×âÁÞÏµÍ³");
        frame.setBounds(100, 100, 800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
		int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
		int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
		frame.setLocation((screenWidth - 800)/2, (screenHeight-600)/2);


        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 800, 800);
        frame.getContentPane().add(panel);
        panel.setLayout(null);

		JLabel lblNewLabel_Slogan = new JLabel("ÎäººÀí¹¤´óÑ§Â¼Ïñ×âÁÞÏµÍ³");
		lblNewLabel_Slogan.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 30));
		lblNewLabel_Slogan.setBounds(208, 10, 500, 50);
		panel.add(lblNewLabel_Slogan);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(117, 105, 545, 270);
		panel.add(scrollPane);

        JButton btnNewButton_login = new JButton("µÇ Â¼");
		btnNewButton_login.setBackground(Color.WHITE);
		btnNewButton_login.setBounds(225, 426, 113, 42);
		btnNewButton_login.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
        panel.add(btnNewButton_login);

        JButton btnNewButton_signup = new JButton("×¢ ²á");
		btnNewButton_signup.setBackground(Color.WHITE);
		btnNewButton_signup.setBounds(445, 426, 113, 42);
		btnNewButton_signup.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
		panel.add(btnNewButton_signup);

        table = new JTable();
		table.setRowHeight(35);
		table.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		table.setBackground(Color.WHITE);
		JTableHeader head = table.getTableHeader();
		head.setPreferredSize(new Dimension(head.getWidth(), 35));
		head.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));

		indexTableModel = new DefaultTableModel( GetDataUtil.getVideoRecordingData(),
				new String[] {
						"Â¼ÏñÃû", "¼Û¸ñ(Ôª/Ìì)", "¿â´æ"
				}){
			@Override
			public boolean isCellEditable(int row, int column)
			{
				return false;
			}
		};
		table.setModel(indexTableModel);
		scrollPane.setViewportView(table);

		GuiUtil.setTableColumnCenter(table);

		btnNewButton_login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				com.xu.videorental.client.LoginPage f1=new com.xu.videorental.client.LoginPage();
				f1.setVisible(true);
			}
		});

		btnNewButton_signup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				com.xu.videorental.client.SignupPage f1=new com.xu.videorental.client.SignupPage();
				f1.setVisible(true);
			}
		});
	}

}
