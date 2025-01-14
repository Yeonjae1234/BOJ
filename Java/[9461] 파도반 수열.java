//  https://www.acmicpc.net/problem/9461

import java.io.*;
import java.util.*;

public class Main {

    
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T;
        int N;

        T = Integer.parseInt(br.readLine());

        long[] arr = new long[101];
        arr[1]=1;
        arr[2]=1;

        for(int i=0;i<T;i++){
            N=Integer.parseInt(br.readLine());
            for(int j=3;j<=N;j++){
                arr[j] = arr[j-2]+arr[j-3];
            }
            bw.write(arr[N]+"\n");
        }

        bw.flush();
        bw.close();

    }
}
