package com.yctu.uml.code;

public class Detective implements Person  {
	public int coin = 10;
	/**
	 * 
	 */
	public int count = 0;
	
	public int mark = 0;
	



	public int last = -1;
    public int stat = 1;
    public void setStat(int stat) {
		this.stat = stat;
	}
    
    public void setMark(int mark) {
		this.mark = mark;
	}

	public String name ="detective"; 
	
    public void setCount(int count) {
    	this.count = count;
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

	public int play(Person p,int temp,int msg) {
		if(count == 0){
			p.setLast(1);
			this.count++;
			if(msg == 1)
			System.out.println("detective throw a coin");
			update(p);
			return 1;
		}
		
		//发现老油条
		if (count == 1 && temp == 0) {
			p.setLast(0);
			this.count++;
			this.stat = 0;
			if(msg == 1)
			System.out.println("detective don't throw a coin");
			return 1;
		}
		
		//可能是复制者，老铁或雷锋或诸葛，第二次不投
		if (count == 1 && temp == 1) {
			p.setLast(0);
			this.count++;
			if(msg == 1)
			System.out.println("detective don't throw a coin");
			return 1;			
		}
		
		
		//发现诸葛
		if (count == 2 && temp == 0 && this.stat == 1) {
			p.setLast(1);
			this.count++;
			this.stat = 2;
			if(msg == 1)
			System.out.println("detective throw a coin");
			update(p);
			return 1;
		}
		
		if (stat == 2) {
			p.setLast(1);
			this.count++;
			if(msg == 1)
			System.out.println("detective throw a coin");
			update(p);
			return 1;
		}
	
		
		//第三次投来区分复制者或老铁
				if (count == 2 && this.stat == 1) {
					p.setLast(1);
					this.count++;
					if(msg == 1)
					System.out.println("detective throw a coin");
					update(p);
					return 1;
				}
		
		
			//发现雷锋
			if (count == 3 && temp == 1) {
				p.setLast(0);
				this.count++;
				this.stat = 0;
				this.mark = 1;
				if(msg == 1)
				System.out.println("detective don't throw a coin");
				return 1;
			}
			//不投并且不修改状态
			if (count == 3 && temp == 0) {
				p.setLast(0);
				this.count++;
				if(msg == 1)
				System.out.println("detective don't throw a coin");
				return 1;
			}
		
			//发现复制者
			if (count == 4 && temp == 1 && this.mark == 0) {
				p.setLast(1);
				this.count++;
				this.stat = 1;
				if(msg == 1)
				System.out.println("detective throw a coin");
				update(p);	
				return 1;
			}
			
			//发现老铁
			if (count == 4 && temp == 0) {
				p.setLast(0);
				this.count++;
				this.stat = 0;
				if(msg == 1)
				System.out.println("detective don't throw a coin");
				return 1;
			}
			//状态切换
			
			if (this.stat == 0) {
				p.setLast(0);
				this.count++;
				if(msg == 1)
				System.out.println("detective don't throw a coin");
				return 1;
			}
			else {
				p.setLast(1);
				this.count++;
				if(msg == 1)
				System.out.println("detective throw a coin");
				update(p);	
				return 1;
			}
			
	
	
	}
	
	
	

}
