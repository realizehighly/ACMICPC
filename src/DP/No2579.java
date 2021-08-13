package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/////계단오르기
/*6
10
20
15
25
10
20
*/
public class No2579 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n;
        int[] arr;
        int[] dp;

        n= Integer.parseInt(br.readLine());
        arr = new int[n+1];
        dp = new int[n+1];

        for(int i=1; i<n+1; i++){
            int num = Integer.parseInt(br.readLine());
            arr[i] = num;
        }


        if(n>1) {
            dp[1] = arr[1];
            dp[2] = arr[1] + arr[2];

            for(int i=3; i<n+1; i++){
                dp[i] = Math.max(dp[i-3]+arr[i-1], dp[i-2]) + arr[i];
            }
            System.out.println(dp[n]);
        }
        else
            System.out.println(arr[n]);



    }


}
