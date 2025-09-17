//  https://www.acmicpc.net/problem/1012

import java.util.*;
import java.io.*;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static int solution(int M,int N, int K)throws Exception{
        int result = 0;
        int[][] field = new int[M][N];
        Queue<int[]> cabbage = new ArrayDeque<>();
        Queue<int[]> neighborQ = new ArrayDeque<>();

        int[] xd = {0, 0, 1, -1};
        int[] yd = {1, -1, 0, 0};

        for (int i = 0; i < K; i++) {
            int[] c = new int[2];
            StringTokenizer st = new StringTokenizer(br.readLine());
            c[0] = Integer.parseInt(st.nextToken());
            c[1] = Integer.parseInt(st.nextToken());
            field[c[0]][c[1]]=1;
            cabbage.add(c);
        }

        while (!cabbage.isEmpty()) {
            int[] cur = cabbage.poll();
            if (field[cur[0]][cur[1]] == 1) {
                result++;
                field[cur[0]][cur[1]]=2;
                neighborQ.add(cur);
                while (!neighborQ.isEmpty()) {
                    int[] temp=neighborQ.poll();
                    for (int i = 0; i < 4; i++) {
                        int a = temp[0] + xd[i];
                        int b = temp[1] + yd[i];
                        if (a < 0 || b < 0 || a >= M || b >= N) {
                            continue;
                        } else {
                            if (field[a][b] == 1) {
                                field[a][b] = 2;
                                int[] n = {a,b};
                                neighborQ.add(n);
                            }
                        }
                    }

                }
            }
        }

        return result;
    }

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int M,N,K;
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            sb.append(solution(M,N,K)).append("\n");
        }

        bw.write(String.valueOf(sb));
        bw.flush();

    }
}
