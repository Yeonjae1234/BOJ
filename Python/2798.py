n, m = map(int, input().split( ))
a = list(map(int, input().split( )))
a.sort()
alen = len(a)
sum=0
count=0
x=0

for i in range(alen-2):
    for j in range(i+1,alen-1):
        for k in range(j+1,alen):
            x=a[i]+a[j]+a[k]
            if x > m:
                break
            elif x>sum:
                sum=x

print(sum)
