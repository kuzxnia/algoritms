def lpp():
    def _is_palindrome(num):
        return str(num) == str(num)[::-1]

    result = 0
    for i in range(999, 900, -1):
        for j in range(999, 900, -1):
            temp = i * j
            if _is_palindrome(temp) and temp > result:
                result = temp