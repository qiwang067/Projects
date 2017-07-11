
public class IpartB {
	public int n;//楼梯的总数目
	public  IpartB(int n)
	{
		this.n = n;
	}
	
	public void ClimbStairs()
	{
		int [] records = new int[this.n];
		int rcount = 0;
		GoStairs(this.n,records,rcount);
	}
	
	public void GoStairs(int n, int []records,int rcount)
	{
		if(n==0)
		{
			System.out.println();
			for(int i=0;i<rcount;i++)
			System.out.print(records[i]+" ");
			
		}
		else
		{
			for(int i = 1;i<=n;i++)
			{
				records[rcount] = i;
				GoStairs(n-i,records,rcount+1);
				
			}
			
		}
		
		
	}
	
	
	

}
