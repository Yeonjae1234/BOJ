//  https://www.acmicpc.net/problem/9095

import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        int n;
        int[] arr = new int[11];

        arr[1]=1;
        arr[2]=2;
        arr[3]=4;

        for(int i=4;i<11;i++){
            arr[i]= arr[i-1]+arr[i-2]+arr[i-3];
        }

        for (int i = 0; i < T; i++) {
            n = Integer.parseInt(br.readLine());
            sb.append(arr[n]);
            sb.append("\n");
        }

        bw.write(String.valueOf(sb));
        bw.flush();

    }
}
