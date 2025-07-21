
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

class BinaryTree {
    private Node root;

    public BinaryTree() {

    }

    public Node getRoot() {
        return root;
    }

    // insert elements
    public void populate(Scanner scanner) {
        System.out.print("Enter the root Node: ");
        int value = scanner.nextInt();
        root = new Node(value);

        populate(scanner, root);

    }

    private void populate(Scanner scanner, Node node) {

        // Take input for Left Node
        System.out.print("Do you want to enter the left of " + node.value + " : ");
        boolean left = scanner.nextBoolean();

        if (left) {
            System.out.print("Enter the value of the left of " + node.value + " : ");
            int value = scanner.nextInt();
            node.left = new Node(value);
            populate(scanner, node.left);
        }

        // Take input for Right Node
        System.out.print("Do you want to enter the right of " + node.value + " : ");
        boolean right = scanner.nextBoolean();

        if (right) {
            System.out.print("Enter the value of the right of " + node.value + " : ");
            int value = scanner.nextInt();
            node.right = new Node(value);
            populate(scanner, node.right);
        }

    }

    public void display() {
        display(root, " ");

    }

    private void display(Node node, String indent) {
        if (node == null) {
            return;
        }
        System.out.println(indent + node.value);
        display(node.left, indent + "\t");
        display(node.right, indent + "\t");

    }

    public void prettyDisplay() {
        prettyDisplay(root, 0);
    }

    private void prettyDisplay(Node node, int level) {
        if (node == null) {
            return;
        }
        prettyDisplay(node.right, level + 1);

        if (level != 0) {
            for (int i = 0; i < level - 1; i++) {
                System.out.print("|         ");
            }

            System.out.println("|-------> " + node.value);
        } else {
            System.out.println(node.value);
        }

        prettyDisplay(node.left, level + 1);

    }

    public void preOrder() {
        preOrder(root);
        System.out.println();
    }

    private void preOrder(Node node) {
        if (node == null) {
            return;
        }

        System.out.print(node.value + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public void inOrder() {
        inOrder(root);
        System.out.println();
    }

    private void inOrder(Node node) {
        if (node == null) {
            return;
        }

        inOrder(node.left);
        System.out.print(node.value + " ");
        inOrder(node.right);
    }

    public void postOrder() {
        postOrder(root);
        System.out.println();
    }

    private void postOrder(Node node) {
        if (node == null) {
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value + " ");
    }





    // ============= IMPORTANT ONES ==============

    // finding a Node
    public Node findNode(int target) {
        return findNode(root, target);
    }

    private Node findNode(Node node, int target) {
        if (node == null) {
            return null;
        }

        if (node.value == target) {
            return node;
        }

        Node n = findNode(node.left, target);
        if (n != null) {
            return n;
        }

        return findNode(node.right, target);
    }

    // checking if two nodes are siblings
    boolean isSibling(Node node, Node x, Node y){
        if(node == null){
            return false;
        }

        return (
            (node.left == x && node.right == y) || (node.left == y && node.right == x) || isSibling(node.left, x, y) || isSibling(node.right, x, y)
        );
    }

    // finding the level of a node
    public int level(Node target){
        return level(root, target, 0);
    }
    private int level(Node node, Node target, int lev){
        if(node == null){
            return 0;
        }
        if(node == target){
            return lev;
        }
        int l = level(node.left, target, lev+1);
        if(l != 0){
            return l;
        }
        return level(node.right, target, lev+1);
    }

    // checking if two nodes are cousins : on the same level but not siblings
    public boolean isCousins(Node root, int x, int y) {
        Node xx = findNode(root, x);
        Node yy = findNode(root, y);

        return (
            level(root, xx, 0) == level(root, yy, 0) && !isSibling(root, xx, yy)
        );
    }







    // BREADTH FIRST TRAVERSAL/SEARCH
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();

        Queue<Node> q = new LinkedList<>();
        if (root == null) {
            return result;
        }

        q.offer(root);

        while (!q.isEmpty()) {
            int levelSize = q.size();

            List<Integer> currentLevelList = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                Node currNode = q.poll();
                currentLevelList.add(currNode.value);
                if (currNode.left != null) {
                    q.offer(currNode.left);
                }
                if (currNode.right != null) {
                    q.offer(currNode.right);
                }
            }

            result.add(currentLevelList);
        }

        return result;
    }



    // DEPTH FIRST TRAVERSAL/SEARCH (Using Stack)
    public List<Integer> DFS(Node root) {
        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }
        
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node curr = stack.pop();
            result.add(curr.value);

            

            if(curr.right != null){
                stack.push(curr.right);
            }

            if(curr.left != null){
                stack.push(curr.left);
            }

            
        }

        return result;
    }

    // ------------- QUESTIONS ---------------

    // Given a binary tree, and a target element. You have to return the element
    // that is next to it in level order traversal
    public Node LevelOrderSuccessor(Node root, int target) {
        if (root == null) {
            return null;
        }

        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            Node currNode = q.poll();
            if (currNode.left != null) {
                q.offer(currNode.left);
            }
            if (currNode.right != null) {
                q.offer(currNode.right);
            }
            if (currNode.value == target) {
                break;
            }

        }

        return q.poll();
    }

    // Give a binary tree, travel in ZigZag Level Order, Left-to-Right and then
    // Right-to-Left alternately
    public List<List<Integer>> zigZagLevelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();

        Deque<Node> q = new ArrayDeque<>();
        if (root == null) {
            return result;
        }

        q.offer(root);
        boolean reverse = false;

        while (!q.isEmpty()) {
            int levelSize = q.size();

            List<Integer> currentLevelList = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                Node currNode;
                if (reverse) {
                    currNode = q.removeLast();
                } else {
                    currNode = q.removeFirst();
                }

                currentLevelList.add(currNode.value);

                if (reverse) {
                    if (currNode.right != null) {
                        q.addFirst(currNode.right);
                    }
                    if (currNode.left != null) {
                        q.addFirst(currNode.left);
                    }
                } else {
                    if (currNode.left != null) {
                        q.addLast(currNode.left);
                    }
                    if (currNode.right != null) {
                        q.addLast(currNode.right);
                    }

                }

            }

            result.add(currentLevelList);
            reverse = !reverse;
        }

        return result;
    }

    private static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }
}

public class BinaryTreeImplementation {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        tree.populate(new Scanner(System.in));
        tree.display();
        tree.prettyDisplay();
        tree.preOrder();
        tree.inOrder();
        tree.postOrder();
        System.out.println(tree.LevelOrderSuccessor(tree.getRoot(), 14));

        List<Integer> DFS = tree.DFS(tree.getRoot());
        System.out.println(DFS);

    }

}
