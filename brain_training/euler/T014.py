def longest_collatz_sequence():
    def colatz_sequence_len(number):
        if number == 1:
            return 1

        if number % 2 == 0:
            return colatz_sequence_len(number / 2) + 1
        else:
            return colatz_sequence_len(3 * number + 1) + 1

    max_seq_num = 0
    max_seq = 0
    for num in range(999999, 99999, -2):
        seq_len = colatz_sequence_len(num)
        if seq_len > max_seq:
            max_seq = seq_len
            max_seq_num = num

    return max_seq_num
