//  https://www.acmicpc.net/problem/1461

import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N,M;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> plus = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minus = new PriorityQueue<>(Collections.reverseOrder());

        st = new StringTokenizer(br.readLine());

        for(int i=0;i<N;i++) {
            int x = Integer.parseInt(st.nextToken());
            if(x>0){
                plus.add(x);
            }
            else{
                minus.add(x*-1);
            }
        }

        int answer = 0;

        if (!plus.isEmpty()&&!minus.isEmpty()) {
            if (plus.peek() > minus.peek()) {
                answer += plus.poll();
                for (int i = 0; i < M - 1; i++) {
                    if (plus.isEmpty()) break;
                    plus.poll();
                }
            } else {
                answer += minus.poll();
                for (int i = 0; i < M - 1; i++) {
                    if (minus.isEmpty()) break;
                    minus.poll();
                }
            }
        }
        else if(!plus.isEmpty()){
            answer += plus.poll();
            for (int i = 0; i < M - 1; i++) {
                if (plus.isEmpty()) break;
                plus.poll();
            }
        }
        else if(!minus.isEmpty()){
            answer += minus.poll();
            for (int i = 0; i < M - 1; i++) {
                if (minus.isEmpty()) break;
                minus.poll();
            }
        }

        while (!plus.isEmpty()&&!minus.isEmpty()) {
            if (plus.peek() > minus.peek()) {
                answer += plus.poll() * 2;
                for (int i = 0; i < M - 1; i++) {
                    if (plus.isEmpty()) break;
                    plus.poll();
                }
            } else {
                answer += minus.poll() * 2;
                for (int i = 0; i < M - 1; i++) {
                    if (minus.isEmpty()) break;
                    minus.poll();
                }
            }
        }
        while(!plus.isEmpty()){
            answer += plus.poll() * 2;
            for (int i = 0; i < M - 1; i++) {
                if (plus.isEmpty()) break;
                plus.poll();
            }
        }
        while(!minus.isEmpty()){
            answer += minus.poll() * 2;
            for (int i = 0; i < M - 1; i++) {
                if (minus.isEmpty()) break;
                minus.poll();
            }
        }

        bw.write(answer+"");

        bw.flush();
        bw.close();

    }
}
