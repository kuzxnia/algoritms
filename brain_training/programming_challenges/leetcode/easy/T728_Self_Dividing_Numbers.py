import math


class Solution:
    def selfDividingNumbers(self, left, right):
        def _is_divisible(n):
            for i in range(math.ceil(math.log(n, 10)) - 1, -1, -1):
                divisor = ((n // (10**i)) % 10)
                if divisor == 0 or n % divisor != 0:
                    return False

            return True

        return [x for x in range(left, right + 1) if _is_divisible(x)]