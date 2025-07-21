import java.util.*;


// This one is not so optimized, just for learning purposes

class MapUsingHash{
    private Entity[] entities;

    public MapUsingHash() {
        entities = new Entity[100];
    }

    public void put(String key, String value) {
        int hash = Math.abs(key.hashCode() % entities.length);
        entities[hash] = new Entity(key, value);    // overriding the existing value if the key already exists
    }


    public String get(String key) {
        int hash = Math.abs(key.hashCode() % entities.length);
        if (entities[hash] != null && entities[hash].key.equals(key)) {
            return entities[hash].value;
        }
        return null; // or throw an exception
    }

    public void remove(String key){
        int hash = Math.abs(key.hashCode() % entities.length);
        if (entities[hash] != null && entities[hash].key.equals(key)) {
            entities[hash] = null; // remove the entity
        }
    }



    private class Entity{
        String key;
        String value;

        public Entity(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    


}

public class CustomHashMap {
    public static void main(String[] args) {
        MapUsingHash map = new MapUsingHash();

        map.put("Kunal", "89");
        map.put("Karan", "99");
        map.put("Rahul", "94");

        System.out.println(map.get("Kunal"));
        System.out.println(map.get("Apporva")); // Should return null

        map.remove("Karan");
        System.out.println(map.get("Karan")); // Should return null
    }
}
