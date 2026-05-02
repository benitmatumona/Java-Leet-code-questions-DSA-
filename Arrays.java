import java.util.HashMap;
import java.util.HashSet;

public class Arrays{

    public static void main(String[] args) {
        int[] test = {1, 7, 3, 2};
        System.out.println(containsDuplicates(new int[] {1, 2, 3, 4, 5, 6, 7}));
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
    
}