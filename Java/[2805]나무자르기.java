import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{

    public int solution(int[] tree,int M){
        int max = Arrays.stream(tree).max().getAsInt();
        long left = max-M-1;
        long right = max;
        long mid,sum,H =0;
        while(left<right){
            mid = ((long)left+(long)right)/2;
            sum=0;
            for (int i:tree){
                if(i<mid) continue;
                sum+=i-mid;
                if(sum>=M){
                    H=mid;
                    left=mid+1;
                    break;
                }
            }
            if(sum<M){
                right=mid;
            }
        }
        return (int)H;
    }


    public static void main(String[] args) throws Exception{
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] tree = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            tree[i]=Integer.parseInt(st.nextToken());
        }

        System.out.println(main.solution(tree,M));

    }
}

