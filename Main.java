import java.util.*;
public class Main{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt(); 
		int a=5+n*4;
		char[][] arr=new char[a][a];
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr[i].length;j++){
				arr[i][j]='.';
			}
		}
		//首先将中心十字坐标计算出来,并存储$字符
		int x=a/2;
		int y=a/2;
		for(int i=x-2;i<=x+2;i++){
			arr[i][y]='$';
			arr[x][i]='$';
		}
		//从内到外计算每一层并存储在字符数组中
		for(int i=1;i<=n;i++){
			//先存储四条边
			int len=i*4+1; //每条边存储的个数
			int tx=(5+n*4-len)/2;  //起点
			for(int j=tx;j<len+tx;j++){
				arr[x-2-i*2][j]='$';
				arr[x+2+i*2][j]='$';
				arr[j][x-2-i*2]='$';
				arr[j][x+2+i*2]='$';
			}
			//存储四个内角
			int jj=0;
			for(int j=2+i*2-1;j>2*i-1;j--){
				arr[x-j][tx]='$';
				arr[x-j][arr[0].length-1-tx]='$';
				arr[x+j][tx]='$';
				arr[x+j][arr[0].length-1-tx]='$';
				jj=j;
			}
			tx--;
			arr[x-jj][tx]='$';
			arr[x-jj][arr[0].length-1-tx]='$';
			arr[x+jj][tx]='$';
			arr[x+jj][arr[0].length-1-tx]='$';
			prin(arr);
		}
		System.out.println("结束");
		prin(arr);
		
	}
	public static void prin(char[][] ch){
		for(int i=0;i<ch.length;i++){
			for(int j=0;j<ch[i].length;j++){
				System.out.print(ch[i][j]);
			}
			System.out.println();
		}
	}
}
