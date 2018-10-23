# Big O complexity
# O(log2(n))
# works only on sorted array

# recursive
def binary_search_recursive(arr, arg, left, right):
    if right >= left:
        middle = left + (right - left) // 2

        if arr[middle] == arg:
            return middle

        elif arr[middle] > arg:
            return binary_search_recursive(arr, arg, left, middle - 1)

        else:
            return binary_search_recursive(arr, arg, middle + 1, right)
    else:
        return -1


# iterative
def binary_search(arr, arg, left, right):
    while left <= right:
        mid = left + (right - left) // 2

        if arr[mid] == arg:
            return mid

        elif arr[mid] < arg:
            left = mid + 1

        else:
            right = mid - 1

    return -1
