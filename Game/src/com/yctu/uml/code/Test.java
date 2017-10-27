package com.yctu.uml.code;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] sum = new int[5]; 
		CopyCat copycat = new CopyCat();
		TheHonest honest = new TheHonest();
		AllCheat allcheat = new AllCheat();
		AllCorporate allcorporate = new AllCorporate();
		Detective detective = new Detective();
		Person person[] = new Person[5];
		person[0] = copycat;
		person[1] = honest;
		person[2] = allcheat;
		person[3] = allcorporate;
		person[4] = detective;
		
		//初始化
		for(int i = 0;i<=4;i++)
			sum[i] = 0;
		
		for(int i=0;i<5;i++)
		{
			for(int j=0;j<5;j++)
			{
				if (j!=i) {
					System.out.println(person[i].getName()+" vs "+person[j].getName());
					System.out.println();
					for(int k=1;k<=5;k++)
					{
						System.out.println("Round "+k);
						compete(person[i],person[j]);
						System.out.println();
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
					System.out.println("-----------------------------------");
			}
			}
		}
		
		for (int i = 0; i < 5; i++) {
				System.out.println(sum[i]);
		}
		
		
//		for(int i=1;i<=5;i++)
//		{
//			System.out.println("Round: "+i);
//			compete(honest,allcorporate);
//			System.out.println();
//		}
		
		int max = 0;
		int index = -1;//名字的索引
		for (int i = 0; i < 4; i++) {
			if (sum[i] > max) {
				max = sum[i];
				index = i;
			}
		}
		System.out.println("---------------Result---------------- ");
		System.out.println("Winner is "+ person[index].getName()+","+" the coin is "+ max);

		
	}	
	
	public static void compete(Person p1,Person p2){
	
		int temp1,temp2;
		temp1 = p1.getLast();
		temp2 = p2.getLast();
		p1.play(p2,temp1,1);
		p2.play(p1,temp2,1);
		System.out.println("p1: "+p1.getCoin()+"  p2: "+p2.getCoin());	

		
	}

}
