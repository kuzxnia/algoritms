# Big O complexity
# Average = O((1/4)*(n^2))
# Pessimistic = O((1/2)*n^2+(1/2)*n-1)

def insertSort(array):
    # Traverse through 1 to len(arr)
    for i in range(1, len(array)):
        current = array[i]
        j = i - 1

        while j >= 0 and current < array[j]:
            array[j + 1] = array[j]
            j -= 1

        array[j + 1] = current
