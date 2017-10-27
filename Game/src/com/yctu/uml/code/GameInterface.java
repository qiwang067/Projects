package com.yctu.uml.code;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;


public class GameInterface  implements ActionListener {
	JFrame f = null; // 类属性

	public GameInterface() // 构造方法
	{
		f = new JFrame("Game System"); // 创建一个顶层容器
		f.setLocation(380, 220);
		Container contentPane = f.getContentPane(); // 获得其内容面板
		JPanel buttonPanel = new JPanel(); // 创建一中间容器JPanel
		JButton b = new JButton("One Tournament"); // 创建一原子组件——按钮
		b.addActionListener(this); // 为按钮添加事件监听器对象
		buttonPanel.add(b); // 将此按钮添加到中间容器
		b = new JButton("Survial Mode");
		b.addActionListener(this);
		buttonPanel.add(b);
		b = new JButton("CopyCat  VS  Allcheat");
		b.addActionListener(this);
		buttonPanel.add(b);
		b = new JButton("CopyCat  VS  Detective");
		b.addActionListener(this);
		buttonPanel.add(b);
		b = new JButton("Exit"); // 再创建一按钮
		b.addActionListener(this); // 为按钮增加事件监听器
		buttonPanel.add(b); // 将按钮添加到中间容器
		buttonPanel.setBorder(BorderFactory.createTitledBorder( // 设置中间容器边框
				BorderFactory.createLineBorder(Color.blue, 2), "who is the winner", TitledBorder.CENTER, TitledBorder.TOP));
		contentPane.add(buttonPanel, BorderLayout.CENTER); // 将中间容器添加到内容面板
		JMenuBar mBar = new JMenuBar(); // 创建菜单条
		
		
		f.setJMenuBar(mBar); // 为窗体增加菜单
		f.setSize(280, 200);
		f.setVisible(true);
		f.addWindowListener(new WindowAdapter() { // 为窗口操作添加监听器
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	public void actionPerformed(ActionEvent e) { // 实现ActionListener接口唯一的方法
		String cmd = e.getActionCommand(); // 从事件对象获得相关命令名称
		if (cmd.equals("Survial Mode")) { // 根据名称选择相应事件
			new TestForBest(f); // 显示添加信息对话框
		} else if (cmd.equals("Exit")) {
			System.exit(0);
		} 
		else if (cmd.equals("CopyCat  VS  Allcheat")) {
			new TestVsAllcheat(f); // 查询系统
		} else if (cmd.equals("One Tournament")) {
			new Test2(f); // 删除系统
		} else if (cmd.equals("CopyCat  VS  Detective")) {
			new TestVsDetective(f); // 修改系统
		} else if (cmd.equals("查看所有信息")) {
			new Test1(f); // 打印系统
		}
	}

	public static void main(String[] args) // 主方法，用于创建PersonManager类的一个对象
	{
		new GameInterface();
	}
}