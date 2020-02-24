def sumMultiplesOf3or5(scope):
    return sum([x for x in range(scope) if x % 3 == 0 or x % 5 == 0])
