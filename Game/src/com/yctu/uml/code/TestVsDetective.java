package com.yctu.uml.code;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class TestVsDetective implements ActionListener {
	JDialog dialog;

	TestVsDetective(JFrame f) { // 构造方法，从其调用方法中获得对话框的父窗口
		dialog = new JDialog(f, "Final~~~", true); // 产生一modal对话框
		Container dialogPane = dialog.getContentPane(); // 接下来注意添加各个组件
		dialogPane.setLayout(new GridLayout(1, 1));
		JButton b1 = new JButton("OK");
		dialogPane.add(b1);
		JButton b2 = new JButton("Cancel");
		dialogPane.add(b2);
		b1.addActionListener(this); // 为两按钮增加事件监听器
		b2.addActionListener(this);
		dialog.setBounds(700, 280, 180, 66);
		dialog.setVisible(true);
		;
	}

	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if (cmd.equals("OK")) {
			try {
				
				int[] sum = new int[25];
				int[] sum1 = new int[25];
				CopyCat copycat = new CopyCat();
				TheHonest honest = new TheHonest();
				AllCheat allcheat = new AllCheat();
				AllCorporate allcorporate = new AllCorporate();
				Detective detective = new Detective();
				Person person[] = new Person[25];
				
				//对抗诸葛的案例
				for (int i = 0; i < 1; i++)
					person[i] = copycat;
				
				  for (int i = 1; i < 25; i++) {
					person[i] = detective;
						}
				  System.out.println("Round "+0);
					System.out.println();
					System.out.println("Copycat:"+1+" detective:"+24);
					System.out.println("---------------------------");
				
					try{
					    Thread thread = Thread.currentThread();
					    thread.sleep(1500);     //暂停1.5秒后程序继续执行
					}catch (InterruptedException e1) {
					        // TODO Auto-generated catch block
					    e1.printStackTrace();
					}

				for (int m = 1; m <= 100; m++) {
					// 初始化
					for (int i = 0; i < 25; i++)
						sum[i] = 0;

					for (int i = 0; i < 25; i++) {
						for (int j = 0; j < 25; j++) {
							if (j != i) {
//								System.out.println(person[i].getName() + " vs " + person[j].getName());
//								System.out.println();
								for (int k = 1; k <= 5; k++) {
//									System.out.println("Round " + k);
									compete(person[i], person[j]);
//									System.out.println();
								}
								sum[i] = person[i].getCoin() + sum[i];
								sum[j] = person[j].getCoin() + sum[j];
								person[i].setCoin(10);
								person[j].setCoin(10);
								person[i].setLast(-1);
								person[j].setLast(-1);
								person[i].setCount(0);
								person[j].setCount(0);
								person[i].setStat(1);
								person[j].setStat(1);
								person[i].setMark(0);
								person[j].setMark(0);
//								System.out.println("-----------------------------------");
							}
						}
					}

					for (int i = 0; i < sum.length; i++) {
						sum1[i] = sum[i];
					}

					Arrays.sort(sum1);

					int min = search(sum, sum1[0], 0);
					int min2 = search(sum, sum1[1], 0);
					if (min2 == min) {
						min2 = search(sum, sum1[1],min+1);
					}
					int max = search(sum, sum1[24], 0);

					person[min] = person[max];
					person[min2] = person[max];
					int count1 = 0;
					int count2 = 0;
					int count3 = 0;
					int count4 = 0;
					int count5 = 0;

					
					for (int i = 0; i < person.length; i++) {
						if (person[i].getName() == "Copycat") {
							count1++;
						}
						else if(person[i].getName() == "detective"){
							count2++;
						}
						else if (person[i].getName() == "The honest") {
							count3++;
						}
						else if (person[i].getName() == "all cheat") {
							count4++;
						}
						else {
							count5++;
						}
						
					}// for
					
					System.out.println("Round "+m);
					System.out.println();
					System.out.println("Copycat:"+count1+" detective:"+count2);
					System.out.println("---------------------------");
					count1 = 0;
					count2 = 0;
					count3 = 0;
					count4 = 0;
					count5 = 0;
					
					try{
					    Thread thread = Thread.currentThread();
					    thread.sleep(1500);     //暂停1.5秒后程序继续执行
					}catch (InterruptedException e1) {
					        // TODO Auto-generated catch block
					    e1.printStackTrace();
					}
					
				} // 大循环
//				for (int i = 0; i < person.length; i++) {
//					System.out.println(person[i].getName());
//				}
		
				
				dialog.dispose();
			} catch (Exception ex) {
			}
		} else if (cmd.equals("Cancel")) {
			dialog.dispose(); // 直接返回主窗口
		}
	}

	
	public static void compete(Person p1, Person p2) {

		int temp1, temp2,msg;
		temp1 = p1.getLast();
		temp2 = p2.getLast();
		p1.play(p2, temp1,0);
		p2.play(p1, temp2,0);
//		System.out.println("p1: " + p1.getCoin() + "  p2: " + p2.getCoin());
	}

public static int search(int[] sum, int target, int start) {
	for (int i = start; i < sum.length; i++) {
		if (sum[i] == target) {
			return i;
		}
	}
	return -1;
}

}
