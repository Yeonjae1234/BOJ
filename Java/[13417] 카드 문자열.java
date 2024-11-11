import java.io.*;
import java.util.*;



public class Main {

    public String solution(Queue<Character> str){
        Deque<Character> sentence = new LinkedList<>();
        char ch;
        sentence.add(str.poll());
        while(!str.isEmpty()){
            ch=str.poll();
            if(ch> sentence.peekFirst()) sentence.addLast(ch);
            else sentence.addFirst(ch);
        }
        String answer = "";
        for(Character c : sentence){
            answer+=c;
        }
        return answer;
    }

    public static void main(String[] args) throws Exception{
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        Queue<Character> str;
        for(int i = 0;i<T;i++){
            str = new LinkedList<>();
            int N = Integer.parseInt(br.readLine());
            st=new StringTokenizer(br.readLine());
            for(int k=0;k<N;k++){
                char ch = st.nextToken().charAt(0);
                str.add(ch);
            }
            System.out.println(main.solution(str));
        }
    }

}
