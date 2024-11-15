import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] time;
        int start,end;
        int answer=0;
        ArrayList<int[]> lesson = new ArrayList<>();
        PriorityQueue<Integer> room = new PriorityQueue<>();
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            start=Integer.parseInt(st.nextToken());
            end=Integer.parseInt(st.nextToken());
            time = new int[] {start,end};
            lesson.add(time);
        }
        Collections.sort(lesson,(a,b)->Integer.compare(a[0],b[0]));
        for(int[] i:lesson){
            while(!room.isEmpty()){
                if(room.peek()<=i[0]){
                    room.poll();
                }
                else break;
            }
            room.add(i[1]);
            answer=Integer.max(answer,room.size());
        }
        System.out.println(answer);
    }
}
