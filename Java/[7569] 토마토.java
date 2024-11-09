import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {

    public int solution(Queue<int[]> riped, int[][][] tomato,int H, int N, int M) {
        int days=0;
        int[] current;
        while(!riped.isEmpty()) {
            current = riped.poll();
            days=tomato[current[0]][current[1]][current[2]];
            between(current,riped,tomato, days,H,N,M);
        }
        for (int[][] h : tomato) {
            for (int[] n : h) {
                for (int m : n) {
                    if(m==0) return -1;
                }
            }
        }
        return days-1;
    }

    public void between(int[] current, Queue<int[]> riped, int[][][] tomato,int days,int H, int N, int M){
        int[] x={-1,1,0,0,0,0};
        int[] y={0,0,-1,1,0,0};
        int[] z={0,0,0,0,-1,1};
        int[] e;
        for(int i = 0;i<6;i++){
            if(current[0]+z[i]<0||current[0]+z[i]>=H||current[1]+y[i]<0||current[1]+y[i]>=N||current[2]+x[i]<0||current[2]+x[i]>=M) continue;
            if(tomato[current[0]+z[i]][current[1]+y[i]][current[2]+x[i]]==0){
                tomato[current[0]+z[i]][current[1]+y[i]][current[2]+x[i]] = days+1;
                e = new int[]{current[0]+z[i],current[1]+y[i],current[2]+x[i]};
                riped.add(e);
            }
        }
    }



    public static void main(String[] args) throws Exception{
        Main main = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        Queue<int[]> riped = new LinkedList<>();
        int[][][] tomato = new int[H][N][M];

        int[] e;

        for(int h=0;h<H;h++){
            for(int n=0;n<N;n++){
                st=new StringTokenizer(br.readLine());
                for(int m=0;m<M;m++){
                    int input = Integer.parseInt(st.nextToken());
                    tomato[h][n][m]=input;
                    if (input==1){
                        e = new int[]{h,n,m};
                        riped.add(e);
                    }
                }
            }
        }

        System.out.println(main.solution(riped, tomato,H,N,M));

    }
}
