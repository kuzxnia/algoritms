def even_fib_sum(scope=4000000):
    a = 1
    b = 1
    sum = 0
    while a < scope:
        a += b
        b = a - b
        if a % 2 == 0:
            sum += a
    return sum
