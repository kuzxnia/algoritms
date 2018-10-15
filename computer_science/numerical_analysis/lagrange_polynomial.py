import operator
from functools import reduce


def lagrange_interpolation(x_values, y_values, arg):
    def _basis(j):
        p = [(arg - x_values[m]) / (x_values[j] - x_values[m]) for m in range(n) if m != j]
        return reduce(operator.mul, p)

    assert len(x_values) != 0 and (len(x_values) == len(y_values)), 'x and y length must be equal and grater than 0'

    n = len(x_values)
    return sum(_basis(j) * y_values[j] for j in range(n))
