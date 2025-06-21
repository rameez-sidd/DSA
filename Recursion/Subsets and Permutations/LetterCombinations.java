// Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

// A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

// #GOOGLE


import java.util.ArrayList;

public class LetterCombinations {
    public static void main(String[] args) {
        pad("", "12");

        ArrayList<String> ans = padReturn("", "12");
        System.out.println(ans);

        System.out.println(padCount("", "12"));
    }

    static void pad(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }

        int digit = up.charAt(0) - '0';     // convert '2' int 2

        for(int i = (digit-1) * 3; i < digit * 3; i++){
            char ch = (char) ('a' + i);
            pad(p + ch, up.substring(1));
        }
    }

    static ArrayList<String> padReturn(String p, String up){
        if(up.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        int digit = up.charAt(0) - '0';     // convert '2' int 2

        ArrayList<String> ans = new ArrayList<>();

        for(int i = (digit-1) * 3; i < digit * 3; i++){
            char ch = (char) ('a' + i);
            ans.addAll(padReturn(p + ch, up.substring(1)));
        }

        return ans;
    }


    static int padCount(String p, String up){
        if(up.isEmpty()){
            return 1;
        }

        int count = 0;
        int digit = up.charAt(0) - '0';     // convert '2' int 2

        for(int i = (digit-1) * 3; i < digit * 3; i++){
            char ch = (char) ('a' + i);
            count = count + padCount(p + ch, up.substring(1));
        }

        return count;
    }

    
}
