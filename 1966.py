# N : 문서의 개수
# M : 궁금한 문서의 인덱스
# N개의 문서의 중요도

case = int(input())

for i in range(case):
    N, M = map(int, input().split())
    Q = list(map(int, input().split()))
    count = 0
    while len(Q)!=0:
        if Q[0]==max(Q):
            count+=1
            if M == 0:
                print(count)
                break
        else:
            Q.append(Q[0])
            if M == 0:
                M=len(Q)-1
        del Q[0]
        M-=1


