import java.io.*;

public class Main {
    public long solution(long N){
        long x = (long)Math.sqrt(2*N);
        if((x*(x+1)<=2*N)&&((x+1)*(x+2)>2*N)){
            return x;
        }
        else return x-1;
    }

    public static void main(String[] args) throws Exception{
        Main M = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i=0;i<T;i++) {
            long N = Long.parseLong(br.readLine());
            System.out.println(M.solution(N));
        }
    }
}
