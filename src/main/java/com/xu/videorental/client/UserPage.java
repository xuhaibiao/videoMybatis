package com.xu.videorental.client;

import com.xu.videorental.util.GetDataUtil;
import com.xu.videorental.util.GuiUtil;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserPage extends JFrame {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UserPage window = new UserPage("jack");
                    window.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

	private JPanel contentPane;
	private JTable table_videoMessage;
	private JTable table_record;
	private JTable table_returnRecord;
	private DefaultTableModel videoTableModel;
	private DefaultTableModel noReturnTableModel;
	private DefaultTableModel recordTableModel;


	public UserPage(final String username) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("尊敬的 "+username+" 会员,欢迎您！");
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
		
		JButton btnNewButton_exit = new JButton("退出");

		btnNewButton_exit.setBackground(Color.WHITE);
		btnNewButton_exit.setBounds(14, 0, 63, 23);
		panel_exit.add(btnNewButton_exit);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(Color.WHITE);
		tabbedPane.setBounds(0, 0, 820, 570);
		panel.add(tabbedPane);
		
		JPanel panel_videoMessage = new JPanel();
		panel_videoMessage.setBackground(Color.WHITE);
		tabbedPane.addTab("可租借录像文件信息", null, panel_videoMessage, null);
		panel_videoMessage.setLayout(null);
		
		JScrollPane scrollPane_videoMessage = new JScrollPane();
		scrollPane_videoMessage.setBounds(0, 0, 820, 550);
		panel_videoMessage.add(scrollPane_videoMessage);


		table_videoMessage = new JTable();
		table_videoMessage.setRowHeight(35);
		table_videoMessage.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		table_videoMessage.setBackground(Color.WHITE);
		JTableHeader videoHead = table_videoMessage.getTableHeader();
		videoHead.setPreferredSize(new Dimension(videoHead.getWidth(), 35));
		videoHead.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        videoTableModel = new DefaultTableModel(GetDataUtil.getVacantFileData(),
                new String[] {
                        "录像名", "价格(元/天)", "文件号"
                }){
            @Override
            public boolean isCellEditable(int row, int column)
            {
                return false;
            }
        };
		table_videoMessage.setModel(videoTableModel);
		scrollPane_videoMessage.setViewportView(table_videoMessage);
		

		
		JPanel panel_record = new JPanel();
		panel_record.setBackground(Color.WHITE);
		tabbedPane.addTab("租赁信息", null, panel_record, null);
		panel_record.setLayout(null);
		
		JScrollPane scrollPane_record = new JScrollPane();
		scrollPane_record.setBounds(0, 0, 820, 550);
		panel_record.add(scrollPane_record);


        recordTableModel = new DefaultTableModel(GetDataUtil.getRecordData(username),
                new String[] {
                        "录像名", "文件号", "租借日期", "押金", "归还日期", "结算金额"
                }){
            @Override
            public boolean isCellEditable(int row, int column)
            {
                return false;
            }
        };
		table_record = new JTable();
		table_record.setRowHeight(35);
		table_record.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		table_record.setBackground(Color.WHITE);
		JTableHeader recordHead = table_record.getTableHeader();
		recordHead.setPreferredSize(new Dimension(recordHead.getWidth(), 35));
		recordHead.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		table_record.setModel(recordTableModel);
		scrollPane_record.setViewportView(table_record);

		JPanel panel_returnRecord = new JPanel();
        panel_returnRecord.setBackground(Color.WHITE);
        tabbedPane.addTab("未归还信息", null, panel_returnRecord, null);
        panel_returnRecord.setLayout(null);
		
		JScrollPane scrollPane_returnRecord = new JScrollPane();
		scrollPane_returnRecord.setBounds(0, 0, 820, 550);
		panel_returnRecord.add(scrollPane_returnRecord);

        table_returnRecord = new JTable();
        table_returnRecord.setRowHeight(35);
        table_returnRecord.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        table_returnRecord.setBackground(Color.WHITE);
		JTableHeader returnHead = table_returnRecord.getTableHeader();
		returnHead.setPreferredSize(new Dimension(returnHead.getWidth(), 35));
		returnHead.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        noReturnTableModel = new DefaultTableModel(GetDataUtil.getNoReturnData(username),
                new String[] {
                        "录像名", "文件号", "租借日期", "押金", "所需租金"
                }){
            @Override
            public boolean isCellEditable(int row, int column)
            {
                return false;
            }
        };
		table_returnRecord.setModel(noReturnTableModel);
		scrollPane_returnRecord.setViewportView(table_returnRecord);


		GuiUtil.setTableColumnCenter(table_videoMessage);
		GuiUtil.setTableColumnCenter(table_returnRecord);
		GuiUtil.setTableColumnCenter(table_record);


		btnNewButton_exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				IndexPage f1=new IndexPage();
				f1.frame.setVisible(true);

			}
		});
	}
}
