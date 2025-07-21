// Given a binary tree and a path array. Return true, if the path exists in the array, otherwise return false

class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }
}

public class CheckPathExists {
    public static void main(String[] args) {
        Node root = new Node(3);
        int[] path = { 3, 9, 12, 8 };
        System.out.println(isPathExists(root, path));
    }

    public static boolean isPathExists(Node root, int[] path) {
        if (root == null) {
            return path.length == 0;
        }
        return helper(root, path, 0);
    }

    private static boolean helper(Node node, int[] path, int index) {
        if (node == null) {
            return false;
        }

        if (index >= path.length || node.value != path[index]) {
            return false;
        }

        if (node.left == null && node.right == null && index == path.length - 1) {
            return true;
        }

        return helper(node.left, path, index++) || helper(node.right, path, index++);
    }

}
