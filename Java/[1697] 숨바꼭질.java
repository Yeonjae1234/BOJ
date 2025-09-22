//  https://www.acmicpc.net/problem/1697

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        boolean[] visited = new boolean[100001];
        int[] result = new int[100001];

        for(int i=0;i<100001;i++){
            result[i] = Integer.MAX_VALUE;
        }

        Queue<Integer> q = new ArrayDeque<>();
        q.add(N);
        visited[N]=true;
        result[N]=0;
        while(true){
            int cur = q.poll();
            if(cur==K) break;
            int a = cur-1;
            int b = cur+1;
            int c = cur*2;
            if(a>=0&&!visited[a]){
                result[a]=result[cur]+1;
                visited[a]=true;
                q.add(a);
            }
            if(b<=100000&&!visited[b]) {
                result[b] = result[cur] + 1;
                visited[b]=true;
                q.add(b);
            }
            if(c<=100000&&!visited[c]){
                result[c]=result[cur]+1;
                visited[c]=true;
                q.add(c);
            }
            if(a==K||b==K||c==K){
                break;
            }
        }
        bw.write(String.valueOf(result[K]));
        bw.flush();
    }
}
