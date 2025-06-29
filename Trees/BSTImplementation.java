
class BST{

    private Node root;

    public BST(){

    }

    public void insert(int value){
        root = insert(value, root);
        
    } 

    private Node insert(int value, Node node){
        if(node == null){
            node = new Node(value);
            return node;
        }
        if(value < node.value){
            node.left = insert(value, node.left);
        }
        if(value > node.value){
            node.right = insert(value, node.right);
        }

        node.height = Math.max(height(node.left), height(node.right)) + 1; 

        return node;
    }

    public void populate(int[] nums){
        for(int i=0; i<nums.length; i++){
            insert(nums[i]);
        }
    }

    public void populateSorted(int[] nums){
        populateSorted(nums, 0, nums.length);
    }

    private void populateSorted(int[] nums, int s, int e){
        if(s >= e){
            return;
        }

        int mid = s + (e-s)/2;

        this.insert(nums[mid]);
        populateSorted(nums, s, mid);
        populateSorted(nums, mid+1, e);
    }

    public boolean balanced(){
        return balanced(root);
    }

    private boolean balanced(Node node){
        if(node == null){
            return true;
        }

        return Math.abs(height(node.left) - height(node.right)) <= 1 && balanced(node.left) && balanced(node.right);
    }


    public int height(Node node){
        if(node == null){
            return -1;
        }
        return node.height;
    }

    public boolean isEmpty(){
        return root == null;
    }


    public void display(){
        display(root, "Root Node: ");
    }

    private void display(Node node, String details){
        if(node == null){
            return;
        }

        System.out.println(details + node.getValue());
        display(node.left, "Left Child of " + node.getValue() + " : ");
        display(node.right, "Right Child of " + node.getValue() + " : ");


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
                System.out.print("|         ");
            }

            System.out.println("|-------> " + node.value);
        } else {
            System.out.println(node.value);
        }

        prettyDisplay(node.left, level + 1);

    }



    public class Node {
        private int value;
        private int height;
        private Node left;
        private Node right;

        public Node(int value){
            this.value = value;
        }

        public int getValue(){
            return value;
        }
        
    }
}

public class BSTImplementation {
    public static void main(String[] args) {
        // BST tree = new BST();
        // tree.populate(new int[] {5, 2, 7, 1, 4, 6, 9, 8, 3, 10});
        // tree.display();

        // System.out.println(tree.balanced() == true ? "balanced" : "unbalanced");

        BST tree2 = new BST();
        tree2.populateSorted(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        tree2.prettyDisplay();
        System.out.println(tree2.balanced());

        // BST tree3 = new BST();
        // tree3.populate(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        // tree3.prettyDisplay();
        // System.out.println(tree3.balanced());
    }
}
