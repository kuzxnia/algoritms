# Big O complexity
# Average = O((1/2)*(n^2))
# Pessimistic = O((1/2)*(n^2))

def bubbleSort(array):
    for i in range(len(array)):
        for k in range(i, len(array) - 1):
            if array[i] > array[i + 1]:
                array[i], array[i + 1] = array[i + 1], array[i]
