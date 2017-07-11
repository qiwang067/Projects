
public class IpartA {
	public int n;
	public IpartA(int n)
	{
		this.n = n;
	}
	
	public void ClimbingStairs()
	{
		int []records = new int [this.n+1];
		int rcount = 0;
		records[rcount] = this.n;
		GoStairs(this.n,records,rcount+1);
		
	}
	
	public void GoStairs(int n,int []records,int rcount)
	{
		if(n==0)
		{
			System.out.println();
			for(int i=1;i<rcount;i++)
				System.out.print(records[i]+" ");
			
		}
		else
		{
			for(int i = n;i>=1;i--)
			{
				if(i<=records[rcount-1])
				{
					records[rcount] = i;
					GoStairs(n-i,records,rcount+1);
					
				}
				
			}
			
		}
		
		
	}

}
