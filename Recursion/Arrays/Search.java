import java.util.ArrayList;

public class Search {
    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 18, 9, 18, 32};
        int target = 18;

        System.out.println(find(arr, target, 0));
        System.out.println(findLast(arr, target, arr.length-1));

        // Taking ArrayList as an extra variable outside the function
        findAll(arr, target, 0);
        System.out.println(list);

        // Passing ArrayList as an argument
        ArrayList<Integer> ans = new ArrayList<>();
        ans = findAll(arr, target, 0, ans);
        System.out.println(ans);

        // Not passing list as argument
        System.out.println(findAll2(arr, target, 0));

        
    }

    static int find(int[] arr, int target, int i){
        if(i == arr.length){
            return -1;
        }

        if(arr[i] == target){
            return i;
        }

        return find(arr, target, i+1);

    }

    static int findLast(int[] arr, int target, int i){
        if(i == -1){
            return -1;
        }

        if(arr[i] == target){
            return i;
        }

        return find(arr, target, i-1);

    }


    // Taking extra variable outside function
    static ArrayList<Integer> list = new ArrayList<>();
    static void findAll(int[] arr, int target, int i){
        if(i == arr.length){
            return;
        }

        if(arr[i] == target){
            list.add(i);
        }

        findAll(arr, target, i+1);

    }


    // RETURNING AN ARRAYLIST:

    // Taking list in the arguments
    static ArrayList<Integer> findAll(int[] arr, int target, int i, ArrayList<Integer> list){
        if(i == arr.length){
            return list;
        }

        if(arr[i] == target){
            list.add(i);
        }

        return findAll(arr, target, i+1, list);

    }


    // Not Taking list in the arguments
    static ArrayList<Integer> findAll2(int[] arr, int target, int i){
        ArrayList<Integer> list = new ArrayList<>();
        if(i == arr.length){
            return list;
        }

        // this will contain answer for that function call only
        if(arr[i] == target){
            list.add(i);
        }

        ArrayList<Integer> ansFromBelowCalls = findAll2(arr, target, i+1);

        list.addAll(ansFromBelowCalls);

        return list;

    }

}
