package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

////////////////동전1
public class No2293 {

    static int[] coins;
    static int[] DP;
    static int n;
    static int k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        coins = new int[n];
        DP = new int[k+1];

        for(int i = 0; i<n; i++){
            coins[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(coins);

        DP[0] = 1;

        for(int i= 0; i<n; i++){
            for(int j=1; j<k+1; j++){
                if(j>=coins[i])
                    DP[j] = DP[j]+DP[j-coins[i]];
            }
        }
        System.out.println(DP[k]);
    }
}
