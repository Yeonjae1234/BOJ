// https://www.acmicpc.net/problem/9655

import java.io.*;
import java.util.*;

public class Main {



    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        if(n%2==0){
            bw.write("CY");
        }
        else{
            bw.write("SK");
        }

        bw.flush();
        bw.close();

    }
}
