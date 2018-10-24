from itertools import permutations

class Solution:
    def permute(self, nums):
        return [list(x) for x in permutations(nums, len(nums))]