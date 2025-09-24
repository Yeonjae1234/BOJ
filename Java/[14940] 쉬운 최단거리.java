//  https://www.acmicpc.net/problem/14940


import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];
        int[][] result = new int[n][m];
        int[] start = new int[2];
        for(int i=0;i<n;i++){
            Arrays.fill(result[i],-1);
        }
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==2){
                    start[0]=i;
                    start[1]=j;
                }
                else if(map[i][j]==0){
                    result[i][j]=0;
                }
            }
        }
        
        Queue<int[]> q = new ArrayDeque<>();
        int[] dirX = {1,-1,0,0};
        int[] dirY = {0,0,1,-1};
        q.add(start);
        result[start[0]][start[1]]=0;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int curCost = result[cur[0]][cur[1]];
            for(int i=0;i<4;i++){
                int r = cur[0]+dirY[i];
                int c = cur[1]+dirX[i];
                if(r<0||r>=n||c<0||c>=m){
                    continue;
                }
                if (map[r][c] == 0) {
                    result[r][c] = 0;
                    continue;
                }
                if (result[r][c] == -1) {
                    result[r][c] = curCost + 1;
                    int[] temp = {r, c};
                    q.add(temp);
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                sb.append(result[i][j]).append(" ");
            }
            sb.append("\n");
        }
        bw.write(String.valueOf(sb));
        bw.flush();
    }
}
