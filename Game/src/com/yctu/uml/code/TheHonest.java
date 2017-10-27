package com.yctu.uml.code;

public class TheHonest implements Person {
	public int coin = 10;
	public int count = 0;
	public int last = -1;
	public int stat = 1;
	public int mark = 0;
	public String name ="The honest"; 
	
	public void setMark(int mark) {
		this.mark = mark;
	}
	public void setCount(int count) {
		this.count = count;
		}
	
	public void setStat(int stat) {
		this.stat = stat;
	}
	public String getName() {
		return name;
	}
	
	public int getCoin() {
		return coin;
	}
	public void setCoin(int coin) {
		this.coin = coin;
	}
	public int getLast() {
		return last;
	}
	public void setLast(int last) {
		this.last = last;
	}
	
	public int getCount() {
		return count;
	}
	
	public void update(Person p){
		this.coin--;
		p.setCoin(p.getCoin()+3);		
	}

	public TheHonest(){
		this.last = last;
		this.coin = coin;
	}
	
	
	public int play(Person p,int temp,int msg) {
		
		if(count == 0){
			p.setLast(1);
			this.count++;
			if(msg == 1)
			System.out.println("The honest throw a coin");
			update(p);
			return 1;
		}
		
		if (temp == -1) {
			p.setLast(1);
			this.count++;
			if(msg == 1)
			System.out.println("The honest throw a coin");
			update(p);	
			return 1;
		}
		
		
		if (temp == 0 && stat == 1) {
			p.setLast(0);
			this.count++;
			this.stat = 0;
			if(msg == 1)
			System.out.println("The honest don't throw a coin");
			return 0;
		}		
		
		
		
		if (this.stat == 1) {
			p.setLast(1);
			this.count++;
			if(msg == 1)
			System.out.println("The honest throw a coin");
			update(p);
			return 1;	
		}
		
		if (this.stat == 0) 
		{
			p.setLast(0);
			this.count++;
			this.stat=0;
			if(msg == 1)
			System.out.println("The honest don't throw a coin");
			return 0;
		}
			
		return 0;
	
	}
	
}
