package luogu;

import java.util.*;
public class Main{
	static int n,x_max=0,y_max=0;
	public static void main(String[] args){
		Scanner scan=new Scanner(System.in);
		n=scan.nextInt();
		int[][] arr=new int[n][4];
		int[] goal=new int[2];
		for(int i=0;i<n;i++){
			arr[i][0]=scan.nextInt();
			arr[i][1]=scan.nextInt();
			arr[i][2]=scan.nextInt();
			arr[i][3]=scan.nextInt();
		}
		goal[0]=scan.nextInt();
		goal[1]=scan.nextInt();
		int last=-1;
		for(int i=0;i<n;i++){
			if(fun(arr[i],goal)){
				last=i+1;
			}
		}
		System.out.println(last);
	}
	public static boolean fun(int[] arr,int[] goal){
		for(int i=arr[1];i<arr[1]+arr[3];i++){
			for(int j=arr[0];j<arr[0]+arr[2];j++){
				if(i==goal[0]&&j==goal[1])return true;
			}
		}
		return false;
	}
}