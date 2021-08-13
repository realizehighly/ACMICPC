package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/////1로 만들기
public class No1463 {

    static int[] arr;

    static int DP(int N){
        if(N==1)
            return 0;
        if(arr[N]>0)
            return arr[N];
        arr[N] = DP(N-1)+1;

        if(N%2 ==0){
            arr[N] = Math.min(DP(N/2),DP(N-1))+1;
        }

        if(N%3 ==0){
            arr[N] = Math.min(DP(N/3),DP(N-1))+1;
        }


        return arr[N];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        arr= new int[N+1];


        System.out.println(DP(N));

    }

}
