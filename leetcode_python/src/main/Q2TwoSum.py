"""
@desc 两数相加
@author zx
@date 2021/03/07
"""


class Solution:
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        the_dict = {}
        for index_i, value_i in enumerate(nums):
            value_j = target - value_i
            if value_j in the_dict:
                return [the_dict[value_j], index_i]
            else:
                the_dict[value_i] = index_i
