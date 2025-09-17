//  https://www.acmicpc.net/problem/2606

import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        List<Integer>[] E = new ArrayList[N+1];
        for (int i = 1; i < N + 1; i++) {
            E[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int x,y;
            StringTokenizer st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            E[x].add(y);
            E[y].add(x);
        }

        boolean[] V = new boolean[N+1];
        V[1]=true;
        int answer=0;

        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);
        while(!q.isEmpty()){
            int temp = q.poll();
            for (int i : E[temp]) {
                if(!V[i]){
                    q.add(i);
                    V[i]=true;
                    answer++;
                }
            }
        }

        bw.write(String.valueOf(answer));
        bw.flush();

    }
}
