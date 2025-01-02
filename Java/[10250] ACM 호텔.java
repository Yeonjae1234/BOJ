// https://www.acmicpc.net/problem/10250

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        int H, W, N;
        String answer;
        int floor, room;
        for(int i=0;i<T;i++){
            st=new StringTokenizer(br.readLine());
            H=Integer.parseInt(st.nextToken());
            W=Integer.parseInt(st.nextToken());
            N=Integer.parseInt(st.nextToken());

            floor = N%H;
            room = N/H+1;
            if(floor==0) {
                floor=H;
                room--;
            }

            answer = String.format("%d%02d",floor,room);

            bw.write(answer+"\n");

        }


        bw.flush();
        bw.close();

    }
}
