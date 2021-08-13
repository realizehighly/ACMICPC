package LowerUpperBound;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.Vector;

public class No7795 {
    static int t;
    static int n,m;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        t = Integer.parseInt(br.readLine());

        for(int i=0; i<t; i++){
            st = new StringTokenizer(br.readLine()," ");
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            Vector<Integer> a = new Vector<>();
            Vector<Integer> b = new Vector<>();

            st = new StringTokenizer(br.readLine()," ");
            for(int j=0; j<n; j++){
                a.add(Integer.parseInt(st.nextToken()));
            }
            st = new StringTokenizer(br.readLine()," ");
            for(int k=0; k<m; k++){
                b.add(Integer.parseInt(st.nextToken()));
            }
            Collections.sort(b);

            int sum = 0;
            for(int l=0; l<n; l++){
                int we= Collections.binarySearch(b,a.elementAt(l));
                if(we<0)
                    //System.out.println(-we-1);
                    sum+= -we-1;
                else{
                    int firstIndex = we;
                    for(;firstIndex>=0&&
                            a.elementAt(firstIndex)==a.elementAt(firstIndex);
                        firstIndex--)
                    sum+=firstIndex;

                }

            }
            System.out.println(sum);
        }
    }
}
