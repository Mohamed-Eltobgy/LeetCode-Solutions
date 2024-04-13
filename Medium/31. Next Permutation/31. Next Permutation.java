class Solution {
    public void nextPermutation(int[] nums) {
        int lastPeak = -1;
        int n = nums.length;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i+1]){
                lastPeak = i + 1;
                break;
            }
        }

        if (lastPeak == -1) {
            for (int i = 0; i < n / 2; i++) {
                int temp = nums[i];
                nums[i] = nums[n - i - 1];
                nums[n - i - 1] = temp;
            }
            return;
        }

        for (int i = n-1; i >= lastPeak; i--) {
            if (nums[lastPeak-1] < nums[i]) {
                int temp = nums[i];
                nums[i] = nums[lastPeak-1];
                nums[lastPeak - 1] = temp;
                break;
            }
        }
        int left = lastPeak, right = n-1;
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }      
    }
}
