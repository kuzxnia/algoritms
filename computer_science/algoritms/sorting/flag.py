# Big O complexity
# Average = O(n)
# Pessimistic = O(n)

def flag(array):
    left, right = 0, len(array) - 1

    while left < right:
        while left < right and array[left] != 1:
            left += 1

        while right > left and array[right] != 0:
            right -= 1

        array[left], array[right] = array[right], array[left]

    return array
