package Heaps;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;

class MaxHeap<T extends Comparable<T>> {
    private ArrayList<T> list;

    public MaxHeap() {
        list = new ArrayList<>();
    }

    public MaxHeap(ArrayList<T> arr) {
        list = new ArrayList<>(arr);
    }

    public void insert(T value) {
        list.add(value);
        upHeap(list.size() - 1);
    }

    private void upHeap(int index) {
        if (index == 0) {
            return;
        }
        int p = parent(index);
        if (list.get(index).compareTo(list.get(p)) > 0) {
            swap(index, p);
            upHeap(p);
        }

    }

    public T remove() throws Exception {
        if (list.isEmpty()) {
            throw new Exception("Heap is empty");
        }

        T removed = list.get(0);
        T last = list.remove(list.size() - 1);
        if (!list.isEmpty()) {
            list.set(0, last);
            downHeap(0);
        }
        return removed;
    }

    private void downHeap(int index) {
        int max = index;
        int left = left(index);
        int right = right(index);

        if (left < list.size() && list.get(max).compareTo(list.get(left)) < 0) {
            max = left;
        }
        if (right < list.size() && list.get(max).compareTo(list.get(right)) < 0) {
            max = right;
        }

        if(max != index){
            swap(max, index);
            downHeap(max);
        }
    }

    public ArrayList<T> heapSort() throws Exception {
        ArrayList<T> sortedList = new ArrayList<>();
        while(!list.isEmpty()){
            sortedList.add(0, this.remove());
        }

        return sortedList;
    }

    public void constructHeapUnsortedArray() {
        int n = list.size();
        for (int i = (n / 2) - 1; i >= 0; i--) {
            downHeap(i);
        }
    }

    private int parent(int index) {
        if (index == 0) {
            return -1; // No parent for the root
        }
        return (index - 1) / 2;
    }

    private int left(int index) {
        return 2 * index + 1;
    }

    private int right(int index) {
        return 2 * index + 2;
    }

    private void swap(int first, int second) {
        T temp = list.get(first);
        list.set(first, list.get(second));
        list.set(second, temp);
    }
    public ArrayList<T> getList() {
        return list;
    }
}

public class MaxHeapDS {
    public static void main(String[] args) throws Exception {
        // ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(4, 1, 3, 2, 16, 9, 10, 14, 8, 7));
        // System.out.println(arr);

        // MaxHeap<Integer> heap = new MaxHeap<>(arr);
        // heap.constructHeapUnsortedArray();
        // System.out.println(heap.getList());

        

        MaxHeap<Integer> heap = new MaxHeap<>();

        heap.insert(34);
        heap.insert(45);
        heap.insert(22);
        heap.insert(89);
        heap.insert(76);

        // System.out.println(heap.remove());
        // System.out.println(heap.remove());
        // System.out.println(heap.remove());
        // System.out.println(heap.remove());
        // System.out.println(heap.remove());

        ArrayList<Integer> sorted = heap.heapSort();
        System.out.println(sorted);


    }
}
