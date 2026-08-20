public class Main {
    public static void printAllSubset(int[] nums, int idx, int targetSum, String asf) {
        if (idx == nums.length) {
            if (targetSum == 0) {
                System.out.println(asf);
            }
            return;
        }

        printAllSubset(nums, idx + 1, targetSum - nums[idx], asf + nums[idx] + ","); // Yes Call
        printAllSubset(nums, idx + 1, targetSum, asf); // No Call
    }

    public static void main(String[] args) {
        int nums[] = { 2, 2, 3, 11, 1, 4, 0 };
        int targetSum = 5;

        printAllSubset(nums, 0, targetSum, "");
    }
}
