# from unittest import TestCase
import unittest

from src.main.Q2TwoSum import Solution


class TestSolution(unittest.TestCase):
    def test_two_sum(self):
        nums = [2, 7, 11, 15]
        target = 9
        expected = [0, 1]
        
        res = Solution()
        self.assertListEqual(expected, res.twoSum(nums, target))


if __name__ == '__main__':
    unittest.main()
