package Bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

///////안전영역
public class No2468 {
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};

    static int N;

    static int[][] arr;
    static boolean[][] visited;

    public static void BFS(int[][] arr, int n, int m, int max){
        Queue<Integer> qx = new LinkedList<Integer>();
        Queue<Integer> qy = new LinkedList<Integer>();

        qx.offer(n);
        qy.offer(m);

        visited[n][m] = true;


        while(!qx.isEmpty() && !qy.isEmpty()){
            int a = qx.poll();
            int b = qy.poll();
            for(int i=0; i<4; i++){
                int nextx = a+dx[i];
                int nexty = b+dy[i];

                if(nextx<0||nexty<0||nextx>=N||nexty>=N)
                    continue;

                if(visited[nextx][nexty]==true) {
                    continue;
                }

                if(arr[nextx][nexty]<=max) {
                    continue;
                }

                qx.add(nextx);
                qy.add(nexty);
                visited[nextx][nexty] = true;
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        arr = new int[N][N];


        int max = 0;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(max<arr[i][j])
                    max = arr[i][j];
            }
        }

        int countmax =0;
        int count = 0;
        for(int k=0; k<max; k++) {
            visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (arr[i][j] > k && visited[i][j] == false) {
                        BFS(arr,i,j,k);
                        count++;
                    }
                }
            }

            if(countmax<count){
                countmax = count;
            }

            count=0;
        }
        System.out.println(countmax);
    }
}
