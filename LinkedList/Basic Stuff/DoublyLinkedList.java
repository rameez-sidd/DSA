public class DoublyLinkedList {
    // defining the Node class
    private class Node {
        private int value;
        private Node next;
        private Node prev;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next, Node prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }

    }

    private Node head;

    public void addFirst(int value) {
        Node node = new Node(value);
        node.next = head;
        node.prev = null;
        if (head != null) {
            head.prev = node;
        }
        head = node;

    }

    public void addLast(int value) {
        Node node = new Node(value);
        node.next = null;
        if (head == null) {
            node.prev = null;
            head = node;
            return;
        }

        Node last = head;
        while (last.next != null) {
            last = last.next;
        }
        last.next = node;
        node.prev = last;

    }

    public void add(int value, int index) {
        if (index < 0 || index > this.size()) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        if (index == 0) {
            addFirst(value);
            return;
        }
        if (index == size()) {
            addLast(value);
            return;
        }

        Node temp = head;
        for (int i = 1; i <= index; i++) {
            temp = temp.next;
        }

        Node node = new Node(value, temp, temp.prev);
        temp.prev.next = node;
        temp.prev = node;

    }

    public void addAfter(int afterValue, int value) {
        Node p = find(afterValue);

        if (p == null) {
            System.out.println("Value " + afterValue + " not found in the list.");
            return;
        }

        Node node = new Node(value, p.next, p);
        p.next = node;
        if (node.next != null) {
            node.next.prev = node;
        }

    }

    public int deleteFirst(){
        if(head == null){
            throw new IllegalStateException("List is empty");
        }

        int value = head.value;
        head = head.next;
        if (head != null) {
            head.prev = null;
        }
        return value;
    }

    public int deleteLast(){
        if(head == null){
            throw new IllegalStateException("List is empty");
        }

        Node last = head;
        while (last.next != null) {
            last = last.next;
        }

        int value = last.value;

        if(last.prev == null){
            head = null;
        }

        last.prev.next = null;
        return value;

    }

    public int delete(int index){
        if(index < 0 || index >= this.size()){
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }

        if(index == 0){
            return deleteFirst();
        }
        if (index == this.size() - 1) {
            return deleteLast();
        }

        Node temp = head;
        for(int i=1; i <= index; i++){
            temp = temp.next;
        }

        int value = temp.value;
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;

        return value;
    }

    public Node find(int value) {
        Node temp = head;
        while (temp != null) {
            if (temp.value == value) {
                return temp;
            }
            temp = temp.next;

        }
        return null;
    }

    public int size() {
        Node temp = head;
        int size = 0;
        while (temp != null) {
            size++;
            temp = temp.next;
        }

        return size;
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    public void displayReverse() {
        Node last = head;
        while (last.next != null) {
            last = last.next;
        }

        System.out.println("Printing in reverse order:");
        while (last != null) {
            System.out.print(last.value + " -> ");
            last = last.prev;

        }
        System.out.println("START");
    }

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.addFirst(10);
        list.addFirst(20);
        list.addFirst(30);
        list.addLast(99);
        list.add(500, 2);
        list.addAfter(20, 39);
        
        list.display();

        // list.deleteFirst();
        // list.deleteLast();
        // list.display();

        list.delete(2);
        list.display();
    }

}
