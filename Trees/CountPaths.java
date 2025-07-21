// Given a binary tree and a target sum. Return the count of paths whose sum is equal to the target sum

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }
}

public class CountPaths {
    public static void main(String[] args) {
        Node root = new Node(1);
        int target = 4;
        System.out.println(countPaths(root, target));
        System.out.println(listPaths(root, target));
    }

    public static int countPaths(Node root, int target){
        List<Integer> path = new ArrayList<>();
        return helper(root, target, path);
    }

    static int helper(Node node, int target, List<Integer> path){
        if(node == null){
            return 0;
        }

        path.add(node.value);

        int count = 0;
        int s = 0;
        
        ListIterator<Integer> itr = path.listIterator(path.size());

        while (itr.hasPrevious()) {
            s += itr.previous();

            if(s == target){
                count++;
            }
        }

        count += helper(node.left, target, path) + helper(node.right, target, path);

        path.remove(path.size() - 1);
        return count;
    }
    

    public static List<List<Integer>> listPaths(Node root, int target){
        List<List<Integer>> paths = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        helper2(root, target, path, paths);
        return paths;
    }

    public static void helper2(Node node, int target, List<Integer> path, List<List<Integer>> paths){
        if(node == null){
            return;
        }

        path.add(node.value);

        if(node.value == target && node.left == null && node.right == null){
            paths.add(new ArrayList<>(path));
        } else{
            helper2(node.left, target-node.value, path, paths);
            helper2(node.right, target-node.value, path, paths);
        }
        

        path.remove(path.size() - 1);
}
