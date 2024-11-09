import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{

    public long solution(long cats){
        long count = 0;
        long step = cats;
        while(step>0){
            step/=2;
            count++;
        }
        if(cats==(long)Math.pow(2,count-1)){
            return count;
        }
        else return count+1;
    }


    public static void main(String[] args) throws Exception{
        Main main = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long cats = Long.parseLong(br.readLine());
        System.out.println(main.solution(cats));

    }
}

