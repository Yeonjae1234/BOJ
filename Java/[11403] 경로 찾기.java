//  https://www.acmicpc.net/problem/11403

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        boolean flag = true;
        while(flag){
            flag = false;
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(map[i][j]==1){
                        for(int k=0;k<N;k++){
                            if(map[j][k]==1){
                                if(map[i][k]==0){
                                    map[i][k]=1;
                                    flag=true;
                                }
                            }
                        }
                    }
                }
            }
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                bw.write(map[i][j]+" ");
            }
            bw.write("\n");
        }


        bw.flush();
        bw.close();

    }
}
