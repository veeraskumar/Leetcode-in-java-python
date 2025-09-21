import java.util.HashMap;
import java.util.HashSet;

public class LeetCode {

//	📌 LeetCode 217 – Contains Duplicate
//	Problem Statement:
//	Given an integer array nums, return true if any value appears at least twice in the array, 
//	and return false if every element is distinct.
//	Example:
//	Input: nums = [1,2,3,1] --> Output: true
//	Input: nums = [1,2,3,4] --> Output: false
	public static boolean containsDuplicate(int[] nums) {
		if (nums.length == 0 || nums.length == 1)
			return false;
		HashSet<Integer> hashSet = new HashSet<Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (hashSet.contains(nums[i]))
				return true;
			hashSet.add(nums[i]);
		}
		return false;
	}

//	📌 LeetCode 1 – Two Sum Problem Statement:
//	Given an array of integers nums and an integer target, return indices of the two numbers
//  such that they add up to target.You may assume that each input would have exactly one solution, 
//	and you may not use the same element twice. You can return the answer in any order.
//	Example:
//	Input: nums = [2,7,11,15], target = 9
//	Output: [0,1]
//	Explanation: Because nums[0] + nums[1] == 9.
	public static int[] twoSumInt(int[] nums, int target) {
		HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			int value = target - nums[i];
			if (hashMap.containsKey(value))
				return new int[] { hashMap.get(value), nums[i] };
			hashMap.put(nums[i], i);
		}
		return new int[] {};
	}

	public static boolean vaildAnagram(String s, String t) {
		if (s.length() != t.length())
			return false;
		int[] arr = new int[26];
		for (int i = 0; i < s.length(); i++) {
			arr[s.charAt(i) - 'a']++;
			arr[t.charAt(i) - 'a']--;
		}
		for (int i = 0; i < arr.length; i++)
			if (arr[i] != 0)
				return false;
		return true;
	}

	public static void main(String[] args) {
	}
}
