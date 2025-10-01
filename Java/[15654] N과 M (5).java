//  https://www.acmicpc.net/problem/15654

import java.io.*;
import java.util.*;
public class Main {

    public static StringBuilder sb = new StringBuilder();

    public static void dfs(int N,int M,int cur,int[] answer,int[] arr) {
        if(answer[M-1]!=0){
            for(int k:answer){
                sb.append(k).append(' ');
            }
            sb.append('\n');
            return;
        }
        for (int i = 0; i < N; i++) {
            if(check(arr[i],cur,answer)){
                continue;
            }
            answer[cur] = arr[i];
            dfs(N,M,cur+1,answer,arr);
            answer[cur] = 0;
        }
    }

    public static boolean check(int value,int cur, int[] answer){
        for(int i=0;i<cur;i++){
            if(value==answer[i]){
                return true;
            }
        }
        return false;
    }



    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        int[] answer = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++ ) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        dfs(N, M, 0, answer, arr);

        bw.write(String.valueOf(sb));
        bw.flush();



    }


}
