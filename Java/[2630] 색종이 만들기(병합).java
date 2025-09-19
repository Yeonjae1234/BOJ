//  https://www.acmicpc.net/problem/2630

import java.util.*;
import java.io.*;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static boolean check(int[][] map,int si, int sj,int step){
        int color = map[si][sj];
        for (int i = si; i < si + step; i++) {
            for (int j = sj; j < sj + step; j++) {
                if(map[i][j]!=color) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        int blue=0,white=0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int x = Integer.parseInt(st.nextToken());
                if(x==1) blue++;
                else white++;
                map[i][j]=x;
            }
        }
        int step = 2;
        while(step<=N) {
            for (int i = 0; i < N; i += step) {
                for (int j = 0; j < N; j += step) {
                    if(check(map,i,j,step)){
                        if(map[i][j]==1) blue-=3;
                        else white-=3;
                    }
                }
            }
            step*=2;
        }
        sb.append(white).append("\n").append(blue);
        bw.write(sb.toString());
        bw.flush();

    }
}
