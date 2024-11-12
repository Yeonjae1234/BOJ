import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public int solution(int[] level) {
        int count = 0;
        for(int i = level.length-2;i>=0;i--){
            while(level[i]>= level[i+1]){
                level[i]--;
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) throws Exception{
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] level = new int[N];
        for(int i=0;i<N;i++){
            int x = Integer.parseInt(br.readLine());
            level[i] = x;
        }

        System.out.println(main.solution(level));
    }
}
