//  https://www.acmicpc.net/problem/11399

import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        Integer[] time = new Integer[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            time[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(time);
        int result = 0;
        int temp = 0;
        for (int i = 0; i < N; i++) {
            temp += time[i];
            result += temp;
        }
        bw.write(result + "");
        bw.flush();

    }
}
