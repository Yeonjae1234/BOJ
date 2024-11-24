import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    public static int solution(int[] A,int N) {
        int[] sum = new int[N];
        int answer =-1;
        
        for(int i=0;i<N;i++){
            sum[i] = A[i];
            for(int j=0;j<i;j++){
                if(A[i]>A[j]){
                    sum[i] = Math.max(sum[i],sum[j]+A[i]);
                }
            }
            answer=Math.max(answer,sum[i]);
        }

        return answer;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            A[i]=Integer.parseInt(st.nextToken());
        }
        System.out.println(solution(A,N));
    }
}
