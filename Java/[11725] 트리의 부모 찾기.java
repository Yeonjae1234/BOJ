//  https://www.acmicpc.net/problem/11725

import java.io.*;
import java.util.*;
public class Main {


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer>[] edge = new ArrayList[N+1];
        for (int i = 1; i < N + 1; i++) {
            edge[i] = new ArrayList<>();
        }
        for (int i = 1; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            edge[x].add(y);
            edge[y].add(x);
        }

        boolean[] check = new boolean[N+1];
        Queue<Integer> bfs = new ArrayDeque<Integer>();
        int[] parent = new int[N+1];

        check[1]=true;
        bfs.add(1);
        while (!bfs.isEmpty()) {
            int cur = bfs.poll();
            for (int i : edge[cur]) {
                if(!check[i]){
                    parent[i]=cur;
                    check[i]=true;
                    bfs.add(i);
                }
            }
        }

        for (int i = 2; i < N + 1; i++) {
            sb.append(parent[i]).append("\n");
        }

        bw.write(String.valueOf(sb));
        bw.flush();



    }


}
