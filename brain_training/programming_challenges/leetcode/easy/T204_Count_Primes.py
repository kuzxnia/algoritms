# for finding primes used sieve of eratosthenes

class Solution:
    def sieve(self, scope):
        prime = [True] * (scope)
        p = 2
        while p * p <= scope:

            if prime[p]:

                for i in range(p * 2, scope, p):
                    prime[i] = False
            p += 1
        return prime[2:]

    def countPrimes(self, end):
        return sum(1 for x in self.sieve(end) if x)


Solution().countPrimes(10)