package LowerUpperBound;

import java.io.BufferedReader;
import java.io.*;
import java.util.*;
public class No10815 {
    static int n,m;


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        int[] card = new int[n];
        for(int i=0; i<n; i++){
            int a = Integer.parseInt(st.nextToken(" "));
            card[i] = a;
        }
        Arrays.sort(card);
        m = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for(int j=0; j<m; j++){
            int b = Integer.parseInt(st.nextToken(" "));
            int result = Arrays.binarySearch(card,b);
            if(result>=0){
                System.out.print("1 ");
            }
            else
                System.out.print("0 ");
        }
    }
}
