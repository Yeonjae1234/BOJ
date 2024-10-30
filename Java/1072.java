import java.util.Scanner;

public class Main {
    public int solution(int x, int y){
        int z = (int)((long)y * 100 / x); 
        if(z >= 99) return -1; 

        int left = 0;
        int right = x;
        int answer = -1;

        while(left <= right) {
            int mid = (left + right) / 2;
            int newZ = (int)(((long)y + mid) * 100 / (x + mid)); 

            if(newZ > z) { 
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Main M = new Main();
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        System.out.println(M.solution(x, y));
    }
}
