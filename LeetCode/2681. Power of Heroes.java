import java.util.Arrays;

class Solution {
    public int sumOfPower(int[] nums) {
        long MOD = 1_000_000_007;
        
        // Step 1: Sort the array
        Arrays.sort(nums);
        
        long totalPower = 0;
        long minSumTracking = 0; // Represents our running sum 'S'
        
        // Step 2: Linearly calculate power using the running sum
        for (int i = 0; i < nums.length; i++) {
            long val = nums[i];
            long maxSquared = (val * val) % MOD;
            
            // Total min elements contribution = current singleton element + running combinations
            long totalMinContribution = (val + minSumTracking) % MOD;
            
            // Add the power of all groups where nums[i] is the maximum
            long currentGroupPower = (maxSquared * totalMinContribution) % MOD;
            totalPower = (totalPower + currentGroupPower) % MOD;
            
            // Update the running combination sum for the next iteration
            minSumTracking = (2 * minSumTracking + val) % MOD;
        }
        
        return (int) totalPower;
    }
}
