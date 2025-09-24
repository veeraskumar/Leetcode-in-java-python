import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {

//	LeetCode 217 – Contains Duplicate
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

//	LeetCode 1 – Two Sum Problem Statement:
//	Given an array of integers nums and an integer target, return indices of the two numbers
//	such that they add up to target.You may assume that each input would have exactly one solution, 
//	and you may not use the same element twice. You can return the answer in any order.
//	Example: Input: nums = [2,7,11,15], target = 9 --> Output: [0,1]
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
	
// LeetCode 242 - Valid Anagram
// Given two strings s and t, return true if t is an anagram of s, and false otherwise.
// An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, 
// typically using all the original letters exactly once.
// Example 1: Input: s = "anagram", t = "nagaram" --> Output: true
// Example 2: Input: s = "rat", t = "car" --> Output: false
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

  public static List<List<String>> groupAnagrams(String[] strs) {
		if (strs.length == 0)
			return new ArrayList<List<String>>();

		HashMap<String, ArrayList<String>> hashMap = new HashMap<>();
		for (String s : strs) {
			int[] arr = new int[26];
			for (char c : s.toCharArray())
				arr[c - 'a']++;

			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < 26; i++) {
				sb.append("#");
				sb.append(arr[i]);
			}

			String key = sb.toString();
			if (!hashMap.containsKey(key))
				hashMap.put(key, new ArrayList<String>());
			hashMap.get(key).add(s);
		}
		return new ArrayList<List<String>>(hashMap.values());
	}

	public static int[] topKFrequent(int[] nums, int k) {
		if (nums.length == k)
			return nums;

		HashMap<Integer, Integer> hashMap = new HashMap<>();
		for (int i : nums)
			hashMap.put(i, hashMap.getOrDefault(i, 0) + 1);

		PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
		for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
			pq.offer(entry);
			if (pq.size() > k)
				pq.poll();
		}
		int[] result = new int[k];
		for (int i = k - 1; i >= 0; i--) {
			result[i] = pq.poll().getKey();
		}
		return result;
	}
}

