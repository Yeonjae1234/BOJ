import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    ArrayList<Integer> route = new ArrayList<Integer>();

    public int solution(int start, int end, ArrayList<Integer>[] child, int[] parent){
        int answer =0;
        if(dfs(start,end,child,parent)==-1) return -1;
        else{
            return route.size()-1;
        }
    }

    public int dfs(int current,int end,ArrayList<Integer>[] child, int[] parent){
        route.add(current);
        if(current==end) return 1;

        for(int i:child[current]){
            if(route.contains(i)) continue;
            if(dfs(i,end,child,parent)==1) return 1;
        }
  
        if(parent[current]==0) return -1;
        else if(route.contains(parent[current])){
            route.remove(Integer.valueOf(current));
            return 0;
        }
        else return dfs(parent[current],end,child,parent);
       
    }


    public static void main(String[] args) throws Exception{
        Main main = new Main();
        int n, start, end,m,x,y;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        ArrayList<Integer>[] child = new ArrayList[n+1];
        for(int i=1;i<=n;i++){
            child[i]=new ArrayList<Integer>();
        }
        int[] parent = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(br.readLine());
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            child[x].add(y);
            parent[y]=x;
        }
        System.out.print(main.solution(start,end,child,parent));

    }
}
