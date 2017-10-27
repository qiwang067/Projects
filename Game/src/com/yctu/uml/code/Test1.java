package com.yctu.uml.code;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Test1 implements ActionListener {

	JDialog dialog;

	Test1(JFrame f) { // 构造方法，从其调用方法中获得对话框的父窗口
		dialog = new JDialog(f, "查询所有", true); // 产生一modal对话框
		Container dialogPane = dialog.getContentPane(); // 接下来注意添加各个组件
		dialogPane.setLayout(new GridLayout(1, 2));
		JButton b1 = new JButton("确定");
		dialogPane.add(b1);
		JButton b2 = new JButton("取消");
		dialogPane.add(b2);
		b1.addActionListener(this); // 为两按钮增加事件监听器
		b2.addActionListener(this);
		dialog.setBounds(200, 150, 100, 90);
		dialog.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if (cmd.equals("确定")) {
			try {
				
				
				dialog.dispose();
			} catch (Exception ex) {

			}
		} else if (cmd.equals("取消")) {
			dialog.dispose(); // 直接返回主窗口
		}
	}
}

