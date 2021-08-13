package Bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

///////////////////토마토
public class No7576 {

    static boolean[][] visited;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};

    static void BFS(int[][] arr, int n, int m){
        Queue<Integer> qx = new LinkedList<>();
        Queue<Integer> qy = new LinkedList<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(arr[i][j]==1){
                    qx.add(i);
                    qy.add(j);
                    visited[i][j]=true;
                }
            }
        }
        while(!qx.isEmpty()&&!qy.isEmpty()){
            int a=qx.poll();
            int b=qy.poll();

            for(int i=0; i<4; i++){
                int nextx = a+dx[i];
                int nexty = b+dy[i];

                if(nextx<0||nexty<0||nextx>=n||nexty>=m)
                    continue;

                if(arr[nextx][nexty]!=0)
                    continue;

                if(visited[nextx][nexty]==true)
                    continue;

                arr[nextx][nexty] = arr[a][b]+1;
                qx.add(nextx);
                qy.add(nexty);
                visited[nextx][nexty] = true;
            }

        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int arr[][] = new int[n][m];
        visited = new boolean[n][m];


        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                int num = Integer.parseInt(st.nextToken());
                arr[i][j] =num;
            }
        }
        BFS(arr,n,m);

        //2중 리스트 출력
        int max = 1;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++) {
                if (arr[i][j] == 0) {
                    System.out.println("-1");
                    return;
                }
                if (arr[i][j] > max) {
                    max = arr[i][j];
                }
            }
        }
        System.out.println(max-1);




    }
}
