import math


def spt(sum):
    for a in range(3, 1000):
        for b in range(a + 1, 1000):
            c = math.sqrt(a**2 + b**2)
            if c.is_integer() and (a + b + c) == sum:
                return int(a * b * c)