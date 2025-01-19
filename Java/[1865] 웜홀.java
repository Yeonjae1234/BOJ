// https://www.acmicpc.net/problem/1865

import java.io.*;
import java.util.*;

public class Main {

    static final double INF = Double.POSITIVE_INFINITY;

    public static String solution(double[][] map,int N){
        boolean flag = true;

        while(flag){
            flag = false;
            for(int j=0;j<N;j++){
                for(int k=0;k<N;k++){
                    for(int l=0;l<N;l++){
                        double x = map[j][k]+map[k][l];
                        if(x<map[j][l]){
                            flag = true;
                            map[j][l]=x;
                        }
                    }
                }
                if(map[j][j]<0){
                    return "YES";
                }
            }
        }
        return "NO";
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int TC = Integer.parseInt(br.readLine());

        for(int i=0;i<TC;i++){
            int N, M, W;
            st = new StringTokenizer(br.readLine());
            N=Integer.parseInt(st.nextToken());
            M=Integer.parseInt(st.nextToken());
            W=Integer.parseInt(st.nextToken());

            double[][] map = new double[N][N];

            for(int j=0;j<N;j++){
                for(int k=0;k<N;k++){
                    map[j][k] = INF;
                }
            }

            for(int j=0;j<M;j++){
                st = new StringTokenizer(br.readLine());
                int x,y;
                double value;

                x=Integer.parseInt(st.nextToken());
                y=Integer.parseInt(st.nextToken());

                value = Double.parseDouble(st.nextToken());

                map[x-1][y-1] = Double.min(map[x-1][y-1],value);
                map[y-1][x-1] = Double.min(map[y-1][x-1],value);

            }

            for(int j=0;j<W;j++){
                st = new StringTokenizer(br.readLine());
                int x,y;

                x=Integer.parseInt(st.nextToken());
                y=Integer.parseInt(st.nextToken());

                map[x-1][y-1] = Double.min(map[x-1][y-1],(-1)*Double.parseDouble(st.nextToken()));
            }

            bw.write(solution(map,N)+"\n");


        }


        bw.flush();
        bw.close();

    }
}
