//  https://www.acmicpc.net/problem/2116

import java.io.*;
import java.util.*;



public class Main {

    public static int solution(int[][] dice){
        int answer=0;
        for(int i=1;i<=6;i++){
            int k = calc(dice,i);
            if(answer<k)
                answer=k;
        }
        return answer;
    }

    public static int calc(int[][] dice,int top){
        int[] pair = new int[7];
        int sum=0;
        for(int i=0;i<dice.length;i++) {
            pair[dice[i][0]] = dice[i][5];
            pair[dice[i][1]] = dice[i][3];
            pair[dice[i][2]] = dice[i][4];
            pair[dice[i][3]] = dice[i][1];
            pair[dice[i][4]] = dice[i][2];
            pair[dice[i][5]] = dice[i][0];

            int newTop = pair[top];
            for(int j=6;j>0;j--){
                if(j==top||j==newTop) continue;
                sum+=j;
                break;
            }
            top=newTop;
        }
        return sum;
    }


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] dice = new int[N][6];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<6;j++){
                dice[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        System.out.println(solution(dice));
    }

}
