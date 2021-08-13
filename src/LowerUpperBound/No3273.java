package LowerUpperBound;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.Vector;

public class No3273 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        Vector<Integer> hs = new Vector<>();

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            hs.add(Integer.parseInt(st.nextToken()));
        }
        int sum = Integer.parseInt(br.readLine());

        Collections.sort(hs);
        int cnt = 0;
        for(int i=0; i<n; i++){
            int x = hs.elementAt(i);
            int y = sum-x;
            if(x<y){
                int yIndex = Collections.binarySearch(hs,y);
                if(yIndex<0)
                    continue;
                else
                    cnt++;
            }
            else
                break;
        }
        System.out.println(cnt);


    }
}
