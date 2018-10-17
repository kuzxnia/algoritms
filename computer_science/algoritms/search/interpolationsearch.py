# Big O complexity
# Average = O(log2(log2(n)))
# Pessimistic = O(n)

def interpolationSearch(arr, arg):
    left = 0
    right = (len(arr) - 1)

    while left <= right and arr[left] <= arg <= arr[right]:
        index = left + int(((float(right - left) / (arr[right] - arr[left])) * (arg - arr[left])))

        if arr[index] == arg:
            return index

        if arr[index] < arg:
            left = index + 1

        else:
            right = index - 1

    return -1
