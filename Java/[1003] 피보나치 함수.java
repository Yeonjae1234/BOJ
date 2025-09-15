// https://www.acmicpc.net/problem/1003

import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        int[] fibo = new int[41];
        fibo[0]=0;
        fibo[1]=1;
        for (int i = 2; i < 41; i++) {
            fibo[i] = fibo[i - 2] + fibo[i - 1];
        }

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0) {
                sb.append(1).append(" ").append(0);
            } else if (N == 1) {
                sb.append(0).append(" ").append(1);
            }
            else {
                sb.append(fibo[N-1]).append(" ").append(fibo[N]);
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();

    }
}
