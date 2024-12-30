// https://www.acmicpc.net/problem/7785

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n;
        n = Integer.parseInt(br.readLine());
        PriorityQueue<String> enterQ = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<String> leaveQ = new PriorityQueue<>(Collections.reverseOrder());

        String name;
        String info;
        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            name = st.nextToken();
            info = st.nextToken();
            if(info.equals("enter")){
                enterQ.add(name);
            }
            else{
                leaveQ.add(name);
            }
        }

        while(!leaveQ.isEmpty()){
            if(!leaveQ.peek().equals(enterQ.peek())){
                bw.write(enterQ.poll()+"\n");
            }
            else{
                leaveQ.poll();
                enterQ.poll();
            }
        }
        while(!enterQ.isEmpty()){
            bw.write(enterQ.poll()+"\n");
        }

        bw.flush();
        bw.close();

    }
}
