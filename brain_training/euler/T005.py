# 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
# What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?

from functools import reduce


def smallest_multiple():
    def _gcd(a, b):
        while b:
            a, b = b, a % b
        return a

    def _lcm(a, b):
        return a * b // _gcd(a, b)

    return reduce(_lcm, range(1, 21))
