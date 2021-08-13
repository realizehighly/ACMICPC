package SetMap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

//카드
public class No11652 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        HashMap<Long,Integer> hashMap = new HashMap<Long, Integer>();

        long resultKey = Long.MAX_VALUE ;
        int maxCnt = 0;
        for(int i=0; i<N; i++){
            long key = Long.parseLong(br.readLine());
            if(hashMap.containsKey(key)){
                int cnt = hashMap.get(key);
                hashMap.put(key,cnt+1);
                if((cnt+1)>maxCnt){
                    maxCnt++;
                    resultKey = key;
                }
                else if((cnt+1)==maxCnt){
                    if(resultKey>key)
                        resultKey = key;
                }
            }
            else{
                hashMap.put(key,1);
                if(maxCnt<1){
                    maxCnt ++;
                    resultKey = key;
                }
                else if(maxCnt==1){
                    if(resultKey>key)
                        resultKey = key;
                }
            }
        }
        System.out.println(resultKey);
    }
}
