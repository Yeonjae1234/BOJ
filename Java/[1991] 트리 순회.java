//  https://www.acmicpc.net/problem/1991

import java.io.*;
import java.util.*;

public class Main{

    static StringBuilder sb = new StringBuilder();

    public static void preTr(HashMap<Character, Character[]> tree, Character cur){
        sb.append(cur);
        Character[] child = tree.get(cur);
        if (child[0] != '.') {
            preTr(tree, child[0]);
        }
        if (child[1] != '.') {
            preTr(tree, child[1]);
        }
        return;
    }

    public static void inTr(HashMap<Character, Character[]> tree, Character cur){
        Character[] child = tree.get(cur);
        if (child[0] != '.') {
            inTr(tree, child[0]);
        }
        sb.append(cur);
        if (child[1] != '.') {
            inTr(tree, child[1]);
        }
    }

    public static void postTr(HashMap<Character, Character[]> tree, Character cur){
        Character[] child = tree.get(cur);
        if (child[0] != '.') {
            postTr(tree, child[0]);
        }

        if (child[1] != '.') {
            postTr(tree, child[1]);
        }
        sb.append(cur);
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        HashMap<Character, Character[]> tree = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            char key = str.charAt(0);
            char LC = str.charAt(2);
            char RC = str.charAt(4);
            Character[] temp = {LC, RC};
            tree.put(key, temp);
        }

        Deque<Character> stack = new ArrayDeque<>();


        preTr(tree, 'A');
        sb.append('\n');
        inTr(tree, 'A');
        sb.append('\n');
        postTr(tree, 'A');



        bw.write(String.valueOf(sb));
        bw.flush();


    }


}
