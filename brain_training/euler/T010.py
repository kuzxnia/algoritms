def summation_of_primes_below_two_million():
    def sieve(scope):
        prime = [True] * scope
        p = 2
        while p * p <= scope:

            if prime[p]:

                for i in range(p * 2, scope, p):
                    prime[i] = False
            p += 1
        return prime[2:]

    sum_of_primes = 0

    for index, number in enumerate(sieve(2000000)):
        if number:
            sum_of_primes += index + 2

    return sum_of_primes
