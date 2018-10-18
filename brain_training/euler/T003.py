def largest_prime_factor(number):
    factor = 2
    while number != 1:
        if number % factor == 0:
            number /= factor
        else:
            factor += 1
    return factor
