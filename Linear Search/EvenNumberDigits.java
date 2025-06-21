// find number of elements having even number of digits
public class EvenNumberDigits {
    public static void main(String[] args) {
        int[] nums = {12, 3, 123, 140, 1782, -11};
        int noOfEvens = findNumber(nums);
        System.out.println(noOfEvens);
    }
    static int findNumber(int[] nums){
        int count = 0;
        for(int element : nums){
            if(evenDigits2(element)){
                count++;
            }
        }

        return count;
    }
    static boolean evenDigits2(int num){
        if(num<0){
            num = -num;
        }
        int count = (int)(Math.log10(num)) + 1;
        if(count%2==0){
            return true;
        }
        else{
            return false;
        }
    }
    static boolean evenDigits(int num){
        int count = 0;
        if(num<0){
            num = -num;
        }
        if(num==0){
            count++;
        }
        while(num>0){
            count++;
            num /= 10;
        }
        if(count%2==0){
            return true;
        }
        else{
            return false;
        }
    }
}

