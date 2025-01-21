//  https://www.acmicpc.net/problem/2458

import java.io.*;
import java.util.*;

public class Main {

    public static int solution(ArrayList<Integer>[] pInfo, int N){
        int[] visited = new int[N + 1];
        int[] parent = new int[N + 1];
        int[] child = new int[N + 1];
        int result = 0;
        Queue<Integer> bfs = new LinkedList<>();

        for (int i = 1; i < N + 1; i++) {
            bfs.add(i);

            while (!bfs.isEmpty()) {
                int index = bfs.poll();
                for (int j : pInfo[index]) {
                    if(visited[j]==0){
                        bfs.add(j);
                        parent[i]++;
                        visited[j]=1;
                        child[j]++;
                    }
                }
            }
            for (int j=1; j < N + 1; j++) {
                visited[j]=0;
            }
        }

        for (int i = 1; i < N + 1; i++) {
            if(parent[i]+child[i]==N-1){
                result++;
            }
        }
        return result;

    }



    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N, M;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] pInfo = new ArrayList[N + 1];

        for (int i = 0; i < N + 1; i++) {
            pInfo[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x,y;
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            pInfo[x].add(y);
        }

        bw.write(solution(pInfo, N)+"");

        bw.flush();
        bw.close();

    }
}
