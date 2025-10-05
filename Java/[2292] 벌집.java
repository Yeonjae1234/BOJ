//  https://www.acmicpc.net/problem/2292

import java.io.*;
import java.util.*;

public class Main{

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        long step=0;
        long end=1;
        while(true){
            if(end>=N) break;
            step++;
            end+=6*step;
        }

        bw.write(String.valueOf(step+1));
        bw.flush();


    }


}
