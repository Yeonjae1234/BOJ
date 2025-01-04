// https://acmicpc.net/problem/11722

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] data = new int[N];
        int[] len = new int[N];
        int answer = 0;

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            data[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<N;i++){
            len[i]=1;
            for(int j=0;j<i;j++){
                if(data[j]>data[i]){
                    len[i]=Math.max(len[i],len[j]+1);
                }
            }
            answer=Math.max(answer,len[i]);
        }

        bw.write(answer+"");

        bw.flush();
        bw.close();

    }
}
