import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    public static int solution(int[] box,int n) {
        int[] count = new int[n];
        int answer =-1;
        for(int i=0;i<n;i++){
            count[i]=1;
            for(int j=0;j<i;j++){
                if(box[i]>box[j]){
                    count[i]=Math.max(count[i],count[j]+1);
                }
            }
            answer=Math.max(answer,count[i]);
        }
        return answer;
    }




    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] box = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            box[i]=Integer.parseInt(st.nextToken());
        }
        bw.write(solution(box,n)+"");
        bw.flush();
        bw.close();

    }
}
