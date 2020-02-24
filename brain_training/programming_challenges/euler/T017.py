from functools import reduce


def number_letter_counts():
    def convert_to_words(number):
        digits = ['zero', 'one', 'two', 'three', 'four',
                  'five', 'six', 'seven', 'eight', 'nine',
                  'ten', 'eleven', 'twelve', 'thirteen', 'fourteen',
                  'fifteen', 'sixteen', 'seventeen', 'eighteen', 'nineteen']

        tens = ['twenty', 'thirty', 'forty', 'fifty',
                'sixty', 'seventy', 'eighty', 'ninety']

        if 0 <= number <= 19:
            return digits[number]

        elif 20 <= number <= 99:
            if number % 10:
                return tens[(number // 10) - 2] + "" + convert_to_words(number % 10)
            else:
                return tens[(number // 10) - 2]

        elif 100 <= number <= 999:
            if number % 100:
                return digits[number // 100] + "hundredand" + convert_to_words(number % 100)
            else:
                return digits[number // 100] + "hundred"

        elif number == 1000:
            return digits[1] + "thousand"

    return reduce(lambda x, y: x + y, [len(convert_to_words(x)) for x in range(1, 1001)])
