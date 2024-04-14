class Solution {
    public int search(int[] nums, int target) {
       int n = nums.length;
       int left = 0, right = n-1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < nums[right]){    // right half sorted
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid -1;
                }
            } else { // left half sorted
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid -1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }
}
