

class AVL{

    private Node root;

    public AVL(){

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

        return rotate(node);
    }

    private Node rotate(Node node){
        if(height(node.left) - height(node.right) > 1){
            // left heavy

            if(height(node.left.left) - height(node.left.right) > 0){
                // left-left case
                return rightRotate(node);
            }

            if(height(node.left.left) - height(node.left.right) < 0){
                // left-right case
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }


        }

        if(height(node.left) - height(node.right) < -1){
            // left heavy

            if(height(node.right.right) - height(node.right.left) > 0){
                // right-right case
                return leftRotate(node);
            }

            if(height(node.right.right) - height(node.right.left) < 0){
                // right-left case
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }


        }

        return node;
    }

    private Node rightRotate(Node p){
        Node c = p.left;
        Node t = c.right;
        c.right = p;
        p.left = t;

        p.height = Math.max(height(p.left), height(p.right)) + 1;
        c.height = Math.max(height(c.left), height(c.right)) + 1;

        return c;

    }

    private Node leftRotate(Node c){
        Node p = c.right;
        Node t = p.left;
        
        p.left = c;
        c.right = t;

        p.height = Math.max(height(p.left), height(p.right)) + 1;
        c.height = Math.max(height(c.left), height(c.right)) + 1;

        return p;

    }

    public void populate(int[] nums){
        for(int i=0; i<nums.length; i++){
            insert(nums[i]);
        }
    }

    public void populateSorted(int[] nums){
        populateSorted(nums, 0, nums.length-1);
    }

    private void populateSorted(int[] nums, int s, int e){
        if(s > e){
            return;
        }

        int mid = s + (e-s)/2;

        this.insert(nums[mid]);
        populateSorted(nums, s, mid-1);
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

public class AVLTreeImplementation {
    public static void main(String[] args) {
        AVL tree2 = new AVL();
        tree2.populate(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        tree2.prettyDisplay();
        System.out.println(tree2.balanced());
    }
}
