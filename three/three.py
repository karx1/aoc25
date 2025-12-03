import sys
from functools import cache

def maxJoltage(line):
    @cache
    def helper(i, total):
        # 2 choices: take or skip
        if total >= 10 ** 2: return -1
        if i == len(line): 
            return total 

        take = helper(i + 1, total * 10 + (ord(line[i]) - ord('0')))
        skip = helper(i + 1, total)
        
        return max(take, skip)
    
    return helper(0, 0)


res = 0
for line in sys.stdin:
    m = maxJoltage(line)
    print(m)
    res += m

print(res)
