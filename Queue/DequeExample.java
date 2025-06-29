package Queue;

import java.util.*;

public class DequeExample {
    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(89);
        deque.addFirst(78);
        deque.addLast(45);
        deque.removeFirst();
    }
}
