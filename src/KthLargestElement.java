public class KthLargestElement {
    // https://leetcode.com/problems/kth-largest-element-in-an-array/
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            heapify(nums);
            int max =0;
            int size = nums.length-1;
            for(int i= 0; i< k; i++){
                max = nums[0];
                nums[0] = nums[size];
                size--;
                shiftDown(nums, 0, size);
            }
            return max;
        }
        public void shiftDown(int[] arr, int i, int size){
            int parent = i;
            int child = 2*parent +1;
            while(child < size){
                if(child +1 < size && arr[child+1] > arr[child]) child += 1;
                if(arr[parent] < arr[child]){
                    int temp = arr[parent];
                    arr[parent] = arr[child];
                    arr[child] = temp;

                    parent = child;
                    child = 2*parent+1;
                }
                else break;
            }
        }
        public void heapify(int[] arr){
            for(int i= arr.length/2-1; i >= 0; i--){
                shiftDown(arr,i,arr.length);
            }
        }
    }
}
