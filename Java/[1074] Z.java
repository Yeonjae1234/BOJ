//  https://www.acmicpc.net/problem/1074

import java.io.*;
import java.util.*;
public class Main {

    public static int dfs(int size,int r, int c){
        if(size==1){
            return 0;
        }
        size/=2;
        if(r>=0 && r<size){
            if(c>=0 && c<size){
                return dfs(size,r,c);
            }
            else{
                return (size)*(size)*1+dfs(size,r,c-size);
            }
        }
        else{
            if(c>=0 && c<size){
                return (size)*(size)*2+dfs(size,r-size,c);
            }
            else{
                return (size)*(size)*3+dfs(size,r-size,c-size);
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int size = 1<<N;

        int answer = dfs(size, r, c);

        bw.write(String.valueOf(answer));
        bw.flush();



    }


}
