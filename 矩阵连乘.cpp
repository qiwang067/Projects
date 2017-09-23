#include<iostream>
using namespace std;
const int MAX = 100;
int n;
int p[MAX+1],m[MAX][MAX],s[MAX][MAX]; 


//p用来记录矩阵，m[i][j]表示第i个矩阵到第j个矩阵的最优解，s[][]记录从哪里断开可以得到最优解
void matrixChain()  
{
    for(int i=1; i<=n; i++)
        m[i][i]=0;
    for(int r=2; r<=n; r++)//对角线循环  (r指链的长度) 
    {
        for(int i=1; i<=n-r+1; i++) //行循环
        {
            int j=i+r-1;//列的控制
            m[i][j]=m[i+1][j]+p[i-1]*p[i]*p[j];//计算m[i][j]，矩阵的规模为 pi-1 * pi 
            s[i][j]=i;//在i位置断开 
            for(int k=i+1; k<j; k++)
            {
                int t=m[i][k]+m[k+1][j]+p[i-1]*p[k]*p[j];//在k位置断开,寻找最优解 
                if(t<m[i][j])
                {
                    s[i][j]=k; 
                    m[i][j]=t;
                } //if
            } //k
        } //i
    } //r 
}



void traceback(int i,int j) //输出最优计算次序 
{
    if(i==j)
        return;
    traceback(i,s[i][j]);
    traceback(s[i][j]+1,j);
    cout<<"Multiply A"<<i<<","<<s[i][j]<<"and A"<<s[i][j]+1<<","<<j<<endl;//s[i][j]是最优断开位置 
}


int main()
{
    cin>>n;//矩阵的数量 
    for(int i=0; i<=n; i++) //输入矩阵的行数和列数(矩阵相容) 
        cin>>p[i];
    matrixChain();
    cout<<endl; 
    traceback(1,n);	
    cout<<endl;
    cout<<"最少数乘次数为："<<m[1][n]<<endl;
    return 0;
}
