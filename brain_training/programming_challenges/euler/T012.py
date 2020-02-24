import math


def highly_divisible_triangular_number(end=500):
    def divisor_generator(n):
        large_divisors = []
        for i in range(1, int(math.sqrt(n) + 1)):
            if n % i == 0:
                yield i
                if i * i != n:
                    large_divisors.append(n / i)
        for divisor in reversed(large_divisors):
            yield divisor

    def divisor_number(n):
        return len(list(divisor_generator(n)))

    triangular_number = 1
    number = 2
    while True:
        if divisor_number(triangular_number) >= end:
            return triangular_number

        triangular_number += number
        number += 1
