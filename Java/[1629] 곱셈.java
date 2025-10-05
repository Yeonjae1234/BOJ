//  https://www.acmicpc.net/problem/1629

import java.io.*;
import java.util.*;

public class Main{

    public static long recur(long[] mem,long B,int C) {
        if(B==0){
            return 1;
        }
        int step=0;
        long point=1;
        while(point<=B){
            point*=2;
            step++;
        }
        point/=2;
        step--;

        return mem[step]*recur(mem,B-point,C)%C;
    }


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        long[] mem = new long[32];
        int step=0;
        long point=1;
        while(point<=B){
            point*=2;
            step++;
        }
        point/=2;
        step--;
        mem[0] = A%C;
        for (int i = 1; i <= step; i++) {
            mem[i] = mem[i-1]*mem[i-1]%C;
        }
        long answer = mem[step]*recur(mem,B-point,C)%C;


        bw.write(String.valueOf(answer));
        bw.flush();


    }


}
