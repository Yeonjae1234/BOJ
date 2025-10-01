//  https://www.acmicpc.net/problem/11053

import java.io.*;
import java.util.*;
public class Main {


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] answer = new int[N];
        Arrays.fill(answer,1);
        int max=1;
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                if (arr[j] > arr[i]) {
                    answer[j] = Math.max(answer[j], answer[i] + 1);
                    max = Math.max(max, answer[j]);
                }
            }
        }



        bw.write(String.valueOf(max));
        bw.flush();



    }


}
