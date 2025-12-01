
f = open("./Advent_of_code/2025/day1.txt","r").readlines()

current = 50
out = 0

for i in f:
    # print(out, current,i[:-1])
    if i[0] == "L":
        new = (current + (-1 * int(i[1:-1]))) % 100
        if new > current and new != 0 and current != 0:
            out += 1
    elif i[0] == "R":
        new = (current + int(i[1:-1])) % 100
        if new < current and new != 0 and current != 0:
            out +=1 
    current = new
    if current == 0:
        out+= 1
    out += (int(i[1:-1]) // 100)



print(out)
