package SetMap;
//회사에 있는 사람

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//회사에 있는 사람
public class No7785 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        HashSet<String> hashSet = new HashSet<String>();

        StringTokenizer st ;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        for(int i =0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String state = st.nextToken();

            if(state.equals("enter")){
                hashSet.add(name);
            }
            else if(state.equals("leave")){
                hashSet.remove(name);
            }
        }
        List<String> list = new ArrayList<String>(hashSet);
        Collections.sort(list);

        for(int i = list.size()-1; i>=0; i--)
            System.out.println(list.get(i));

    }
}
