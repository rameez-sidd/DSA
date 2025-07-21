import java.util.*;

class MinHeap<T extends Comparable<T>> {
    private ArrayList<T> list;

    public MinHeap() {
        list = new ArrayList<>();
    }

    public void insert(T value) {
        list.add(value);
        upHeap(list.size() - 1);
    }

    private void upHeap(int index) {
        if (index == 0) {
            return;
        }
        int p = parent(index);
        if (list.get(index).compareTo(list.get(p)) < 0) {
            swap(index, p);
            upHeap(p);
        }

    }

    public T remove() throws Exception {
        if (list.isEmpty()) {
            throw new Exception("Heap is empty");
        }

        T removed = list.get(0);
        T last = list.remove(list.size() - 1);
        if (!list.isEmpty()) {
            list.set(0, last);
            downHeap(0);
        }
        return removed;
    }

    private void downHeap(int index) {
        int min = index;
        int left = left(index);
        int right = right(index);

        if (left < list.size() && list.get(min).compareTo(list.get(left)) > 0) {
            min = left;
        }
        if (right < list.size() && list.get(min).compareTo(list.get(right)) > 0) {
            min = right;
        }

        if(min != index){
            swap(min, index);
            downHeap(min);
        }
    }

    public ArrayList<T> heapSort() throws Exception {
        ArrayList<T> sortedList = new ArrayList<>();
        while(!list.isEmpty()){
            sortedList.add(this.remove());
        }

        return sortedList;
    }

    public int size() {
        return list.size();
    }

    private int parent(int index) {
        if (index == 0) {
            return -1; // No parent for the root
        }
        return (index - 1) / 2;
    }

    private int left(int index) {
        return 2 * index + 1;
    }

    private int right(int index) {
        return 2 * index + 2;
    }

    private void swap(int first, int second) {
        T temp = list.get(first);
        list.set(first, list.get(second));
        list.set(second, temp);
    }
}


class HuffmanEncoder{
    HashMap<Character, String> encoder;
    HashMap<String, Character> decoder;

    public HuffmanEncoder(String feeder) throws Exception {
        HashMap<Character, Integer> frequencyMap = new HashMap<>();

        // Step-1 and Step-2: Passing the string and making a frequency map
        for(int i=0; i < feeder.length(); i++) {
            char c = feeder.charAt(i);
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        MinHeap<Node> minHeap = new MinHeap<>();

        // Creating an Entry-Set for each key-value pair in frequencyMap
        Set<Map.Entry<Character, Integer>> entrySet = frequencyMap.entrySet();


        // Step-3: Creating node for each entry and inserting into the min-heap
        for(Map.Entry<Character, Integer> entry : entrySet) {
            Node node = new Node(entry.getKey(), entry.getValue());
            minHeap.insert(node);
        }

        // Step-4: Building the Huffman Tree 
        // (Removing the smallest two nodes and combining them to create a new node and inseting it back into the heap)
        while(minHeap.size() != 1){
            Node first = minHeap.remove();
            Node second = minHeap.remove();

            Node newNode = new Node(null, first.cost + second.cost);
            newNode.left = first;
            newNode.right = second;

            minHeap.insert(newNode);
        }

        // Step-5: Huffman Tree is now built, we can get the root node
        Node root = minHeap.remove();

        // Step-6: Building the encoder and decoder maps
        this.encoder = new HashMap<>();
        this.decoder = new HashMap<>();

        this.initEncoderDecoder(root, "");

    }

    private void initEncoderDecoder(Node node, String code) {
        if(node == null) {
            return;
        }

        if(node.left == null && node.right == null) {
            // Leaf node, add to encoder and decoder maps
            this.encoder.put(node.data, code);
            this.decoder.put(code, node.data);
        }

        initEncoderDecoder(node.left, code+"0");
        initEncoderDecoder(node.right, code+"1");
    }

    public String encode(String input) {
        StringBuilder encoded = new StringBuilder();
        for(int i=0; i < input.length(); i++) {
            char c = input.charAt(i);
            encoded.append(encoder.get(c));
        }
        return encoded.toString();
    }

    public String decode(String encodedInput) {
        StringBuilder decoded = new StringBuilder();
        StringBuilder key = new StringBuilder();

        for(int i=0; i < encodedInput.length(); i++) {
            key.append(encodedInput.charAt(i));

            if(decoder.containsKey(key.toString())) {
                decoded.append(decoder.get(key.toString()));
                key.setLength(0); // Reset the current code
            }
        }

        return decoded.toString();
    }


    private class Node implements Comparable<Node> {
        Character data;
        int cost; // frequency
        Node left;
        Node right;

        public Node(Character data, int cost) {
            this.data = data;
            this.cost = cost;
            this.left = null;
            this.right = null;
        }

        @Override
        public int compareTo(Node other) {
            return this.cost - other.cost;
        }

    }
}


public class HuffmanCoding {
    public static void main(String[] args) throws Exception {
        String input = "huffman coding example";
        HuffmanEncoder encoder = new HuffmanEncoder(input);

        String encoded = encoder.encode(input);
        System.out.println("Encoded: " + encoded);

        String decoded = encoder.decode(encoded);
        System.out.println("Decoded: " + decoded);

        // Verify that the decoded string matches the original input
        if (decoded.equals(input)) {
            System.out.println("Decoding successful!");
        } else {
            System.out.println("Decoding failed.");
        }
        
    }
}
