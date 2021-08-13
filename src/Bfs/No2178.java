package Bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/////////////미로탐색
public class No2178 {
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};

    static boolean[][] visited;

    static void BFS(int[][] arr, int n, int m){
        Queue<Integer> qx = new LinkedList<>();
        Queue<Integer> qy = new LinkedList<>();
        qx.add(0);
        qy.add(0);
        visited[0][0] = true;

        while(!qx.isEmpty()&&!qy.isEmpty()) {
            int a = qx.poll();
            int b = qy.poll();

            for (int i = 0; i < 4; i++) {
                int nextx = a + dx[i];
                int nexty = b + dy[i];

                if(nextx<0||nexty<0||nextx>=n||nexty>=m){
                    continue;
                }
                if(arr[nextx][nexty]==0) {
                    continue;
                }
                if(visited[nextx][nexty]==true)
                    continue;

                qx.add(nextx);
                qy.add(nexty);
                arr[nextx][nexty]=arr[a][b]+1;
                visited[nextx][nexty] = true;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];
        visited = new boolean[N][M];

        for(int i =0; i<N; i++){
            String temp = br.readLine();
            for(int j=0; j<M; j++){
                arr[i][j] = temp.charAt(j)-'0';
            }
        }

        BFS(arr,N,M);

        System.out.println(arr[N-1][M-1]);
    }
}
