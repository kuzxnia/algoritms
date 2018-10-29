# A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers
# is 9009 = 91 × 99. Find the largest palindrome made from the product of two 3-digit numbers.

def largest_palindrome_product():
    def _is_palindrome(num):
        return str(num) == str(num)[::-1]

    result = 0
    for i in range(999, 900, -1):
        for j in range(999, 900, -1):
            temp = i * j
            if _is_palindrome(temp) and temp > result:
                result = temp