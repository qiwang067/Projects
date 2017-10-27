package com.yctu.uml.code;

import java.util.Arrays;

public class TestSandbox {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] sum = new int[25];
		int[] sum1 = new int[25];
		CopyCat copycat = new CopyCat();
		TheHonest honest = new TheHonest();
		AllCheat allcheat = new AllCheat();
		AllCorporate allcorporate = new AllCorporate();
		Detective detective = new Detective();
		Person person[] = new Person[25];
	
		
		/*//对抗诸葛的案例
		for (int i = 0; i < 1; i++)
			person[i] = copycat;
		
		  for (int i = 1; i < 25; i++) {
			person[i] = detective;
				}*/
		

		
		for (int i = 0; i < 3; i++)
			person[i] = copycat;
		
		  for (int i = 3; i < 25; i++) {
			person[i] = allcheat;
				}
		
		
		/*//对抗老铁的案例
		for (int i = 0; i < 15; i++)
			person[i] = copycat;
		
		  for (int i = 15; i < 25; i++) {
			person[i] = honest;
				}*/
		
		
		//平均分配的案例
		/*for(int i = 0;i < 5;i++)
			person[i] = copycat;
		for (int i = 5; i < 10; i++)
			person[i] = honest;
		
		for (int i = 10; i < 15; i++)
			person[i] = detective;
		
		for (int i = 15; i < 20; i++) {
			person[i] = allcheat;
		}
		for(int i = 20;i < 25;i++){
			person[i] = allcorporate;
		}
		*/
		

		for (int m = 1; m <= 100; m++) {
			// 初始化
			for (int i = 0; i < 25; i++)
				sum[i] = 0;

			for (int i = 0; i < 25; i++) {
				for (int j = 0; j < 25; j++) {
					if (j != i) {
//						System.out.println(person[i].getName() + " vs " + person[j].getName());
//						System.out.println();
						for (int k = 1; k <= 5; k++) {
//							System.out.println("Round " + k);
							compete(person[i], person[j]);
//							System.out.println();
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
//						System.out.println("-----------------------------------");
					}
				}
			}

			for (int i = 0; i < sum.length; i++) {
				sum1[i] = sum[i];
			}

			Arrays.sort(sum1);
//			System.out.println("sort...");
//			for (int i = 0; i < sum1.length; i++) {
//				System.out.println(sum1[i]);
//			}
//			System.out.println("sort end...");
			
//			System.out.println("sum...");
//			for (int i = 0; i < sum.length; i++) {
//				System.out.println(sum[i]);
//			}
//			System.out.println("sum end...");

			int min = search(sum, sum1[0], 0);
			int min2 = search(sum, sum1[1], 0);
			if (min2 == min) {
				min2 = search(sum, sum1[1],min+1);
			}
			int max = search(sum, sum1[24], 0);
//			System.out.println("max:" + max);
//			System.out.println("min:" + min);
//			System.out.println("min2:" + min2);
			person[min] = person[max];
			person[min2] = person[max];
			int count1 = 0;
			int count2 = 0;
			int count3 = 0;
			int count4 = 0;
			int count5 = 0;
//			for (int i = 0; i < person.length; i++) {
//				System.out.println(person[i].getName());
//			}
			
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
			System.out.println("Copycat:"+count1+" detective:"+count2+" honest:"+count3
					+"\n"+"\n"+"allcheat:"+count4+" allcorporate:"+count5);
			System.out.println("---------------------------");
			count1 = 0;
			count2 = 0;
			count3 = 0;
			count4 = 0;
			count5 = 0;
			
			try{
			    Thread thread = Thread.currentThread();
			    thread.sleep(1500);     //暂停1.5秒后程序继续执行
			}catch (InterruptedException e) {
			        // TODO Auto-generated catch block
			    e.printStackTrace();
			}
			
		} // 大循环
//		for (int i = 0; i < person.length; i++) {
//			System.out.println(person[i].getName());
//		}

	}

	public static int search(int[] sum, int target, int start) {
		for (int i = start; i < sum.length; i++) {
			if (sum[i] == target) {
				return i;
			}
		}
		return -1;
	}

	public static void compete(Person p1, Person p2) {

		int temp1, temp2,msg;
		temp1 = p1.getLast();
		temp2 = p2.getLast();
		p1.play(p2, temp1,0);
		p2.play(p1, temp2,0);
//		System.out.println("p1: " + p1.getCoin() + "  p2: " + p2.getCoin());
	}

}