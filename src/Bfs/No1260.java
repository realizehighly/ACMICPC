package Bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//DFS와 BFS
public class No1260 {
    static void DFS(ArrayList<Integer>[] al, boolean[] visited, int start){
        visited[start]= true;

        System.out.print(start + " ");

        for(int i: al[start]){
            if(visited[i]==false)
                DFS(al,visited,i);
        }
    }

    static void BFS(ArrayList<Integer>[] al, boolean[] visited, int start){
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(start);
        visited[start]= true;

        while(!q.isEmpty()){
            int x = q.remove();
            System.out.print(x+" ");

            for(int i : al[x]){
                if(visited[i]==false){
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] al = new ArrayList[n+1];
        for(int i = 1; i<n+1; i++){
            al[i] = new ArrayList<Integer>();
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            al[x].add(y);
            al[y].add(x);
        }

        for(int i =1; i<n+1; i++){
            Collections.sort(al[i]);
        }

        boolean[] visited = new boolean[n+1];

        DFS(al,visited,v);

        Arrays.fill(visited,false);
        System.out.println();

        BFS(al,visited,v);
    }
}
