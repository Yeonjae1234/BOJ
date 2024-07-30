while 1:
    a=input()
    if a == '0':
        break
    b=list(a)
    c=list(reversed(b))
    if b==c:
        print("yes")
    else:
        print("no")