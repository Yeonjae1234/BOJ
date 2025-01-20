//  https://www.acmicpc.net/problem/2457

import java.io.*;
import java.util.*;

public class Main {

    public static int solution(PriorityQueue<Date> fList) {
        int[] TS = {3, 1};
        int[] TE = {0, 0};
        int[] FE = {11, 30};

        int count = 0;

        Date index = null;
        while (!fList.isEmpty()) {
            if (compareDate(fList.peek().start, TS) <= 0) {
                index = fList.poll();
                if (compareDate(index.end, TE) > 0) {
                    TE = index.end;
                }
            } else {
                if (index == null) return 0;
                else if (compareDate(TE, FE) > 0) return ++count;
                else {
                    count++;
                    TS = TE;
                    index = null;
                }
            }
        }
        if (compareDate(TE, FE) > 0) return ++count;
        else return 0;
    }

    public static int compareDate(int[] d1, int[] d2){
        if(d1[0]<d2[0]){
            return d1[0]-d2[0];
        }
        else if(d1[0] == d2[0]){
            return d1[1] - d2[1];
        }
        else return d1[0] - d2[0];
    }

    public static class Date implements Comparable<Date>{
        int[] start = new int[2];
        int[] end = new int[2];

        @Override
        public int compareTo(Date o){
            return compareDate(this.start,o.start);
        }

        public Date(int sm, int sd, int em, int ed){
            this.start[0] = sm;
            this.start[1] = sd;
            this.end[0] = em;
            this.end[1] = ed;

            if(compareDate(start,end)>0){
                end[0]+=12;

            }

        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Date> fList = new PriorityQueue<>();

        for(int i=0;i<N;i++){
            int m1, m2, d1, d2;
            st = new StringTokenizer(br.readLine());
            m1 = Integer.parseInt(st.nextToken());
            d1 = Integer.parseInt(st.nextToken());
            m2 = Integer.parseInt(st.nextToken());
            d2 = Integer.parseInt(st.nextToken());
            fList.add(new Date(m1,d1,m2,d2));
        }

        bw.write(solution(fList)+"\n");

        bw.flush();
        bw.close();

    }
}
