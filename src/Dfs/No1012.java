package Dfs;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//////////유기농배추
public class No1012 {

    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};

    static int M,N,K;
    static int[][] arr;
    static boolean[][] visited;

    static void DFS(int[][] arr, int x, int y){
        visited[x][y] = true;

        for(int i=0; i<4; i++){

            int nextx = x+dx[i];
            int nexty = y+dy[i];

            if(nextx<0||nexty<0||nextx>=N||nexty>=M)
                continue;

            if(visited[nextx][nexty]==true)
                continue;

            if(arr[nextx][nexty]!=1)
                continue;

            DFS(arr,nextx,nexty);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int testcase = Integer.parseInt(br.readLine());

        for(int n=0; n<testcase; n++){
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            arr = new int[N][M];

            for(int i=0; i<K; i++){
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());
                arr[Y][X] = 1;
            }
            visited = new boolean[N][M];
            int cnt = 0;
            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    if(arr[i][j]==1&&visited[i][j]==false){
                        DFS(arr,i,j);
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
        }

    }

}
