import java.util.HashMap;

public class Arrays{

    public static void main(String[] args) {
        int[] test = {1, 7, 3, 2};
        System.out.println(twoSum(test, 9)[0] + " " + twoSum(test, 9)[1]);
    }

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int difference = target - nums[i];
            if (map.get(difference) != null) {
                int[] result = {i, map.get(difference)};
                return result;            
            }else {
                map.put(nums[i], i);
            }
        }
        return null;
    }
    
}