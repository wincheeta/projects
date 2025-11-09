public class Special_array {
    public boolean isArraySpecial(int[] nums) {
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i]%2 == nums[i+1]%2){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Special_array().isArraySpecial(new int[]{1,1,3,4,5}));
    }
}
