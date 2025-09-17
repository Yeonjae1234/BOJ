//  https://www.acmicpc.net/problem/11659

import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N,M,i,j;
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N+1];
        int sum=0;
        st = new StringTokenizer(br.readLine());
        for (int k = 1; k < N+1; k++) {
            int x = Integer.parseInt(st.nextToken());
            sum+=x;
            arr[k]=sum;
        }
        for (int k = 0; k < M; k++) {
            st = new StringTokenizer(br.readLine());
            i = Integer.parseInt(st.nextToken());
            j = Integer.parseInt(st.nextToken());

            sb.append(arr[j]-arr[i-1]);
            sb.append("\n");

        }

        bw.write(String.valueOf(sb));
        bw.flush();

    }
}
