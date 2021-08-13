package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/////////연속합
public class No1912 {
    static int n;
    static int[] arr;
    static int[] dp;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n= Integer.parseInt(br.readLine());

        arr= new int[n];
        dp = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
        }
        dp[0] = arr[0];
        max = dp[0];
        for(int i=1; i<n; i++){
            dp[i] = Math.max(arr[i],dp[i-1]+arr[i]);
            if(max<dp[i])
                max = dp[i];
        }
        System.out.println(max);
    }
}
