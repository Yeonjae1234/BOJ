//  https://www.acmicpc.net/problem/2630

import java.util.*;
import java.io.*;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void check(int[][] map, int r,int c, int size,int[] color){
        int startcolor = map[r][c];
        if(size==1){
            color[startcolor]++;
            return;
        }
        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                if(startcolor != map[i][j]){
                    check(map,r,c,size/2,color);
                    check(map,r,c+size/2,size/2,color);
                    check(map,r+size/2,c,size/2,color);
                    check(map,r+size/2,c+size/2,size/2,color);
                    return;
                }
            }
        }

        color[startcolor]++;
    
    }

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        int[] color = new int[2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int x = Integer.parseInt(st.nextToken());
                map[i][j]=x;
            }
        }
        check(map, 0, 0, N, color);

        sb.append(color[0]).append("\n").append(color[1]);

        bw.write(sb.toString());
        bw.flush();

    }
}

