package SetMap;

import java.util.*;

//중복빼고 정렬하기
public class no10867 {
    public static void main(String[] args) {

        HashSet<Integer> hset = new HashSet<Integer>();

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for(int i=0; i<N; i++){
            int num = sc.nextInt();
            hset.add(num);
        }

        List<Integer> list = new ArrayList<Integer>(hset);
        Collections.sort(list);

        Iterator<Integer> ir = list.iterator();

        while(ir.hasNext()){
            System.out.println(ir.next());

        }
    }

}
