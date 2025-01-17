// https://www.acmicpc.net/problem/1389

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

        int[][] frd = new int[N+1][N+1];
        for(int i=1;i<N+1;i++){
            for(int j=1;j<N+1;j++){
                frd[i][j] = 999;
            }
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            frd[x][y]=1;
            frd[y][x]=1;
        }

        boolean flag = true;
        while(flag){
            flag=false;
            for(int i=1;i<N+1;i++){
                for(int j=1;j<N+1;j++){
                    if(frd[i][j]>0){
                        for(int k=1;k<N+1;k++){
                            if(frd[j][k]+frd[i][j]<frd[i][k]){
                                flag=true;
                                frd[i][k] = frd[j][k]+frd[i][j];
                                frd[k][i] = frd[j][k]+frd[i][j];
                            }
                        }
                    }
                }
            }
        }

        int[] kb = new int[N+1];
        int min = 10000;
        int result=0;
        for(int i=1;i<N+1;i++){
            for(int j=1;j<N+1;j++){
                kb[i]+=frd[i][j];
            }
            if(min>kb[i]){
                min=kb[i];
                result=i;
            }
        }

        bw.write(result+"");

        bw.flush();
        bw.close();

    }
}
