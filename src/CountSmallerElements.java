public class CountSmallerElements {
    // https://practice.geeksforgeeks.org/problems/count-of-smaller-elements5947/1/#
    class Compute {

        public int countOfElements(long arr[], long n, long x)
        {   // if (x larger than the largest of the array)
            if(x >= arr[arr.length-1]) return arr.length;
                // if (x is smaller than the smallest of the array)
            else if(x < arr[0]) return 0;

            // do binary search to find the rightmost index of x(if possible)
            int l = 0; int r = arr.length-1; int index = -1; int mid = 0;
            while(l <= r){
                mid = l + (r-l)/2;
                if(arr[mid] > x) r = mid-1;
                else{
                    if(arr[mid] == x) index = mid;
                    l = mid+1;
                }
            }
            // if we can find the rightmost left -> return that index+1
            if(index != -1) return index+1;
                // in case cannot find the mid index will either be the 2 closet number to x (one is larger and one is smaller)
                // case 1: if arr[mid] < x -> all smaller is in range [0, mid+1]
                // cas2 2: if arr[mid] > x -> all smaller is in range [0, mid-1]
            else{
                if(arr[mid] < x) mid += 1;
                return mid;
            }
        }
    }
}
