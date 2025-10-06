//  https://www.acmicpc.net/problem/1932

import java.io.*;
import java.util.*;

public class Main{

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] tri = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                tri[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = n - 1; i > 0; i--) {
            for (int j = 0; j < i ; j++) {
                tri[i - 1][j] += Integer.max(tri[i][j], tri[i][j + 1]);
            }
        }

        bw.write(String.valueOf(tri[0][0]));
        bw.flush();


    }


}
