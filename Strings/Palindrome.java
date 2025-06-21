public class Palindrome{
    public static void main(String[] args) {
        String str = "pomegranate";
        System.out.println(str + " is Palindrome? : " + isPalindrome(str));
    }

    static boolean isPalindrome(String str){
        if(str == null || str.length() == 0){
            return true;
        }
        int start = 0;
        int end = str.length()-1;
        str = str.toLowerCase();
        while(start < end){
            if(str.charAt(start) != str.charAt(end)){
                return false;
            } else {
                start++;
                end--;
            }
        }

        return true;
    }
}