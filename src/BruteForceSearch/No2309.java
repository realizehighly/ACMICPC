package BruteForceSearch;
//일곱난쟁이

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class No2309 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Integer> al = new ArrayList<Integer>();

        int sum = 0;
        for(int i = 0; i<9; i++){
            int num = Integer.parseInt(br.readLine());
            al.add(num);
            sum += num;
        }
        int temp = sum - 100;

        Collections.sort(al);

        boolean checked = false;
        for(int i = 0; i<al.size()-1; i++){
            for(int j=i+1; j<al.size(); j++){
                if((al.get(i)+al.get(j))==temp){
                    al.remove(j);
                    al.remove(i);
                    checked = true;
                    break;
                }
            }
            if(checked==true)
                break;
        }

        for(int i=0; i<al.size(); i++){
            System.out.println(al.get(i));
        }

    }
}
