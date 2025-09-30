//  https://www.acmicpc.net/problem/15650

import java.io.*;
import java.util.*;
public class Main {

    static StringBuilder answer = new StringBuilder();
    static StringBuilder sb = new StringBuilder();

    public static void dfs(int N, int M,int start){
        if(M==0){
            answer.append(sb).append("\n");
            return;
        }
        for(int i=start;i<=N;i++){
            sb.append(i).append(" ");
            dfs(N,M-1,i+1);
            sb.delete(sb.length()-2,sb.length());
        }

    }



    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        dfs(N,M,1);

        bw.write(String.valueOf(answer));
        bw.flush();



    }


}
