// #Amazon: A target is given, and needed to make the target from a dice.

import java.util.*;

public class DiceProblem {
    public static void main(String[] args) {
        dice("", 4);
        
        List<String> ans = diceList("", 4);
        System.out.println(ans);


        diceFace("", 4, 8);
    }

    static void dice(String p, int target){
        if(target == 0){
            System.out.println(p);
            return;
        }

        for(int i=1; i<=6 && i<=target; i++){
            dice(p+i, target-i);
        }
    }

    static List<String> diceList(String p, int target){
        if(target == 0){
            List<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        
        List<String> ans = new ArrayList<>();
        for(int i=1; i<=6 && i<=target; i++){
            ans.addAll(diceList(p+i, target-i));
        }

        return ans;
    }

    // custom face die
    static void diceFace(String p, int target, int face){
        if(target == 0){
            System.out.println(p);
            return;
        }

        for(int i=1; i<=face && i<=target; i++){
            diceFace(p+i, target-i, face);
        }
    }

}

