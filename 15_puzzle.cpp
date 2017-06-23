#include<stdio.h>
#include<string.h>
#include<math.h>
#include<time.h>
#include<stdlib.h>
#define size 4

int move[4][2]= {{-1,0},{0,-1},{0,1},{1,0}}; 
char op[4]= {'U','L','R','D'};
int map[size][size],map1[size][size],map2[size*size],limit,path[100];
int flag,length;//length为最终的路径长度
int goal[16][2]= {{3,3},{0,0},{0,1}, {0,2},{0,3}, {1,0},
	{1,1}, {1,2}, {1,3},{2,0}, {2,1}, {2,2},{2,3},{3,0},{3,1},{3,2}
};



int solvability(int a[size*size]) { //查看逆序数,从而判断可解性 ,排列的奇偶性应该保持不变
	int i,j,ni,w,x,y;  
	ni=0; //ni是逆序的总数
	for(i=0; i<size*size; i++) { 
		if(a[i]==0)  
			w=i;

		for(j=i+1; j<size*size; j++) {
			if(a[i]>a[j])
				ni++;
		}
	}
	x=w/size; //0所在的横坐标
	y=w%size;  //0所在的竖坐标
	ni+=abs(x-3)+abs(y-3);  //最后加上0的偏移量 ，0的坐标应为（3,3）
	if(ni%2==1)//s=perm+dist为奇数可解
		return 1;
	else
		return 0;
}


void rand_generate() { //随机生成十五谜 
	int i=0;
	int m;
	memset(map2,-1,sizeof(map2));
	m=rand()%16;
	while(i<16) {
		for(int j=0; j<16; j++) {
			if(m==map2[j]) {
				m=rand()%16;
				j=0;
			}
		}
		map2[i++]=m;
		m=rand()%16;
	}

}

void default_generate() {
	int map3[16]= {1,2,3,4,5,10,6,8,0,9,7,12,13,14,11,15};
	for(int i=0; i<16; i++) {
		map2[i]=map3[i];
	}
}




int manhattan_dis(int a[][size]) { //估价函数(曼哈顿距离) 
	int i,j,cost=0;
	for(i=0; i<size; i++) {
		for(j=0; j<size; j++) {
			int w=map[i][j];
			cost+=abs(i-goal[w][0])+abs(j-goal[w][1]); //(i,j)与目标位置进行比较
		}
	}
	return cost;  //所有位置的曼哈顿距离
}



void swap(int*a,int*b) { //交互两数
	int tmp;
	tmp=*a;
	*a=*b;
	*b=tmp;
}


int check() { //检查输入是否合法
	for(int i=0; i<16; i++) {
		for(int j=0; j<16; j++) {
			if(map2[i]==map2[j]&&i!=j)
				return 0;
		}

	}

	return 1;

}


void print() { //打印元素
	int count=0;
	for(int i=0 ; i<16; i++) {

		printf("%2d ",map2[i]);
		count++;
		if(count%4==0)
			printf("\n");

	}
}

void print_map() {
	int count=0;
	for(int i=0; i<4; i++) {
		for(int j=0; j<4; j++) {
			count++;
			printf("%2d ",map[i][j]);
			if(count%4==0)
				printf("\n");
		}
	}


}

void print_element() {
	int count=0;
	for(int i=0; i<4; i++) {
		for(int j=0; j<4; j++) {
			count++;
			printf("%2d ",map1[i][j]);
			if(count%4==0)
				printf("\n");
		}
	}


}

void print_map1(int ox,int oy) {
	int fx,fy;
	for(int i=0; i<length; i++) {
		switch(path[i]) {
			case 0:
				fx=ox+move[0][0];
				fy=oy+move[0][1];
				swap(&map1[ox][oy],&map1[fx][fy]);
				ox=fx;
				oy=fy;
				print_element();
				printf("\n");
				break;
			case 1:
				fx=ox+move[1][0];
				fy=oy+move[1][1];
				swap(&map1[ox][oy],&map1[fx][fy]);
				print_element();
				ox=fx;
				oy=fy;
				printf("\n");
				break;
			case 2:
				fx=ox+move[2][0];
				fy=oy+move[2][1];
				swap(&map1[ox][oy],&map1[fx][fy]);
				print_element();
				ox=fx;
				oy=fy;
				printf("\n");
				break;
			case 3:
				fx=ox+move[3][0];
				fy=oy+move[3][1];
				swap(&map1[ox][oy],&map1[fx][fy]);
				print_element();
				ox=fx;
				oy=fy;
				printf("\n");
				break;
			default:
				printf("\n\t\t---错误输入---\n");
		}


	}




}



void dfs(int ox,int oy,int len,int pre_move)
//ox,oy是空格的位置 len初始时为0 ，len表示解法路径的长度 pre_move传的i值代表之前的移动
{
	int i,fx,fy;
	if(flag)
		return;
	int dv=manhattan_dis(map); //移动空格后map的代价

	if(len==limit) {
		if(dv==0) { //dv==0说明所有数字已经到了目标的位置
			flag=1;
			length=len;
			return;
		} else
			return;  //超过预估长度，回退，没有进一步搜索的价值
	}

	else if(len<limit) {
		if(dv==0) { //小于预估长度 ，成功 
			flag=1;
			length=len;
			return;
		}
	}

	for(i=0; i<4; i++) {
		if(i+pre_move==3&&len>0)//不和上一次移动方向相反( i+pre_move==3 )，len>0以确保已经移动过了
			continue;
		fx=ox+move[i][0];  //0 上左右下移动
		fy=oy+move[i][1];


		if(0<=fx&&fx<size && 0<=fy&&fy<size) { //判断移动合理
			swap(&map[ox][oy],&map[fx][fy]);  //移动0的位置
			int p=manhattan_dis(map);   //移动后的曼哈顿距离

			if(p+len<=limit&&!flag) { //剪枝判断语句
				path[len]=i;//i可取0,1,2,3
				dfs(fx,fy,len+1,i);  //如当前步成功则 递归调用dfs直到搜索出这个子树的所有解
				if(flag)
					return;
			}

			swap(&map[ox][oy],&map[fx][fy]);  //不合理(代价过大)则回退一步
		}
	}
}



int main() {

	int i,j,k,l,m,n,ox,oy;
	i=0;
	int choice;
	while(true) {
		printf("\n1、生成默认十五谜 \n\n2、输入十五谜\n");
		printf("\n3、随机生成十五谜\n\n");
		printf("请选择操作代码: ");
		scanf("%d",&choice);
		printf("\n");
		if(choice==1) {
			default_generate();
			print();
		}


		else if(choice==2) {
			for(int i=0; i<16; i++)
				scanf("%d",&map2[i]);
			if(check()==0) {
				printf("输入中有重复的数字");
				return 0;
			}


		} else if(choice==3) {

			while(check()!=1) {
				rand_generate();
			}
			print();
		} else {
			printf("错误输入");
			return 0;

		}



		flag=0,length=0; //flag用于判断是否到达目标状态 ，length赋值为0
		memset(path,-1,sizeof(path));  //已定义path[100]数组，将path填满-1
		for(i=0; i<16; i++) {
			if(map2[i]==0) {
				map[i/size][i%size]=0; 
				ox=i/size;
				oy=i%size;  //ox和oy记录0的位置
			} else {
				map[i/size][i%size]=map2[i];  
			}

		}
		for(int i=0; i<4; i++) {
			for(int j=0; j<4; j++) {
				map1[i][j]=map[i][j];
			}
		}


		if(solvability(map2)==1) {      //该状态可达 ，该问题可解
			limit=manhattan_dis(map);  //全部的曼哈顿距离之和

			while(!flag&&length<=50) { //要求50步之内到达,路径长度要小于50
				dfs(ox,oy,0,0);
				if(!flag)
					limit++; //达到limit还找不到，只能将limit放宽以求解
			}


			if(flag) {

				printf("\n");
				print_map1(ox,oy);
				printf("\n");
				printf("空格所要走的路径为:");
				for(int i=0; i<length; i++)
					printf("%c ",op[path[i]]);  
				printf("\n\n");



			}
		}

		else if(!solvability(map2)||!flag)
			printf("This puzzle is not solvable.\n");
		getchar();
		printf("\n还继续吗?(Y/N)");
		char reply = getchar();
		if(reply!='Y'&& reply != 'y')
			break;
		system("cls");
	}

	return 0;
}
