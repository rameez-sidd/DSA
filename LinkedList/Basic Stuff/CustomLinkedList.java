class LL {

    // defining the Node class
    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

    }

    private Node head;
    private Node tail;
    private int size;

    public LL() {
        this.size = 0;
    }

    public void addFirst(int value) {
        Node node = new Node(value);
        node.next = head;
        head = node;

        if (tail == null) {
            tail = head;
        }

        size++;
    }

    // insert using recursion
    public void insertUsingRecursion(int value, int index){
        head = helper(value, index, head);
    }

    private Node helper(int value, int index, Node node){
        if(index == 0){
            Node newNode = new Node(value, node);
            size++;
            return newNode;
        }

        node.next = helper(value, index-1, node.next);
        return node;
    }

    public void addLast(int value) {
        if(tail == null) {
            addFirst(value);
            return;
        }
        Node node = new Node(value);
        tail.next = node;
        tail = node;
        size++;

    }

    public void add(int value, int index) {
        if(index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        if(index == 0){
            addFirst(value);
            return;
        }    
        if(index == size) {
            addLast(value);
            return;
        }

        Node temp = head;
        for(int i=1; i<index; i++){
            temp = temp.next;
        }

        Node node = new Node(value, temp.next);
        temp.next = node;
        size++;

    }

    public int deleteFirst(){
        if(head == null) {
            throw new IllegalStateException("List is empty");
        }
        int value = head.value;
        head = head.next;
        size--;

        if(head == null) {
            tail = null;
        }

        return value; 
    }

    public int deleteLast(){
        if(size <= 1){
            return deleteFirst();
        }

        Node secondLast = get(size - 2);
        int value = tail.value;
        tail = secondLast;
        tail.next = null;

        return value;
    }

    public int delete(int index){
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }

        if(index == 0) {
            return deleteFirst();
        }
        if(index == size - 1) {
            return deleteLast();
        }

        Node beforeTarget = get(index - 1);
        int value = beforeTarget.next.value;
        beforeTarget.next = beforeTarget.next.next;
        size--;

        return value;
    }

    public Node find(int value){
        Node temp = head;
        while (temp != null) {
            if (temp.value == value) {
                return temp;
            }
            temp = temp.next;
            
        }
        return null;
    }

    public Node get(int index){
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        Node temp = head;
        for(int i=1; i<=index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

}

public class CustomLinkedList {
    public static void main(String[] args) {
        LL list = new LL();
        list.addFirst(10);
        list.addFirst(20);
        list.addFirst(40);
        list.addLast(100);
        list.addLast(200);
        list.addLast(300);
        list.add(150, 4);
        list.deleteFirst();
        list.deleteLast();
        list.delete(2);
        list.display();
        list.insertUsingRecursion(17, 3);
        list.display();
    }

}
