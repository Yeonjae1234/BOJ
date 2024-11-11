import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main {

    public int solution(int money) {
        int two = 0, five = 0;

        if (money >= 5) {
            five += money / 5;
            money %= 5;
        }
        if (money >= 2) {
            two += money / 2;
            money %= 2;
        }
        if (money != 0) {
            if (five > 0) {
                five--;
                money += 5;
                two += money / 2;

            } else {
                return -1;
            }
        }
        return two + five;
    }

    public static void main(String[] args) throws Exception{
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int money = Integer.parseInt(br.readLine());
        System.out.println(main.solution(money));
    }
}
