class Solution:
    def addStrings(self, num1, num2):
        if len(num1) == 0:
            return num2
        if len(num2) == 0:
            return num1

        digit_sum = int(num1[-1]) + int(num2[-1])
        if digit_sum > 9:
            return self.addStrings(self.addStrings(num1[:-1], str(digit_sum // 10)), num2[:-1]) + str(digit_sum % 10)
        else:
            return self.addStrings(num1[:-1], num2[:-1]) + str(digit_sum)