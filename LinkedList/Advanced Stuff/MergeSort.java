

public class MergeSort {
    class Node {
        int val;
        Node next;

        Node() {
        }

        Node(int val){
            this.val = val;
            this.next = null;
        }
    }

    Node mergeSort(Node head){
        if(head == null || head.next == null){
            return head;
        }

        Node mid = getMid(head);
        Node left = mergeSort(head);
        Node right = mergeSort(mid);

        return merge(left, right);
    }

    Node merge(Node list1, Node list2){
        Node head = new Node();
        Node tail = head;

        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }

        return head.next;
    }


    Node getMid(Node head){
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
