// You are given an array of characters letters that is sorted in non-decreasing order, and a character target. There are at least two different characters in letters.

// Return the smallest character in letters that is lexicographically greater than target. If such a character does not exist, return the first character in letters.
public class SmallestLetter {
    public static void main(String[] args) {
        char[] letters = {'c', 'f', 'k', 'r', 'u'};
        char target = 'a';
        char ans = nextGreatestLetter(letters, target);
        System.out.println(ans);
    }
    static char nextGreatestLetter(char[] letters, char target){
        if(target >= letters[letters.length-1]){
            return letters[0];
        }
        int start = 0;
        int end = letters.length-1;
        while(start <= end){
            int mid = start + (end-start)/2;
            if(target > letters[mid]){
                start = mid + 1;
            }
            else if(target < letters[mid]){
                end = mid-1;
            }
            else{
                return letters[mid + 1];
            }
        }
        return letters[start % letters.length];
    }
}
