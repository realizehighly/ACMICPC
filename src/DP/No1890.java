package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

///////점프
public class No1890 {
    static int n;
    static int[][] arr;
    static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        dp = new long[n][n];

        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp[0][0] = 1;

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(dp[i][j]>0){
                    int next = arr[i][j];
                    if(next ==0)
                        continue;

                    if(i+next<n)
                        dp[i+next][j] +=dp[i][j];

                    if(j+next<n){
                        dp[i][j+next] +=dp[i][j];
                    }
                }
            }
        }
        System.out.println(dp[n-1][n-1]);
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                System.out.print(dp[i][j]);
            }
            System.out.println();
        }
    }
}
