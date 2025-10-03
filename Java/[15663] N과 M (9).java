//  https://www.acmicpc.net/problem/15663

import java.io.*;
import java.util.*;

public class Main{

    public static int N,M;
    public static StringBuilder sb = new StringBuilder();
    public static void dfs(int[] arr,int[] answer,int cur,boolean[] arrCheck) {
        if(cur==M){
            for (int i = 0; i < M; i++) {
                sb.append(answer[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        HashMap<Integer, Boolean> hashCheck = new HashMap<>();
        for (int i = 0; i < N; i++) {
            hashCheck.put(arr[i], false);
        }
        for (int i = 0; i < N; i++) {
            if(arrCheck[i]){
                continue;
            }
            if(hashCheck.get(arr[i])){
                continue;
            }
            answer[cur] = arr[i];
            arrCheck[i] = true;
            hashCheck.replace(arr[i], true);
            dfs(arr, answer, cur + 1, arrCheck);
            arrCheck[i]=false;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int[] answer = new int[M];
        boolean[] arrCheck = new boolean[N];
        dfs(arr, answer, 0, arrCheck);

        bw.write(String.valueOf(sb));
        bw.flush();


    }


}
