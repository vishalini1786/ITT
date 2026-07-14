import java.util.Collections;
import java.util.List;

class Solution {
    public int countWays(List<Integer> nums) {
        int n = nums.size();
        
        // Step 1: Sort the List in ascending order
        Collections.sort(nums);
        
        int ways = 0;
        
        // Case 1: Select 0 students (k = 0)
        // Valid only if the very first student's requirement is > 0
        if (nums.get(0) > 0) {
            ways++;
        }
        
        // Case 2: Select k students (where 1 <= k < n)
        for (int k = 1; k < n; k++) {
            // Selected students are from index 0 to k-1.
            // Unselected students are from index k to n-1.
            if (nums.get(k - 1) < k && nums.get(k) > k) {
                ways++;
            }
        }
        
        // Case 3: Select all n students (k = n)
        // Valid only if the last student's requirement is < n
        if (nums.get(n - 1) < n) {
            ways++;
        }
        
        return ways;
    }
}
