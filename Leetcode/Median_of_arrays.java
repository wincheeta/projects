public class Median_of_arrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] arr = merge(nums1,nums2);
        if (arr.length % 2 == 1) {
            return arr[arr.length/2];
        } else {
            return ((double) (arr[arr.length/2-1]+arr[arr.length/2]))/2;
        }
    }

    public int[] merge(int[] nums1, int[] nums2) {
        int[] merged = new int[nums1.length + nums2.length];
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) { merged[i+j] = nums1[i++]; }
            else { merged[i+j] = nums2[j++]; }
        }
        while (i < nums1.length || j < nums2.length) {
            if (i < nums1.length) { merged[i+j] = nums1[i++]; }
            else { merged[i+j] = nums2[j++]; }
        }
        return merged;
    }

    public static void main(String[] args) {
        Median_of_arrays obj = new Median_of_arrays();
        System.out.println(obj.findMedianSortedArrays(new int[]{1,2}, new int[]{3}));
        System.out.println(obj.findMedianSortedArrays(new int[]{1,2}, new int[]{3,4}));
        System.out.println(obj.findMedianSortedArrays(new int[]{1,2,6}, new int[]{3,4,5}));
    }
}
