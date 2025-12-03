import sys

def maxJoltage(line):
    # greedy: for each position, pick the largest digit we can
    # while leaving enough digits for remaining picks.
    n = len(line)
    res = 0
    start = 0
    for picks_left in range(12, 0, -1):
        # we must pick the highest digit from indices [start .. n - picks_left]
        best_digit = -1
        best_pos = -1
        end_inclusive = n - picks_left
        for pos in range(start, end_inclusive + 1):
            d = ord(line[pos]) - ord('0')
            if d > best_digit:
                best_digit = d
                best_pos = pos
                # early exit: can't beat 9
                if best_digit == 9:
                    break
        res *= 10
        res += best_digit
        start = best_pos + 1

    return res

res = 0
for raw in sys.stdin:
    line = raw.strip()
    if not line: continue

    m = maxJoltage(line)
    print(m)
    res += m

print(res)

