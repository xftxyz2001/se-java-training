import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Test2441
 */
public class Test2441 {

    public int findMaxK1(int[] nums) {
        Set<Integer> hash = new HashSet<>();
        int max = -1;
        for (int i = 0; i < nums.length; i++) {
            if (hash.contains(-nums[i])) {
                int abs = Math.abs(nums[i]);
                if (abs > max) {
                    max = abs;
                }
            }
            hash.add(nums[i]);
        }
        return max;
    }

    public int findMaxK2(int[] nums) {
        Arrays.sort(nums);
        int i = 0, j = nums.length - 1;
        while (i < j) {
            if (-nums[i] == nums[j]) {
                return nums[j];
            } else {
                if (-nums[i] > nums[j]) {
                    i++;
                } else {
                    j--;
                }
                if (nums[i] > 0 || nums[j] < 0) {
                    break;
                }
            }
        }
        return -1;
    }

    public int findMaxK3(int[] nums) {
        Boolean[] hash = new Boolean[1001];
        int max = -1;
        for (int i = 0; i < nums.length; i++) {
            int abs = Math.abs(nums[i]);
            if (hash[abs] != null
                    && (hash[abs] && nums[i] < 0 || !hash[abs] && nums[i] > 0)
                    && abs > max) {
                max = abs;
            }
            hash[abs] = nums[i] > 0;
        }
        return max;
    }

    public int findMaxK(int[] nums) {
        boolean[] hash = new boolean[2001];
        int max = -1;
        for (int i = 0; i < nums.length; i++) {
            int index = 1000 + nums[i];
            int anotherIndex = 1000 - nums[i];
            if (hash[anotherIndex]) {
                int abs = Math.abs(nums[i]);
                if (abs > max) {
                    max = abs;
                }
            }
            hash[index] = true;
        }
        return max;
    }

    public static void main(String[] args) {
        // new Test2441().findMaxK(new int[] { -9, -43, 24, -23, -16, -30, -38, -30 });
        new Test2441().findMaxK(new int[] { -1, 2, -3, 3 });
    }
}