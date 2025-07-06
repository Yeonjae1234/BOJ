// https://www.acmicpc.net/problem/10814

import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        // 회원의 수 N
        int N = Integer.parseInt(br.readLine());

        // 나이를 index로 하는 member 배열
        LinkedList<String>[] member = new LinkedList[201];

        // 배열의 각 칸은 List로 생성
        for (int i = 1; i < 201; i++) {
            member[i] = new LinkedList<String>();
        }

        // 나이에 해당하는 인덱스의 칸에 이름을 add
        // 가입한 순서대로 저장되게 된다
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            member[age].add(name);
        }

        // 나이 인덱스 순서대로 출력
        // 저장된 값이 없는 나이는 건너뛰고, 해당 나이에서 저장된 순서대로 출력하면 가입한 순서대로 출력됨
        for (int i = 1; i < 201; i++) {
            if (!member[i].isEmpty()){
                for(String n : member[i]){
                    bw.write(i+" "+n+"\n");
                }
            }
        }
        bw.flush();

    }
}
