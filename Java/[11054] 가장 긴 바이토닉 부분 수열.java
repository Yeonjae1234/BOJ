//  https://www.acmicpc.net/problem/11054

import java.io.*;
import java.util.*;



public class Main {

    public static int solution(int[] arr, int N){
        int[] asc = new int[N];
        int[] desc = new int[N];
        int answer = -1;

        for(int i=0;i<N;i++){
            asc[i]=1;
            for(int j=0;j<i;j++){
                if(arr[i]>arr[j]){
                    asc[i]=Math.max(asc[i],asc[j]+1);
                }
            }
        }

        for(int i=N-1;i>=0;i--){
            desc[i]=1;
            for(int j=N-1;j>i;j--){
                if(arr[i]>arr[j]){
                    desc[i]=Math.max(desc[i],desc[j]+1);
                }
            }
            answer = Math.max(answer,asc[i]+desc[i]);
        }
        return answer-1;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        bw.write(solution(arr,N)+"");
        bw.flush();
        bw.close();
    }

}
