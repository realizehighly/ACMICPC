package SetMap;

import java.util.Arrays;
import java.util.Scanner;

//집합
public class No11723 {

    static void add(boolean[] S, int x){
        if(S[x]==false) {

            S[x] = true;
        }
    }

    static void remove(boolean[] S, int x){
        if(S[x]==true)
            S[x]= false;
    }

    static boolean check(boolean[] S, int x){
        if(S[x]==true)
            return true;
        else
            return false;
    }

    static void toggle(boolean[] S, int x){
        if(S[x]==true)
            S[x]=false;
        else
            S[x]=true;
    }

    static void all(boolean[] S){
        Arrays.fill(S,true);
    }

    static  void empty(boolean[] S){
        Arrays.fill(S,false);
    }

    public static void main(String[] args) {
        boolean[] S = new boolean[21];

        StringBuilder sb=new StringBuilder();

        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();

        for(int i=0; i<M; i++){
            String s = sc.next();

            if(s.equals("add")){
                int n = sc.nextInt();
                add(S,n);
            }

            else if(s.equals("remove")){
                int n = sc.nextInt();
                remove(S,n);
            }

            else if(s.equals("check")){
                int n = sc.nextInt();
                if(check(S,n))
                    sb.append(1+"\n");
                else
                    sb.append(0+"\n");
            }

            else if(s.equals("toggle")){
                int n = sc.nextInt();
                toggle(S,n);
            }

            else if(s.equals("all")){
                all(S);
            }

            else if(s.equals("empty")){
                empty(S);
            }
        }
        System.out.println(sb.toString());
    }
}
