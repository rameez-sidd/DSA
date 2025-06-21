// Remove all a's from a String


public class SkippingChar {
    public static void main(String[] args) {
        String str = "baccad";
        skip("", str);

        String ans = skip2(str);
        System.out.println(ans);

        System.out.println(skipApple("bcdapplefg"));
        System.out.println(skipAppNotApple("bcdappfkoefkapplefg"));

    }

    // Recursive Approach 1
    static void skip(String processed, String unprocessed){
        if(unprocessed.isEmpty()){
            System.out.println(processed);
            return;
        }

        char ch = unprocessed.charAt(0);
        if(ch == 'a'){
            skip(processed, unprocessed.substring(1));
        } else {
            skip(processed + ch, unprocessed.substring(1));
        }

    }

    // Recursive Approach 2
    static String skip2(String unprocessed){
        if(unprocessed.isEmpty()){
           return "";
        }

        char ch = unprocessed.charAt(0);
        if(ch == 'a'){
            return skip2(unprocessed.substring(1));
        } else {
            return ch + skip2(unprocessed.substring(1));
        }

    }

    // Recursive Skip a certain Word
    static String skipApple(String unprocessed){
        if(unprocessed.isEmpty()){
           return "";
        }

        if(unprocessed.startsWith("apple")){
            return skipApple(unprocessed.substring(5));
        } else {
            return unprocessed.charAt(0) + skipApple(unprocessed.substring(1));
        }

    }

    // Skip 'app' but not 'apple'
    static String skipAppNotApple(String unprocessed){
        if(unprocessed.isEmpty()){
           return "";
        }

        if(unprocessed.startsWith("app") && !unprocessed.startsWith("apple")){
            return skipAppNotApple(unprocessed.substring(3));
        } else {
            return unprocessed.charAt(0) + skipAppNotApple(unprocessed.substring(1));
        }

    }
}
