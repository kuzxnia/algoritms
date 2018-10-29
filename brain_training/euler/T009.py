# A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
# a2 + b2 = c2
# For example, 32 + 42 = 9 + 16 = 25 = 52.
# There exists exactly one Pythagorean triplet for which a + b + c = 1000.
# Find the product abc.

import math


def spt(sum):
    for a in range(3, 1000):
        for b in range(a + 1, 1000):
            c = math.sqrt(a**2 + b**2)
            if c.is_integer() and (a + b + c) == sum:
                return int(a * b * c)