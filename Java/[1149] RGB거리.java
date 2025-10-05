// https://www.acmicpc.net/problem/1149

import java.io.*;
import java.util.*;

public class Main{


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[][] cost = new int[N][3];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int prevR = cost[0][0];
        int prevG = cost[0][1];
        int prevB = cost[0][2];
        int curR,curG,curB;

        for (int i = 1; i < N; i++) {
            curR = cost[i][0] + Integer.min(prevG, prevB);
            curG = cost[i][1] + Integer.min(prevR, prevB);
            curB = cost[i][2] + Integer.min(prevR, prevG);
            prevR = curR;
            prevG = curG;
            prevB = curB;
        }

        int answer = Integer.min(prevR, Integer.min(prevG, prevB));


        bw.write(String.valueOf(answer));
        bw.flush();


    }


}
