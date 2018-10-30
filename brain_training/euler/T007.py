import math


def ten_thousand_one_prime():
    def is_prime(n):
        if n % 2 == 0 and n > 2:
            return False
        return all(n % i for i in range(3, int(math.sqrt(n)) + 1, 2))

    prime_amount = 1
    number = 3
    while prime_amount != 10001:
        if is_prime(number):
            prime_amount += 1
        number += 2

    return number - 2
