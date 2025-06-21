
import java.util.ArrayList;

public class Subsequence {
    public static void main(String[] args) {
        subsequence("", "abc");
        
        ArrayList<String> ans = subSeqReturn("", "abc");
        System.out.println(ans);

        subsequenceASCII("", "abc");


        ArrayList<String> ansASCII = subSeqReturnASCII("", "abc");
        System.out.println(ansASCII);

    }
    

    // p = processed, up = unprocessed
    static void subsequence(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }

        char ch = up.charAt(0);

        subsequence(p + ch, up.substring(1));
        subsequence(p, up.substring(1));

    }

    // Returning an ArrayList
    static ArrayList<String> subSeqReturn(String p, String up){
        if(up.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;

        }

        char ch = up.charAt(0);

        ArrayList<String> left = subSeqReturn(p + ch, up.substring(1));  
        ArrayList<String> right = subSeqReturn(p, up.substring(1));  

        left.addAll(right);

        return left;
    }

    static void subsequenceASCII(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }

        char ch = up.charAt(0);

        subsequenceASCII(p + ch, up.substring(1));
        subsequenceASCII(p, up.substring(1));
        subsequenceASCII(p + (ch + 0), up.substring(1));

    }

    static ArrayList<String> subSeqReturnASCII(String p, String up){
        if(up.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;

        }

        char ch = up.charAt(0);

        ArrayList<String> left = subSeqReturnASCII(p + ch, up.substring(1));  
        ArrayList<String> right = subSeqReturnASCII(p, up.substring(1));  
        ArrayList<String> ascii = subSeqReturnASCII(p + (ch + 0), up.substring(1));  

        left.addAll(right);
        left.addAll(ascii);

        return left;
    }
}
 