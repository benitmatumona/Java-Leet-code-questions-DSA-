import java.lang.reflect.Array;

public class Arrays{

    public static void main(String[] args) {
        int[] test = {15, 7, 2, 11};
        System.out.println(twoSum(test, 9)[0] + " " + twoSum(test, 9)[1]);
    }

    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length ; i++)
            if (nums[i] < target) {
                for (int j = i; j < nums.length; i++) {
                    if (nums[i] + nums[j] == target) {
                        int[] result = {i, j};
                        return result; 
                    }
                } 
            }
        return null;
    }
}