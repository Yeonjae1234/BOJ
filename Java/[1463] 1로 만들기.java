//  https://www.acmicpc.net/problem/1463

import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[1000001];
        arr[2]=1;
        arr[3]=1;
        for (int i = 4; i <= N; i++) {
            int a=0,b=0;
            int cur = i;
            while (cur % 2 != 0) {
                cur--;
                a++;
            }
            cur/=2;
            a++;
            a+=arr[cur];
            
            cur = i;
            while (cur % 3 != 0) {
                cur--;
                b++;
            }
            cur/=3;
            b++;
            b+=arr[cur];
            arr[i]=Math.min(a,b);
        }
        bw.write(String.valueOf(arr[N]));
        bw.flush();

    }
}
