import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class ArraysTopic{

    public static void main(String[] args) {
        System.out.println(containsDuplicates2(new int[] {1, 2, 3, 1, 4, 5, 6, 7}, 3));
        System.out.println(validAnagram("abcd", "dbac"));
        System.out.println(groupAnagrams(new String[] {"aba", "aab", "ab", "b", "ba"}));
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

    public static List<List<String>> groupAnagrams(String[] words) {
        if (words.length == 0) return new ArrayList<>();

        int[] indexs = new int[26];
        HashMap<String, List<String>> map = new HashMap<>(); 
        
        for (String word: words) {
            Arrays.fill(indexs, 0);
            for(char letter: word.toCharArray())
                indexs[letter - 'a']++;

            StringBuilder code = new StringBuilder("");
            for (int number: indexs) {
                code.append("#");
                code.append(number);
            }
            
            String key = code.toString();
            map.computeIfAbsent(key, value -> new ArrayList<>()).add(word);
        }
        
    return new ArrayList<>(map.values());         
    }
}