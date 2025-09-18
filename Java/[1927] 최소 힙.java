//  https://www.acmicpc.net/problem/1927

import java.util.*;
import java.io.*;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> Q = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            if(x==0){
                if (Q.isEmpty()) {
                    sb.append("0\n");
                }
                else{
                    sb.append(Q.poll()).append("\n");
                }
            }
            else{
                Q.add(x);
            }
        }
        bw.write(sb.toString());
        bw.flush();

    }
}
