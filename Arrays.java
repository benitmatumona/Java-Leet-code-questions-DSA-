import java.util.HashMap;
import java.util.HashSet;

public class Arrays{

    public static void main(String[] args) {
        System.out.println(containsDuplicates2(new int[] {1, 2, 3, 1, 4, 5, 6, 7}, 3));
        System.out.println(validAnagram("abcd", "dbac"));
    }

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int difference = target - nums[i];
            if (map.get(difference) != null) return new int[] {i, map.get(difference)};            
            else  map.put(nums[i], i);
        }
        return new int[] {};
    }

    public static boolean containsDuplicates(int[] nums) {
        HashSet<Integer> set = new HashSet<>(); 
        for (int num: nums) {
            if (set.contains(num)) return true;
            set.add(num);
        } 
        return false;
    }
    
    public static boolean containsDuplicates2(int[] nums, int target) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) return true;
            set.add(nums[i]);
            if (set.size() > target) set.remove(nums[i - target]);
        }
        return false;
    }

    public static boolean validAnagram(String a, String b) {
        if (a.length() != b.length()) return false;
        int[] letters = new int[26];
        for (int i = 0; i < a.length(); i++) {
            letters[a.charAt(i) - 'a']++;
            letters[b.charAt(i) - 'a']--;
        }
        for (int value: letters) if (value != 0) return false; 
        return true;
    }
}