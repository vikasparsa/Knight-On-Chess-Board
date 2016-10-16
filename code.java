class point{
    int x;
    int y;
    public point(int x,int y){
        this.x=x;
        this.y=y;
    }
}
public class Solution {
    public static boolean isValidMove(int x, int y, int n,int m) {
		return x>=0&&y>=0&&x<n&&y<m;
	}
	/*public void backtracking(int x1,int y1,int[][] solution,int[] x,int[] y,boolean[][] visited){
	    if(x1<0||y1<0||x1>=solution.length||y1>=solution[0].length){
	        return;
	    }
	    for(int i=0;i<8;i++){
	        int nextx=x1+x[i];
	        int nexty=y1+y[i];
	        if(isValidMove(nextx,nexty,solution)==true){
	            if(visited[nextx][nexty]==false||solution[nextx][nexty]>solution[x1][y1]+1){
	                solution[nextx][nexty]=solution[x1][y1]+1;
	                visited[nextx][nexty]=true;
	                backtracking(nextx,nexty,solution,x,y,visited);
	            }
	        }
	    }
	}*/
	public int bfs(int N, int M, int x1, int y1, int x2, int y2,int[] count,ArrayList<point> arr,boolean[][] visited){
	    int[] x= new int[] {-1, -1, 1, 1, -2, -2, 2, 2};
	    int[] y= new int[] {-2, 2, -2, 2, -1, 1, -1, 1};
	    count[0]++;
	    ArrayList<point> arr1=new ArrayList<point>();
	    while(arr.isEmpty()==false){
	        point v=(point)arr.get(0);
	        for(int i=0;i<8;i++){
	            int nextx=v.x+x[i];
	            int nexty=v.y+y[i];
	            if(nextx==x2&&nexty==y2){
	                return(1);
	            }
	            if(isValidMove(nextx,nexty,N,M)==true&&visited[nextx][nexty]==false){
	                point p=new point(nextx,nexty);
	                visited[nextx][nexty]=true;
	                arr1.add(p);
	            }
	        }
	        arr.remove(0);
	    }
	    if(arr1.isEmpty()==true){
	        return(0);
	    }
	    return(bfs(N,M,x1,y1,x2,y2,count,arr1,visited));
	}
	public int knight(int N, int M, int x1, int y1, int x2, int y2) {
	    if(x1==x2&&y1==y2){
	        return(0);
	    }
	    int[] x= new int[] {-1, -1, 1, 1, -2, -2, 2, 2};
	    int[] y= new int[] {-2, 2, -2, 2, -1, 1, -1, 1};
	    //int[][] solution=new int[N][M];
	    boolean[][] visited=new boolean[N][M];
	    visited[x1-1][y1-1]=true;
	    //backtracking(x1-1,y1-1,solution,x,y,visited);
	    //if(solution[x2-1][y2-1]!=0){
	    //    return(solution[x2-1][y2-1]);
	    //}
	    //else{
	      //  return(-1);
	    //}
	    ArrayList<point> arr=new ArrayList<point>();
	    for(int i=0;i<8;i++){
	        int nextx=x1+x[i];
	        int nexty=y1+y[i];
	        if(nextx==x2&&nexty==y2){
	            return(1);
	        }
	        if(isValidMove(nextx,nexty,N,M)==true){
	            visited[nextx][nexty]=true;
	            point p=new point(nextx,nexty);
	            arr.add(p);
	        }
	    }
	    int[] count=new int[1];
	    count[0]=1;
	    if(bfs(N,M,x1,y1,x2,y2,count,arr,visited)!=1){
	        return(-1);
	    }
	    return(count[0]);
 	}
}
