//  https://www.acmicpc.net/problem/1253

import java.io.*;
import java.util.*;

public class Main {

    public static int binarySearch(ArrayList<Integer> arr, int N, int count, int i) {
        int find = arr.get(i);
        for (int j = 0; j < N; j++) {
            if(j==i) j++;
            int l = j+1;
            if(l==i) l++;
            int r = N;
            int k;
            while (l < r) {
                k = (l + r) / 2;
                if(k==i) k--;
                int sum = arr.get(j) + arr.get(k);
                if(sum==find){
                    return ++count;
                }
                else if(sum<find){
                    l = k+1;
                    if(l==i) l++;
                }
                else{
                    r=k;
                }

            }

        }
        return count;
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> arr = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(arr);

        int count =0;
        for (int i = 0; i < N; i++) {
            count = binarySearch(arr, N, count, i);
        }

        bw.write(count + "");

        bw.flush();
        bw.close();

    }
}
