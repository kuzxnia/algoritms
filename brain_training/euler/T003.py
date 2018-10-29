# The prime factors of 13195 are 5, 7, 13 and 29.
# What is the largest prime factor of the number 600851475143 ?

def largest_prime_factor(number):
    factor = 2
    while number != 1:
        if number % factor == 0:
            number /= factor
        else:
            factor += 1
    return factor
