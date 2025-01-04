class Solution:
    def minFlips(self, a: int, b: int, c: int) -> int:
        a = bin(a)[2:]
        b = bin(b)[2:]
        c = bin(c)[2:]
        ml = max(len(a), len(b), len(c))
        a = a.zfill(ml)
        b = b.zfill(ml)
        c = c.zfill(ml)
        count = 0
        for i in range(ml):
            if c[i]=='0':
                count+=int(a[i])+int(b[i])
            elif a[i]=='0' and b[i]=='0':
                count+=1
        return count