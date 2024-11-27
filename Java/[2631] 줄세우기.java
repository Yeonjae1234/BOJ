import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static int solution(int[] kid,int N) {
        int[] count = new int[N];
        int answer = -1;
        for(int i=0;i<N;i++){
            count[i] = 1;
            for(int j=0;j<i;j++){
                if(kid[i]>kid[j]){
                    count[i]=Math.max(count[i],count[j]+1);
                }
            }
            answer = Math.max(answer,count[i]);
        }

        return N-answer;
    }




    public static void main(String[] args) throws Exception {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

       int N = Integer.parseInt(br.readLine());
       int[] kid = new int[N];
       for(int i=0;i<N;i++){
           kid[i] = Integer.parseInt(br.readLine());
       }
       bw.write(solution(kid,N)+"");
       bw.flush();
       bw.close();

    }
}
