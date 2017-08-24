#include<stdio.h>

int a[101],n;//全局变量，子函数中要使用

void quicksort(int left,int right)//快速排序 
{
	int i,j,t,temp;//temp是基准数 
	if(left>right)
		return;
	temp=a[left];
	i=left;
	j=right;
	while(i!=j)
	{
		while(a[j]>=temp&&i<j)//先从右向左找 
		{
			j--;
		}
		while(a[i]<=temp&&i<j)//从左向右找 
		{
			i++;
		}
		if(i<j)//哨兵i,j没有相遇，交换数组位置 
		{
			t=a[i];
			a[i]=a[j];
			a[j]=t;
			
		}
	}
	//基准数归位 
	a[left]=a[i];
	a[i]=temp;
	quicksort(left,i-1);//处理左边 
	quicksort(i+1,right);//处理右边 
	return;	
}


int main()
{
	int i,j,n;
	printf("请输入数组元素 :"); 
	for(i=0;i<5;i++)
	scanf("%d",&a[i]);
	quicksort(0,4);//快速排序调用 
	printf("排序后："); 
	for(i=0;i<5;i++)
	{
		printf("%3d",a[i]);
	}
	getchar();
	return 0;
}


