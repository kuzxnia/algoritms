# Big O complexity
# O(n)

def linearSearch(arg, arr):
    for i in range(len(arr)):
        if arr[i] == arg:
            return i
    else:
        return -1
