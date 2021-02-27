def path(num):
    end = 0
    s = 0
    R=[]
    R.append(num)
    max = 0
    min = 0
    s = num
    r = [0]*4
    while end != 6174:
        r[0] = s % 10
        r[1] = s // 10 % 10 #Python取整是'//' 
        r[2] = s // 100 % 10
        r[3] = s // 1000
        # 插入排序
        # for i in range(4):
        #     k = i-1
        #     temp = r[i]
        #     while k>=0 and r[k] > temp:
        #         r[k+1] = r[k]
        #         k = k-1
        #     r[k+1] = temp
        r.sort()
        max = 1000 * r[3] + 100 * r[2] + 10 * r[1] + r[0]
        min = 1000 * r[0] + 100 * r[1] + 10 * r[2] + r[3]
        end = max - min
        if end == 0:
            break
        R.append("->")
        R.append(end)
        s = end
    for i in R:
        print (i,end = '')

path(8889)
    