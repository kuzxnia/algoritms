def sum_square_difference():
    def _squares_sum():
        return sum([x**2 for x in range(1, 101)])

    def _sum_square():
        return sum([x for x in range(1, 101)])**2

    return _sum_square() - _squares_sum()