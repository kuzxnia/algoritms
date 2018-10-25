class Solution:
    def myPow(self, x, n):
        result = 1
        if n < 0:
            n = -n
            x = 1 / x
        while n:
            if n % 2 == 1:
                result = result * x
            n = n // 2
            x = x * x
        return result
