n=int(input())
a=[[] for _ in range(51)]

for i in range(n):
    word=input()
    k=len(word)
    if word not in a[k]:
        a[k].append(word)

for i in range(1,51):
    a[i].sort()
    for j in a[i]:
        print(j)