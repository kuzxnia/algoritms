from math import log

def benford_law(base, n):
    return log(n + 1, base) - log(n, base)
