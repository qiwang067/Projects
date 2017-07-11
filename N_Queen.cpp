#include<iostream>
#include<cstring>
#include<cmath>
using namespace std;

//函数定义 
void Try(int);
int Check(int a[],int n);

int a[100],n,i,count=0;//全局变量,数组a的大小根据皇后的数量而定 


int main() {
	cout<<"please input a number: ";
	memset(a,0,sizeof(a));
	cin>>n;
	Try(1);
	return 0;
}

int Check(int a[],int n) {    //剪枝函数，检测位置是否冲突
	for(int i=1; i<n; i++) {
		if(a[i]==a[n]||abs(i-n)==abs(a[i]-a[n]))
			return 0;
	}
	return 1;
}



//递归实现深度优先搜索,i是行数，a[i]是列数 
void Try(int i) {
	for(int j=1; j<=n; j++) {
		a[i]=j;
		if(Check(a,i)) {
			if(i<n) {
				Try(i+1);
			} else {
				count++;
				int b[n+1][n+1];					
				memset(b,0,sizeof(b));
				cout<<endl<<"answer"<<" "<<count<<":"<<endl;
				for(int i=1; i<=n; i++) {
					b[i][a[i]]=1;
				}
				//打印八皇后 
				for(int i=1; i<n+1; i++)
				{
					for(int j=1; j<n+1; j++)
					{
						cout<<b[i][j]<<" ";
					}
					cout<<endl;
				}
					

			}
		}

	}
}





