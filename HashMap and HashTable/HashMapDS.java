import java.util.HashMap;
import java.util.HashSet;

public class HashMapDS {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();

        map.put("Kunal", 89);
        map.put("Karan", 99);
        map.put("Rahul", 94);

        // System.out.println(map.get("Kunal"));
        // System.out.println(map.getOrDefault("Apporva", 78));

        System.out.println(map.containsKey("Rameez"));

        HashSet<Integer> set = new HashSet<>();
        set.add(56);
        set.add(78);
        set.add(56); // Duplicate, will not be added again
        set.add(89);
        set.add(90);

        System.out.println(set);
    }
}
