public class CircularLinkedList {
    private Node head;
    private Node tail;

    public CircularLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void insert(int value) {
        Node node = new Node(value);
        if (head == null) {
            head = node;
            tail = node;
            return;
        }
        tail.next = node;
        node.next = head;
        tail = node;
    }

    public void display(){
        if(head == null) {
            System.out.println("List is empty");
            return;
        }

        Node temp = head;
        do {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        } while (temp != head);
        System.err.println();
    }

    public void delete(int value){
        Node node = head;
        if(node == null){
            return;
        }
        if(node.value == value){
            head = head.next;
            tail.next = head; 
            return;
        }


        do {
            if(node.next.value == value){
                node.next = node.next.next;
                break;
            }
            node = node.next;
        } while (node != head);
        
    }



    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }


    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();
        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.insert(40);
        list.display(); 

        list.delete(29);
        list.display(); 
    }
}
