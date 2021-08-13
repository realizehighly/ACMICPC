package DP;

///////벼락치기 ( 0/1 knapsack )

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No14728 {
    static int n,t;
    static int[][] DP;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st= new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        DP = new int[n+1][t+1];

        for(int i=1; i<n+1; i++){
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            int score = Integer.parseInt(st.nextToken());

            for(int j=1; j<t+1; j++){
                if(time<=j)
                    DP[i][j] = Math.max(DP[i-1][j],score+DP[i-1][j-time]);
                else
                    DP[i][j] = DP[i-1][j];
            }
        }
        System.out.println(DP[n][t]);
    }
}
