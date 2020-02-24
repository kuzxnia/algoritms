# Given a string, return a string where for every char in the original, there are two chars.

def double_char(str):
    result = ""
    for i in str:
        result += i * 2
    return result


# Return the number of times that the string "hi" appears anywhere in the given string.

def count_hi(text):  # edited param name
    return str(text).count("hi")


# Return True if the string "cat" and "dog" appear the same number of times in the given string.

def cat_dog(text):
    return text.count("cat") == text.count("dog")


# Return the number of times that the string "code" appears anywhere in the given string,
# except we'll accept any letter for the 'd', so "cope" and "cooe" count.

def count_code(text):
    count = 0
    for i in range(0, len(text) - 3):
        if text[i:i + 2] == "co" and text[i + 3] == "e":
            count += 1
    return count


# Given two strings, return True if either of the strings appears at the very end of the other string,
# ignoring upper/lower case differences (in other words, the computation should not be "case sensitive").
# Note: s.lower() returns the lowercase version of a string.

def end_other(a, b):
    a, b = str(a).lower(), str(b).lower()
    return a.endswith(b) if len(a) > len(b) else b.endswith(a)


# Return True if the given string contains an appearance of "xyz" where the xyz is not directly preceeded by a period(.)
# So "xxyz" counts but "x.xyz" does not.

def xyz_there(text):
    return text.count("xyz") > text.count(".xyz")
