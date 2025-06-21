public class SearchInString{
    public static void main(String[] args) {
        String name = "Rameez";
        char target = 'm';
        System.out.println(search2(name, target));
    }
    
    // search for the character and return it's index if it is found
    // if it is not found return -1
    static int search2(String str, char target){
        if(str.length()==0){
            return -1;
        }
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i)==target){
                return i;
            }
        }
        return -1;
    }

    // search for the character and return true if it is found
    // if it is not found return false
    static boolean search(String str, char target){
        if(str.length()==0){
            return false;
        }
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i)==target){
                return true;
            }
        }
        return false;
    }
}
