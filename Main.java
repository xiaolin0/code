import java.util.*;
public class Main{
	static int MAX=100000;   // .:路径    #:墙壁    S:起点   G:终点
	static int n,m;
	static int sx,sy;
	static int ex,ey;
	public static void main(String[] args){
		Scanner scan=new Scanner(System.in);
		n=scan.nextInt();
		m=scan.nextInt();
		char[][] ch=new char[n][m];
		for(int i=0;i<n;i++){
			String str=scan.next();
			for(int j=0;j<m;j++){
				ch[i][j]=str.charAt(j);
				//寻找起点与终点
				if(ch[i][j]=='S'){
					sx=i;sy=j;
				}else if(ch[i][j]=='G'){
					ex=i;ey=j;
				}
			}
		}
		
		System.out.println(bfs(ch));
	}
	public static int bfs(char[][] ch){
		Queue<int[]> que=new LinkedList();
		int[][] help=new int[n][m];  //构建辅助数组，存储可以到达的点的步数
		//存储四个方向
		int[][] xx=new int[][]{{-1,0},
				               {0,1},
				               {1,0},
				               {0,-1}
		};
		for(int i=0;i<n;i++)
			for(int j=0;j<m;j++)help[i][j]=MAX;
		que.offer(new int[]{sx,sy});  //压入起点
		help[sx][sy]=0;
		while(que.size()!=0){
			int[] poll=que.poll();
			if(poll[0]==ex && poll[1]==ey)break;
			for(int i=0;i<4;i++){
				int x=poll[0]+xx[i][0];
				int y=poll[1]+xx[i][1];
				if(x>=0 && x<n &&y>=0 && y<m && help[x][y]==MAX && ch[x][y]!='#'){
					que.offer(new int[]{x,y});
					help[x][y]=help[poll[0]][poll[1]]+1;
				}
			}
//			prin(help);//查看每次行走的路径
		}
		return help[ex][ey];
	}
	public static void prin(int[][] str){//用于查看路径
		for(int i=0;i<str.length;i++){
			for(int j=0;j<str[i].length;j++){
				System.out.printf("%2d ",str[i][j]);
			}
			System.out.println();
		}
		System.out.println("圣诞快乐发射点立刻反击了");
	}
}