
class SegmentTree {
    Node root;

    public SegmentTree(int[] arr) {
        // create a tree using this array
        this.root = constructTree(arr, 0, arr.length - 1);
    }

    private Node constructTree(int[] arr, int start, int end) {
        if (start == end) {
            Node leaf = new Node(start, end);
            leaf.data = arr[start];
            return leaf;
        }

        Node node = new Node(start, end);

        int mid = (start) + (end - start) / 2;

        node.left = constructTree(arr, start, mid);
        node.right = constructTree(arr, mid + 1, end);

        node.data = node.left.data + node.right.data;

        return node;
    }

    public void display() {
        display(this.root);
    }

    private void display(Node node) {
        String str = "";
        if (node.left != null) {
            str += "Interval=[" + node.left.startInterval + "-" + node.left.endInterval + "] and data: "
                    + node.left.data + " => ";
        } else {
            str += "No left child => ";
        }

        // for current node
        str += "Interval=[" + node.startInterval + "-" + node.endInterval + "] and data: " + node.data + " <= ";

        if (node.right != null) {
            str += "Interval=[" + node.right.startInterval + "-" + node.right.endInterval + "] and data: "
                    + node.right.data + " => ";
        } else {
            str += "No right child";
        }

        System.out.println(str);

        // call recursion
        if (node.left != null) {
            display(node.left);
        }
        if (node.right != null) {
            display(node.right);
        }
    }

    // query
    public int query(int qsi, int qei) {
        return this.query(this.root, qsi, qei);
    }

    private int query(Node node, int qsi, int qei) {

        // case 1: when node interval lies inside query interval
        if (node.startInterval >= qsi && node.endInterval <= qei) {
            return node.data;
        }
        // Case 2: when node lies completely outside the query interval
        else if (node.startInterval > qei || node.endInterval < qsi) {
            // return default value
            return 0;
        }
        // Case 3: when node interval either partially overlaps the query interval or
        // completely
        else {
            return query(node.left, qsi, qei) + query(node.right, qsi, qei);
        }
    }

    // update
    public void update(int index, int value) {
        update(this.root, index, value);
    }

    private void update(Node node, int index, int value) {
        if (node.startInterval <= index && node.endInterval >= index) {
            if (node.startInterval == index && node.endInterval == index) {
                node.data = value;
                return;
            } else {
                update(node.left, index, value);
                update(node.right, index, value);
                node.data = node.left.data + node.right.data;
            }

        } else {
            return;
        }

    }

    public void prettyDisplay(){
        prettyDisplay(root, 0);
    }

    private void prettyDisplay(Node node, int level){
        if(node == null){
            return;
        }
        prettyDisplay(node.right, level + 1);

        if(level != 0){
            for(int i=0; i<level-1; i++){
                System.out.print("|                  ");
            }

            System.out.println("|----------------> " + node.data + " [" + node.startInterval + ", " + node.endInterval + "]");
        } else {
            System.out.println(node.data + " [" + node.startInterval + ", " + node.endInterval + "]");
        }

        prettyDisplay(node.left, level + 1);

    }

    private class Node {
        int data;
        int startInterval;
        int endInterval;
        Node left;
        Node right;

        public Node(int startInterval, int endInterval) {
            this.startInterval = startInterval;
            this.endInterval = endInterval;
        }
    }
}

public class SegmentTreeImplementation {
    public static void main(String[] args) {
        int[] arr = { 3, 8, 7, 6, -2, -8, 4, 9 };
        SegmentTree tree = new SegmentTree(arr);
        // tree.display();
        tree.prettyDisplay();

        System.out.println("Sum: " + tree.query(2, 6));


        // tree.update(3, 14);
        // System.out.println();
        // System.out.println();
        // tree.prettyDisplay();
    }
}
