import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {

    public int soultion(int[] sensor,int N,int K){
        int answer=0;
        int[] dist = new int[N-1];
        for(int i=0;i<N-1;i++){
            dist[i]=sensor[i+1]-sensor[i];
        }

        Arrays.sort(dist);

        for(int i=0;i<N-1-(K-1);i++){
            answer+=dist[i];
        }
        return answer;
    }

    public static void main(String[] args) throws Exception{
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        int[] sensor = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            sensor[i]=Integer.parseInt(st.nextToken());
        }

        Arrays.sort(sensor);

        System.out.println(main.soultion(sensor,N,K));
    }
}
