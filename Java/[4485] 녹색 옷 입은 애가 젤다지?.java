//  https://www.acmicpc.net/problem/4485

import java.io.*;
import java.util.*;

public class Main {

    public static int solution(int[][] map, int size) {
        Queue<int[]> update = new LinkedList<>();
        int[][] value = new int[size][size];
        int[] x = {-1,1,0,0};
        int[] y = {0,0,-1,1};

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                value[i][j] = 99999;
            }
        }

        value[0][0] = map[0][0];
        update.add(new int[]{0,0});
        while (!update.isEmpty()) {
            int[] index = update.poll();
            for(int i=0;i<4;i++){

                if(index[0]+x[i]<0||index[0]+x[i]>=size||index[1]+y[i]<0||index[1]+y[i]>=size) continue;
                int newValue = map[index[0] + x[i]][index[1] + y[i]]+value[index[0]][index[1]];
                if (newValue < value[index[0] + x[i]][index[1] + y[i]]) {
                    update.add(new int[]{index[0] + x[i],index[1] + y[i]});
                    value[index[0] + x[i]][index[1] + y[i]] = newValue;
                }
            }

        }
        return value[size-1][size-1];

    }



    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int count = 0;

        while (true) {
            count++;
            int size = Integer.parseInt(br.readLine());
            if(size == 0) break;

            int[][] map = new int[size][size];
            for (int i = 0; i < size; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < size; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            String sf = String.format("Problem %d: %d\n",count,solution(map,size));

            bw.write(sf);

        }



        bw.flush();
        bw.close();

    }
}
