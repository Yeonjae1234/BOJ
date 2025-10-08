//  https://www.acmicpc.net/problem/9465

import java.util.*;
import java.io.*;


public class Main {

    public static int solution(int n, int[][] sticker) {
        int[][] score = new int[3][n];
        score[0][0] = sticker[0][0];
        score[1][0] = sticker[1][0];
        score[2][0] = 0;
        for (int i = 1; i < n; i++) {
            score[0][i] = sticker[0][i] + Integer.max(score[1][i - 1], score[2][i - 1]);
            score[1][i] = sticker[1][i] + Integer.max(score[0][i - 1], score[2][i - 1]);
            score[2][i] = Integer.max(score[0][i - 1], score[1][i - 1]);
        }
        return Integer.max(score[0][n - 1], Integer.max(score[1][n - 1], score[2][n - 1]));
    }

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            int[][] sticker = new int[2][n];
            for (int j = 0; j < 2; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < n; k++) {
                    sticker[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            sb.append(solution(n, sticker)).append('\n');
        }


        bw.write(String.valueOf(sb));
        bw.flush();

    }
}
