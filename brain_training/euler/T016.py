from functools import reduce


def power_digit_sum():
    return reduce(lambda x, y: x + y, [int(i) for i in str(2 ** 1000)])
