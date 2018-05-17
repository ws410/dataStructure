package ch04;

import java.util.Scanner;

public class SY4_4 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("请输入k值");
		int k =sc.nextInt();
		System.out.println("请输入n值");
		int n =sc.nextInt();
		GetFib_CyQueue(k,n);
	}
	private static void GetFib_CyQueue(int k,int n){
		int i,m,sum;
		CircleSqQueue Q = new CircleSqQueue(k);
		for(i = 0;i<k-1;i++)
			Q.offer(0);
		Q.offer(1);
		System.out.println("k阶斐波那契序列的前n+1项值为：");
		for(i = 0; i<k;i++)
			System.out.print(Q.getElem(i) + " ");
		for(i = k; i<=n;i++)
		{
			m = i%k;
			sum = 0;
			for(int j = 0;j<k;j++)
				sum = sum + Q.getElem((m + j)%k);
			Q.offer(sum);
			System.out.print(sum + " ");
		}
	}

}
