from functools import reduce


def lcmm():
    def _gcd(a, b):
        while b:
            a, b = b, a % b
        return a

    def _lcm(a, b):
        return a * b // _gcd(a, b)

    return reduce(_lcm, range(1, 21))
