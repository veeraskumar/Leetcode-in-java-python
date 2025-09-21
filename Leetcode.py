def contains_duplicate(nums: list[int]) -> bool:
    if len(nums) == 0 or len(nums) is None:
        return True
    x: set = set()

    for num in nums:
        if num in x:
            return False
        x.add(num)

    return True


def sum_two_nums(nums: list[int], target: int) -> list:
    hash_map: dict = {}

    for i, num in enumerate(nums):
        value = target - num
        if value in nums:
            return [hash_map[value], i]
        hash_map.get(num, i)

    return []


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
