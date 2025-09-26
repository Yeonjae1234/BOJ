//  https://www.acmicpc.net/problem/7576

import java.io.*;
import java.util.*;

public class Main{

    public static boolean check(int[][] tomato,int N,int M){
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(tomato[i][j]==0) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken()); // 가로
        int N = Integer.parseInt(st.nextToken()); // 세로

        int[][] tomato = new int[N][M];
        int[][] days = new int[N][M];
        Queue<int[]> bfs = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int status = Integer.parseInt(st.nextToken());
                tomato[i][j] = status;
                if(status==0){
                    days[i][j] = Integer.MAX_VALUE;
                }
                else if(status==1){
                    days[i][j] = 0;
                    int[] temp = {i,j};
                    bfs.add(temp);
                }
                else{
                    days[i][j]=-1;
                }
            }
        }

        int[] dirX = {-1,1,0,0};
        int[] dirY = {0,0,-1,1};
        int answer = 0;
        while (!bfs.isEmpty()) {
            int[] cur = bfs.poll();
            for(int i=0;i<4;i++){
                int x = cur[0]+dirX[i];
                int y = cur[1]+dirY[i];

                if(x<0||x>=N||y<0||y>=M) continue;
                if(tomato[x][y]==0){
                    days[x][y] = days[cur[0]][cur[1]]+1;
                    answer=Integer.max(answer,days[x][y]);
                    tomato[x][y]=1;
                    int[] temp = {x,y};
                    bfs.add(temp);
                }

            }
        }

        if(!check(tomato,N,M)){
            answer = -1;
        }

        bw.write(String.valueOf(answer));
        bw.flush();
    }
}
