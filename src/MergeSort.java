public class MergeSort {
    // https://leetcode.com/problems/sort-an-array/
    class Solution {
        public int[] sortArray(int[] nums) {
            int[] aux = new int[nums.length];
            mergeSort(nums,aux,0, nums.length-1);
            return nums;
        }
        public void mergeSort(int[] arr, int[] aux, int low, int high){
            if(high <= low) return;
            int mid = low + (high-low)/2;
            mergeSort(arr, aux, low, mid);
            mergeSort(arr, aux, mid+1, high);
            if(arr[mid] <= arr[mid+1]) return;
            merge(arr,aux,low, mid, high);
        }
        public void merge(int[] arr, int[] aux, int low, int mid, int high){
            for(int i =low; i <= high; i++){
                aux[i] = arr[i];
            }
            int startLeft = low;
            int startRight = mid+1;
            for(int i= low; i <= high; i++){
                if(startLeft > mid) arr[i] = aux[startRight++];
                else if(startRight > high) arr[i] = aux[startLeft++];
                else if(aux[startLeft] <= aux[startRight]) arr[i] = aux[startLeft++];
                else arr[i] = aux[startRight++];
            }
        }
    }
}
