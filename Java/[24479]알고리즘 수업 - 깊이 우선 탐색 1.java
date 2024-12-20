import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


public class Main {
        int count=1;
        public int dfs(int[] V,ArrayList<Integer>[] E,int R){
           V[R]=count++;
           for(int i:E[R]){
               if(V[i]==0){
                   dfs(V,E,i);
               }
           }
           return 0;
        }

        public static void main(String[] args) throws Exception{
            Main main = new Main();
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            ArrayList<Integer>[] E = new ArrayList[N+1];
            for(int i=0;i<=N;i++){
                E[i]=new ArrayList<>();
            }
            int[] V = new int[N+1];
            for(int i=0;i<M;i++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                E[x].add(y);
                E[y].add(x);
            }

            for(int i=0;i<N+1;i++){
                Collections.sort(E[i]);
            }

            main.dfs(V,E,R);
            for(int i=1;i<N+1;i++) {
                System.out.println(V[i]);
            }
        }

}
