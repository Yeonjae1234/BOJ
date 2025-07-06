// https://www.acmicpc.net/problem/11650

import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int x, y;

        // x 좌표를 인덱스로 하는 배열 생성
        // 배열의 자료형은 PriorityQueue
        // y 좌표의 값을 작은 순서로 출력하기 위함
        PriorityQueue<Integer>[] arr = new PriorityQueue[200001];
        for (int i = 0; i < 200001; i++) {
            arr[i] = new PriorityQueue<>();
        }


        // x값의 최소값인 -100,000 을 0 인덱스로 저장하기 위해 x값에 +100,000을 한 값을 기준으로 배열에 저장
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            arr[x + 100000].add(y);
        }

        for (int i = 0; i < 200001; i++) {
            x = i - 100000;
            while (!arr[i].isEmpty()) {
                y = arr[i].poll();
                bw.write(x + " " + y + "\n");
            }
        }
        bw.flush();
    }
}
