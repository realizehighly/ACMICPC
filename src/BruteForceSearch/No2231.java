package BruteForceSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No2231 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for(int i = 1; i<=n; i++){
            int result = i;
            int temp = i;
            while(temp!=0){
                result +=(temp%10);
                temp/=10;
            }
            if(result==n) {
                System.out.println(i);
                return;
            }
        }
        System.out.println("0");

    }
}
