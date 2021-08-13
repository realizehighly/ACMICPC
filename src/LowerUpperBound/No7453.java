package LowerUpperBound;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class No7453 {
    static int n;
    static long[] AB;
    static long[] CD;
    static int upper_bound(long[] arr, int first, int last, long key){
        while(first<last){
            int mid = (first+last)/2;
            if(arr[mid]<=key)
                first = mid+1;
            else last = mid;
        }
        return first;
    }

    static int lower_bound(long[] arr ,int first, int last, long key){
        while(first<last){
            int mid = (first+last)/2;
            if(arr[mid]>=key)
                last= mid;
            else first = mid+1;
        }
        return first;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        long[] A = new long[n];
        long[] B = new long[n];
        long[] C = new long[n];
        long[] D = new long[n];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());

            A[i] = Long.parseLong(st.nextToken());
            B[i] = Long.parseLong(st.nextToken());
            C[i] = Long.parseLong(st.nextToken());
            D[i] = Long.parseLong(st.nextToken());
        }

        long[] AB = new long[n*n];
        long[] CD = new long[n*n];

        int k=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                AB[k++] = A[i]+B[j];
            }
        }
        k=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                CD[k++] = C[i]+D[j];
            }
        }

        Arrays.sort(CD);

        int sum=0;


        for(int i=0; i<AB.length; i++){

            int cnt = upper_bound(CD,0,CD.length,-AB[i])-lower_bound(CD,0,CD.length,-AB[i]);

            sum+=cnt;
        }
        System.out.println(-sum);
    }
}
