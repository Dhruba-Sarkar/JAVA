package HashMap.Question;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Questions {

    // Most Frequent
    // Character(https://www.geeksforgeeks.org/problems/maximum-occuring-character-1587115620/1)
    public static char getMaxOccuringChar(String s) {
        HashMap<Character, Integer> freMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (freMap.containsKey(ch) == false) {
                freMap.put(ch, 1);

            } else {
                int oldFreq = freMap.get(ch);
                freMap.put(ch, oldFreq + 1);
            }
        }
        char ans = '\0'; // initialised with null character
        int maxFre = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (freMap.get(ch) > maxFre) {
                ans = ch;
                maxFre = freMap.get(ch);
            } else if (freMap.get(ch) == maxFre && ans > ch) {
                ans = ch; // replacing with lexicographically smaller character
            }
        }
        return ans;
    }

    // Leetcode 3005 -> Count Elements With Maximum Frequency
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer, Integer> freMap = new HashMap<>();

        int maxFre = 0;
        int totalFrequencies = 0;

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            int olderFre = freMap.getOrDefault(num, 0);

            int currentFre = olderFre + 1;
            freMap.put(num, currentFre);

            if (currentFre > maxFre) {
                maxFre = currentFre;
                totalFrequencies = currentFre;
            }

            else if (currentFre == maxFre) {
                totalFrequencies += currentFre;
            }
        }

        return totalFrequencies;

    }

    // Leetcode 349 -> Intersection of Two Arrays
    public int[] intersection(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();

        // add nums1 to map
        for (int e : nums1) {
            map.put(e, 1); // we dont care about frequency
        }
        ArrayList<Integer> ans = new ArrayList<>();

        // find intersection
        for (int e : nums2) {
            if (map.containsKey(e)) {
                ans.add(e);
                map.remove(e); // remove to avoid duplicates
            }
        }
        int[] res = new int[ans.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = ans.get(i);
        }

        // return ans.stream().mapToInt(i->i).toArray();
        return res;
    }

    // Leetcode 349 -> Intersection of Two Arrays using set
    public int[] intersection1(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();

        // add nums1 to set
        for (int e : nums1) {
            set.add(e); // we dont care about frequency
        }
        ArrayList<Integer> ans = new ArrayList<>();

        // find intersection
        for (int e : nums2) {
            if (set.contains(e)) {
                ans.add(e);
                set.remove(e); // remove to avoid duplicates
            }
        }

        return ans.stream().mapToInt(i -> i).toArray();
    }

    // Leetcode 128-> Longest Consecutive Sequence
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int e : nums) {
            set.add(e);
        }

        int res = 0;

        for (int num : nums) {
            if (set.contains(num) == false)
                continue;

            int left = num - 1;
            int right = num + 1;

            set.remove(num); // we won't need it again

            while (set.contains(left)) {
                set.remove(left);
                left--;
            }

            while (set.contains(right)) {
                set.remove(right);
                right++;
            }

            res = Math.max(res, right - left - 1);
        }

        return res;
    }

    public static void main(String[] args) {

    }

}
