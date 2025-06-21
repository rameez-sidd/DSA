import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int k = rem(nums);
        System.out.println("The value of k is : " + k);
        
        for(int i=0; i<k; i++){
            System.out.print(nums[i] + ", ");
        }

        System.out.println(Arrays.toString(nums));
    }
    static int rem(int[] nums) {
        int size =1;
        for(int i=0; i<size; i++){
            for(int j=i+1; j<nums.length; j++){
                if(nums[i]<nums[j]){
                    nums[i+1]=nums[j];
                    size++;
                    break;
                }
                else{
                    continue;
                }
            }
        }
        return size;        
    }
}
