//  https://www.acmicpc.net/problem/11724

import java.io.*;
import java.util.*;

public class Main{

    public static void bfs(ArrayList<Integer>[] graph,int[] visited,int start){
        ArrayDeque<Integer> Q = new ArrayDeque<>();
        visited[start] = 1;
        Q.add(start);
        while(!Q.isEmpty()){
            int V = Q.poll();
            for(int i:graph[V]){
                if(visited[i]==0){
                    visited[i]=1;
                    Q.add(i);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N,M;
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] graph = new ArrayList[N + 1];
        for (int i = 1; i < N + 1; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < M; i++) {
            int x,y;
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            graph[x].add(y);
            graph[y].add(x);
        }
        int[] visited = new int[N+1];
        int answer = 0;
        for(int i=1;i<N+1;i++){
            if(visited[i]==0){
                answer++;
                bfs(graph,visited,i);
            }
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        

    }


}
