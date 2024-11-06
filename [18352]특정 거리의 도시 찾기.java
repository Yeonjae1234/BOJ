import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public int solution(int K,int X, ArrayList<Integer>[] graph){
        int N = graph.length;
        int[] cost = new int[N];
        ArrayList<Integer> result = new ArrayList<>();
        Queue<Integer> search = new LinkedList<>();
        int current;
        search.add(X);
        while(!search.isEmpty()){
            current=search.poll();
            for(int i:graph[current]){
                if(cost[i]==0 || cost[i]>cost[current]+1){
                    if(i==X) continue;
                    cost[i]=cost[current]+1;
                    search.add(i);
                }
            }
        }
        for(int i=1;i<N;i++){
            if(cost[i]==K){
               result.add(i);
            }
        }
        if(result.isEmpty()){
            System.out.println(-1);
            return 0;
        }
        else{
            for(int i:result){
                System.out.println(i);
            }
        }
        return 0;
    }



    public static void main(String[] args) throws Exception{
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 1. N-도시의 개수, M-도로의 개수, K-거리 정보, X-출발 도시 번호
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int start, end;

        ArrayList<Integer>[] graph = new ArrayList[N+1];
        for(int i=1;i<=N;i++) {
            graph[i] = new ArrayList<>();
        }
        // 2. 간선 정보 입력
        for(int i=0;i<M;i++) {
            st=new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            graph[start].add(end);
        }
        main.solution(K,X,graph);

    }
}
