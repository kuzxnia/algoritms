# methods sorted in execution time order

def most_common(arr):
    return max(set(arr), key=arr.count)


from statistics import mode

def most_common_statistic(arr):
    return mode(arr)


from collections import Counter

def most_common_counter(lst):
    data = Counter(lst)
    return max(lst, key=data.get)