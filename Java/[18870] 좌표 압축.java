

import java.io.*;
import java.util.*;

public class Main{


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];
        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0]-b[0]);

        for(int i=0;i<N;i++){
            arr[i][0] = Integer.parseInt(st.nextToken());
            int[] temp = {arr[i][0],i};
            pq.add(temp);
        }

        int rank=-1;
        int prev=Integer.MAX_VALUE;
        while(!pq.isEmpty()){
            int[] temp = pq.poll();
            int index = temp[1];
            if(prev!=temp[0]){
                rank++;
            }
            prev = temp[0];
            arr[index][1] = rank;
        }

        for(int i=0;i<N;i++){
            sb.append(arr[i][1]).append(" ");
        }


        bw.write(String.valueOf(sb));
        bw.flush();


    }


}
