import java.util.ArrayList;
import java.util.LinkedList;




class HashMaps<K, V> {
    ArrayList<LinkedList<Entity>> list;

    private int size = 0;

    private float lf = 0.5f; // Load factor

    public HashMaps(){
        list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new LinkedList<>());
        }
    }

    public void put(K key, V value) {
        int hash = Math.abs(key.hashCode() % list.size());
        LinkedList<Entity> entities = list.get(hash);

        for(Entity entity : entities) {
            if (entity.key.equals(key)) {
                entity.value = value;
                return;
            }
        } 

        if((float)(size) / list.size() > lf) {
            rehash();
        }

        entities.add(new Entity(key, value));

        size++;

    }

    private void rehash(){
        System.out.println("We are now rehashing");

        ArrayList<LinkedList<Entity>> oldList = list;
        list = new ArrayList<>();

        size = 0;

        for (int i = 0; i < oldList.size() * 2; i++) {
            list.add(new LinkedList<>());
        }

        for (LinkedList<Entity> entities : oldList) {
            for (Entity entity : entities) {
                put(entity.key, entity.value);
            }
        }
    }

    public V get(K key) {
        int hash = Math.abs(key.hashCode() % list.size());
        LinkedList<Entity> entities = list.get(hash);

        for(Entity entity : entities) {
            if (entity.key.equals(key)) {
                return entity.value;
            }
        }

        return null; // or throw an exception
    }

    public void remove(K key) {
        int hash = Math.abs(key.hashCode() % list.size());
        LinkedList<Entity> entities = list.get(hash);

        for(Entity entity : entities) {
            if (entity.key.equals(key)) {
                entities.remove(entity);
                size--;
                return;
            }
        }
    }

    public boolean containsKey(K key) {
        return get(key) != null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (LinkedList<Entity> entities : list) {
            for (Entity entity : entities) {
                sb.append(entity.key);
                sb.append("=");
                sb.append(entity.value);
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }


    private class Entity {
        K key;
        V value;

        public Entity(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
    
}

public class HashMapFinal {
    public static void main(String[] args) {
        HashMaps<String, Integer> map = new HashMaps<>();

        map.put("Kunal", 89);
        map.put("Karan", 99);
        map.put("Rahul", 94);

        System.out.println(map.get("Kunal"));
        System.out.println(map.get("Apporva")); // Should return null

        System.out.println(map.containsKey("Rameez"));

        map.remove("Karan");
        System.out.println(map.get("Karan")); // Should return null

        System.out.println(map); // Print the entire map
    }
}
