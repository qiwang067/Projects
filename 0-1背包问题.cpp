#include<stdio.h>

#define N 6   //背包的数目为5
#define W 21   //背包的容量为20 

int B[N][W]={0};//N代表可供选择物品的数目，W代表背包剩余的空间 
int w[6]={0,2,3,4,5,9};//每件物品的大小 
int v[6]={0,3,4,5,8,10};//每件物品的价值 

//挑选物品 
void select(){
	int k,c;//c代表capacity即容量 
	//利用二重for循环创建递推表 
	for(k=1;k<N;k++){
		for(c=1;c<W;c++){
			if(w[k]>c){
				B[k][c]=B[k-1][c];
			}
			else{
				int value1 = B[k-1][c-w[k]]+v[k];
				int value2 = B[k-1][c];
				if(value1>value2){
					B[k][c]=value1;
				}
				else{
					B[k][c]=value2;
				}
			}
		}
	}
	
}

int main(){
	select();
	printf("%d\n",B[5][20]);
	int remainspace = W-1;
	int count = 0;
	//输出所选择的物品列表：
    for(int i=N-1; i>=1; i--)
    {
        if (remainspace >= w[i])
        {
             if ((B[i][remainspace]-B[i-1][remainspace-w[i]]==v[i]))
             {
                 printf("item %d is selected\n",i);
                 remainspace = remainspace - w[i];//如果第i个物品被选择，那么背包剩余容量将减去第i个物品的重量 ;
             }
        }
    }
	return 0;
}

 
