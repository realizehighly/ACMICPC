package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

///////동전2
public class No2294 {
    static int n,k;
    static int[] DP;
    static int[] coins;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        DP = new int[k+1];
        coins = new int[n];

        for(int i = 0; i<n; i++){
            int num = Integer.parseInt(br.readLine());
            coins[i] = num;
        }

        Arrays.sort(coins);

        Arrays.fill(DP,10001);

        DP[0] = 0;

        for(int i=0; i<n; i++){
            for(int j=1; j<k+1; j++){
                if(coins[i]<=j)
                    DP[j] = Math.min(DP[j-coins[i]]+1,DP[j]);
            }
        }
        if(DP[k]==10001){
            System.out.println("-1");
        }
        else
            System.out.println(DP[k]);
    }
}
