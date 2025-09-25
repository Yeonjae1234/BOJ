// https://www.acmicpc.net/problem/1931

import java.util.*;
import java.io.*;


public class Main {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> {
            if(a[1]==b[1]) return a[0]-b[0];
            else return a[1]-b[1];
        });
        int start,end;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            int[] meetingTemp = {start,end};
            pq.add(meetingTemp);
        }
        int answer = 0;
        int endTime = 0;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            if(cur[0]>=endTime){
                answer++;
                endTime = cur[1];
            }
        }

        bw.write(String.valueOf(answer));
        bw.flush();

    }
}
