package ch02;

public class Test_reverse {
	public static void main(String[] args) throws Exception {
		int[]arr=new int[]{1,2,3,4,5,6,7};
		rightMove(arr, 7, 3);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
	public static void reverse(int[]r,int low,int hight){
		for(int i=low,j=hight;i<j;i++,j--){
			int temp=r[i];
			r[i]=r[j];
			r[j]=temp;
		}
	}
	public static void rightMove(int[]r,int n,int p){
		reverse(r, 0, n-1);
		reverse(r, 0, p-1);
		reverse(r, p, n-1);
	}
}
