# Given a string and a non-negative int n, return a larger string that is n copies of the original string.

def string_times(str, n):
    return str * n


# Given a string and a non-negative int n, we'll say that the front of the string is the first 3 chars, or whatever
# is there if the string is less than length 3. Return n copies of the front;

def front_times(str, n):
    return str[:3] * n


# Given a string, return a new string made of every other char starting with the first, so "Hello" yields "Hlo".

def string_bits(str):
    result = ""
    for i in range(len(str)):
        if i % 2 == 0:
            result += str[i]
    return result


# Given a non-empty string like "Code" return a string like "CCoCodCode".

def string_splosion(str):
    result = ""
    for i in range(1, len(str) + 1):
        result += str[:i]

    return result


# Given a string, return the count of the number of times that a substring length 2 appears in the string
# and also as the last 2 chars of the string, so "hixxxhi" yields 1 (we won't count the end substring).

def last2(str):
    string_len = len(str)

    if string_len < 2:
        return 0

    count = 0
    pattern = str[string_len - 2:]

    for i in range(string_len - 2):
        if str[i:i + 2] == pattern:
            count += 1

    return count


# Given an array of ints, return the number of 9's in the array.

def array_count9(nums):
    return nums.count(9)


# Given an array of ints, return True if one of the first 4 elements in the array is a 9.
# The array length may be less than 4.

def array_front9(nums):
    end = min(len(nums), 4)

    for i in range(end):
        if nums[i] == 9:
            return True

    return False


# Given an array of ints, return True if the sequence of numbers 1, 2, 3 appears in the array somewhere.

def array123(nums):
    if len(nums) < 3:
        return False

    for i in range(len(nums) - 2):
        if nums[i] == 1 and nums[i + 1] == 2 and nums[i + 2] == 3:
            return True

    return False


# Given 2 strings, a and b, return the number of the positions where they contain the same length 2 substring. So
# "xxcaazz" and "xxbaaz" yields 3, since the "xx", "aa", and "az" substrings appear in the same place in both strings.

def string_match(a, b):
    count = 0

    for i in range(len(a) - 1):
        if a[i: i + 2] == b[i: i + 2]:
            count += 1

    return count
