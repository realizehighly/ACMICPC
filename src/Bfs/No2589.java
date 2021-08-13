package Bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

///////////보물섬
public class No2589 {
    static int N,M;
    static char[][] arr;
    static boolean[][] visited;

    static int result=0;
    static int cnt;

    static int[] dx= {0,0,-1,1};
    static int[] dy = {-1,1,0,0};

    public static int BFS(char[][] arr, int n, int m){
        Queue<Integer> qx = new LinkedList<>();
        Queue<Integer> qy = new LinkedList<>();

        qx.add(n);
        qy.add(m);
        visited[n][m] = true;

        int[][] time = new int[N][M];
        time[n][m] = 0;
        cnt = 0;

        while(!qx.isEmpty()&&!qy.isEmpty()){
            int a = qx.poll();
            int b = qy.poll();

            for(int i=0; i<4; i++){
                int nextx = a+dx[i];
                int nexty = b+dy[i];

                if(nextx<0||nexty<0||nextx>=N||nexty>=M)
                    continue;

                if(arr[nextx][nexty]=='W')
                    continue;

                if(visited[nextx][nexty]==true)
                    continue;

                qx.add(nextx);
                qy.add(nexty);
                visited[nextx][nexty] = true;
                time[nextx][nexty]=time[a][b]+1;
                if(cnt<time[nextx][nexty]){
                    cnt = time[nextx][nexty];
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new char[N][M];

        for(int i=0; i<N; i++){
            String temp = br.readLine();
            for(int j=0; j<M; j++){
                arr[i][j] = temp.charAt(j);
            }
        }
        visited = new boolean[N][M];
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(arr[i][j]=='L'){
                    visited = new boolean[N][M];

                    int temp = BFS(arr,i,j);

                    if(result<temp)
                        result = temp;
                }
            }
        }

        System.out.println(result);
    }
}
