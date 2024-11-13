import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main {

    public int solution(int N) {
        int count = 0;
        int find =1;
        while(N>find){
            find*=2;
            count++;
        }
        if(find==N) return 8+count+2;
        else return 8+count+1;
    }

    public static void main(String[] args) throws Exception{
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());


        System.out.println(main.solution(N));
    }
}
