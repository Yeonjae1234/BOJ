
def asce(alist):
    for i in range(1,9):
        if i!=alist[i-1]:
            return "mixed"
    return "ascending"

def desc(alist):
    for i in range(8,0,-1):
        if i!=alist[8-i]:
            return "mixed"
    return "descending"

a = list(map(int, input().split(' ')))
if a[0]==1:
    print(asce(a))
elif a[0]==8:
    print(desc(a))
else :
    print("mixed")