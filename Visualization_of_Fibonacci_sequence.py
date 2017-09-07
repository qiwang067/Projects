import time
import matplotlib.pyplot as plt 


def rabbit(n):  #非递归算法
	if n==1 or n==2:
		return 1
	else:
		a = [None]*(n+1)  #生成空列表
		a[0] = 0
		a[1] = 1
		for i in range(2,n+1):
			a[i] = a[i-1]+a[i-2]
		sum = a[n]
		return sum



#print("请输入年份:")
# t = input() #默认输入是字符串
# n = int(t)
# print()
# y = [None]*(n+1)
# x = [None]*(n+1)
y = [None]*6
y[0] = 0
k = 1

for j in [1,250,500,750,1000]:
	start = time.clock() #计算时间
	sum = rabbit(j)
	print("第",j,"年的兔子数:",sum) 
	end = time.clock()
	print('Running time: %s ms'%((end-start)*1000))
	print()
	y[k] = (end-start)*1000
	k = k+1
x = [0,1,250,500,750,1000]

#绘制图表
plt.xlabel("year")
plt.ylabel("ms")
plt.title("Visualization of Fibonacci sequence")
plt.plot(x,y)  
plt.show() 