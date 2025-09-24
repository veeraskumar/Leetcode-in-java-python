# LeetCode 217 – Contains Duplicate
# Problem Statement:
# Given an integer array nums, return true if any value appears at least twice in the array, 
# and return false if every element is distinct.
# Example:
# Input: nums = [1,2,3,1] --> Output: true
# Input: nums = [1,2,3,4] --> Output: false
def contains_duplicate(nums: list[int]) -> bool:
    if len(nums) == 0 or len(nums) is None:
        return True
    x: set = set()

    for num in nums:
        if num in x:
            return False
        x.add(num)

    return True

# LeetCode 1 – Two Sum Problem Statement:
# Given an array of integers nums and an integer target, return indices of the two numbers
# such that they add up to target.You may assume that each input would have exactly one solution, 
# and you may not use the same element twice. You can return the answer in any order.
# Example: Input: nums = [2,7,11,15], target = 9 --> Output: [0,1]
# Explanation: Because nums[0] + nums[1] == 9.
def sum_two_nums(nums: list[int], target: int) -> list:
    hash_map: dict = {}

    for i, num in enumerate(nums):
        value = target - num
        if value in nums:
            return [hash_map[value], i]
        hash_map.get(num, i)

    return []

# LeetCode 242 - Valid Anagram
# Given two strings s and t, return true if t is an anagram of s, and false otherwise.
# An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, 
# typically using all the original letters exactly once.
# Example 1: Input: s = "anagram", t = "nagaram" --> Output: true
# Example 2: Input: s = "rat", t = "car" --> Output: false
def valid_anagram(s: str, t: str) -> bool:
    if len(s) != len(t):
        return False
    arr: list[int] = [0] * 26

    for i in range(len(s)):
        arr[ord(s[i]) - ord('a')] += 1
        arr[ord(t[i]) - ord('a')] -= 1

    for count in arr:
        if count != 0:
            return False

    return True
