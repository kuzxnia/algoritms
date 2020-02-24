class Solution:
    def plusOne(self, digits):
        def _helper(digits):
            if not digits:
                return [1]
            elif digits[0] == 9:
                return [0] + _helper(digits[1:])
            else:
                digits[0] += 1
                return digits

        return _helper(digits[::-1])[::-1]