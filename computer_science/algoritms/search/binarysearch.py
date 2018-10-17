# Big O complexity
# O(log2(n))
# works only on sorted array

# recursive
def binarySearch(arr, left, right, arg):
    if right >= left:
        middle = left + (right - left) / 2

        if arr[middle] == arg:
            return middle

        elif arr[middle] > arg:
            return binarySearch(arr, left, middle - 1, arg)

        else:
            return binarySearch(arr, middle + 1, right, arg)
    else:
        return -1

# iterative
def binarySearch(arr, left, right, arg):
    while left <= right:
        mid = left + (right - left) / 2

        if arr[mid] == arg:
            return mid

        elif arr[mid] < arg:
            left = mid + 1

        else:
            right = mid - 1

    return -1