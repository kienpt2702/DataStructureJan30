public class SearchInRotatedSortedArray {
    // https://leetcode.com/problems/search-in-rotated-sorted-array/submissions/
    // 0 - 1 ms
    class Solution {
        public int search(int[] nums, int target) {
            // if length = 1 check the only element
            if(nums.length == 1) return (nums[0] == target) ? 0 : -1;

            if(nums[0] < nums[nums.length-1]) return bSearch(nums, target, 0, nums.length-1);
            int l = 0; int r = nums.length-1; int pivot = -1;
            while(l <= r){
                int mid = l + (r-l)/2;
                if(mid > 0 && nums[mid] < nums[mid-1]){
                    pivot = mid;
                    break;
                }
                if(nums[mid] > nums[mid+1]){
                    pivot = mid+1;
                    break;
                }
                // if nums[mid] > nums[0] -> mid is on the right side -> pivot on the right
                // else mid on the left -> pivot on the left
                if(nums[mid] > nums[0]) l = mid+1;
                else r = mid-1;
            }
            return (target >= nums[0]) ? bSearch(nums, target, 0, pivot-1): bSearch(nums, target, pivot, nums.length-1);
        }
        public int bSearch(int[] nums, int target, int l, int r){
            while(l <= r){
                int mid = l + (r-l)/2;
                if(nums[mid] == target) return mid;
                if(nums[mid] > target) r = mid-1;
                else l = mid+1;
            }
            return -1;
        }
    }
}
