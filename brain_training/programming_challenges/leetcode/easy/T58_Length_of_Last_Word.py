def lengthOfLastWord_(s):
    words = s.split()
    return 0 if len(words) == 0 else len(words[-1])
