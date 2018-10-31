def fib_seq(scope):
    a = b = 1
    for _ in range(scope):
        a += b
        b = a - b
        yield a
