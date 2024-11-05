import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public int solution(int I, int cx, int cy, int dx, int dy){
        
        int[][] chess = new int[I][I];  // 체스판 생성
        int count = 0;  // 이동 횟수
        chess[cx][cy]=1;  // 현재 위치의 이동 횟수 값을 1로 시작. (나중에 return 할 때 -1)
        while(true){
            count++;  // 이동 횟수 탐색 위한 변수
            
            // 전체 체스판 탐색. count의 값을 활용하여 탐색 범위 줄여줌.
            for(int i=Math.max(cx-(count)*2,0);i<Math.min(cx+(count)*2+1,I);i++){
                for(int j=Math.max(cy-(count)*2,0);j<Math.min(cy+(count)*2+1,I);j++){
                    if(i==dx&&j==dy&&chess[i][j]>0) return chess[i][j]-1;  // 최종 목적지에 이동 횟수 계산이 완료된 상태라면 종료
                    
                    // 현재 이동 횟수로 방문할 수 있는 칸 탐색
                    if(chess[i][j]==count){
                        // 해당 칸에서 다음으로 이동할 수 있는 칸에 값 표시
                        input(count+1,i-2,j-1,chess,I);
                        input(count+1,i-2,j+1,chess,I);
                        input(count+1,i-1,j-2,chess,I);
                        input(count+1,i-1,j+2,chess,I);
                        input(count+1,i+1,j-2,chess,I);
                        input(count+1,i+1,j+2,chess,I);
                        input(count+1,i+2,j-1,chess,I);
                        input(count+1,i+2,j+1,chess,I);
                    }
                }
            }
        }
    }

    public int input(int count,int x,int y,int[][] chess,int I){
        if(x>=0&&y>=0&&x<I&&y<I){ // 값 입력하려고 하는 칸이 체스판 벗어나지 않으면
            if(chess[x][y]>0) return 0;  // 이미 탐색한 칸이라면 재방문 필요 x. 값 갱신하지 않음
            else{
                chess[x][y]=count;  // 이동 횟수 저장
                return 0;
            }
        }
        return 0;
    }

    public static void main(String[] args) throws Exception{
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. 테스트 케이스 수
        int t = Integer.parseInt(br.readLine());

        for(int i=0;i<t;i++){
            // 2. 체스판 한 변의 길이 I
            int I = Integer.parseInt(br.readLine());

            // 3. 현재 나이트가 있는 칸
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cx = Integer.parseInt(st.nextToken());
            int cy = Integer.parseInt(st.nextToken());

            // 4. 나이트가 이동하려고 하는 칸
            st = new StringTokenizer(br.readLine());
            int dx = Integer.parseInt(st.nextToken());
            int dy = Integer.parseInt(st.nextToken());

            System.out.println(main.solution(I,cx,cy,dx,dy));
        }
    }
}
