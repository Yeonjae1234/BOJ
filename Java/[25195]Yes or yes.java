import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public void solution(int[] fan, ArrayList<Integer>[] graph) {
        int result = dfs(1,fan,graph);
        if(result==1) System.out.println("Yes");
        else System.out.println("yes");
    }

    int dfs(int current, int[] fan, ArrayList<Integer>[] graph){
        if(fan[current]==1) return 1;
        int result = 0;
        for(int i:graph[current]){
            result = dfs(i,fan,graph);
            if(result==0) return 0;
        }
        if(result==1) return 1;
        else return 0;
    }

    public static void main(String[] args) throws Exception{
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 정점 개수 N. 간선 개수 M
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] graph = new ArrayList[N+1];
        for(int i=1;i<=N;i++){
            graph[i] = new ArrayList<>();
        }

        // 간선 정보
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
        }

        // 팬클럽 정보
        int[] fan = new int[N+1];
        int S = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<S;i++){
            int s = Integer.parseInt(st.nextToken());
            fan[s]=1;
        }
        
        main.solution(fan,graph);

    }
}
