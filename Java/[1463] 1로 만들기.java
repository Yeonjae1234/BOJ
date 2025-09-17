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
            arr[i] = arr[i-1]+1;
            if(i%2==0){
                arr[i]=Math.min(arr[i],arr[i/2]+1);
            }
            if(i%3==0){
                arr[i]=Math.min(arr[i],arr[i/3]+1);
            }
        }
        bw.write(String.valueOf(arr[N]));
        bw.flush();

    }
}
