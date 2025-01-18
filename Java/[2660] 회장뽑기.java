//  https://www.acmicpc.net/problem/2660

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] mem = new int[N+1][N+1];
        int[] score = new int[N+1];
        int resultScore=Integer.MAX_VALUE;
        int resultCount=0;

        for(int i=1;i<N+1;i++){
            for(int j=1;j<N+1;j++){
                mem[i][j] = 999999;
            }
            mem[i][i]=0;
        }

        while(true){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if(x==-1) break;
            mem[x][y]=1;
            mem[y][x]=1;
        }

        for(int i=1;i<N+1;i++){
            for(int j=1;j<N+1;j++){
                for(int k=1;k<N+1;k++){
                    mem[k][j]=Integer.min(mem[k][j],mem[k][i]+mem[i][j]);
                }
            }
        }

        for(int i=1;i<N+1;i++){
            for(int j=1;j<N+1;j++){
                score[i]=Integer.max(score[i],mem[i][j]);
            }
            resultScore=Integer.min(resultScore,score[i]);
        }

        ArrayList<Integer> result = new ArrayList<>();

        for(int i=1;i<N+1;i++){
            if(score[i]==resultScore){
                resultCount++;
                result.add(i);
            }
        }

        bw.write(resultScore+" "+resultCount+"\n");
        for(int i:result){
            bw.write(i+" ");
        }



        bw.flush();
        bw.close();

    }
}
