public class maxtriplet {
    public long maximumTripletValue(int[] nums) {
        long max = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    System.out.println((nums[i]-nums[j])*nums[k] + " " + (nums[i] - nums[j]) + " " + nums[k]);
                    if ((long) (nums[i] - nums[j]) *nums[k]> max) {
                        max = (long) (nums[i] - nums[j]) *nums[k];
                    }
                }
            }
        }
    return max;
    }

    public static void main(String[] args) {
        maxtriplet maxtriplet = new maxtriplet();
        System.out.println(maxtriplet.maximumTripletValue(new int[]{1000000,1,1000000}));
    }
}
