//  https://www.acmicpc.net/problem/1240

import java.io.*;
import java.util.*;

public class Main {

    public static long solution(ArrayList<int[]>[] tree, int start, int end, int N){

        boolean[] visited = new boolean[N+1];
        return dfs(tree,start,end, visited, 0,-1);

    }

    public static long dfs(ArrayList<int[]>[] tree, int start, int end, boolean[] visited, long cost, long answer){
        visited[start] = true;
        if(start==end){
            return cost;
        }
        for(int[] i:tree[start]){
            if (visited[i[0]]) continue;
            answer = dfs(tree,i[0],end,visited,cost+i[1],answer);
            if(answer>0) return answer;
        }

        return answer;

    }



    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N,M;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());


        ArrayList<int[]>[] tree = new ArrayList[N+1];

        for(int i=0;i<N+1;i++){
            tree[i] = new ArrayList<int[]>();
        }

        for(int i=0;i<N-1;i++){
            st = new StringTokenizer(br.readLine());
            int x,y,value;
            int[] tmp1 = new int[2];
            int[] tmp2 = new int[2];

            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            value = Integer.parseInt(st.nextToken());

            tmp1[0]=y;
            tmp1[1]=value;
            tree[x].add(tmp1);

            tmp2[0]=x;
            tmp2[1]=value;
            tree[y].add(tmp2);
        }

        for(int i=0;i<M;i++){
            int x,y;
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            bw.write(solution(tree,x,y,N)+"\n");
        }


        bw.flush();
        bw.close();

    }
}
