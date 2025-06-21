package OOPS.CustomArraylist;

import java.util.Arrays;

public class CustomGenericArrayList<T> {
    private Object[] data;
    private static int DEFAULT_SIZE = 10;
    private int size = 0;

    public CustomGenericArrayList(){
        this.data = new Object[DEFAULT_SIZE];
    }

    public void add(T element){
        if(isFull()){
            resize();
        }

        data[size++] = element;


    }

    public T remove(){
        T removed = (T)(data[--size]);
        return removed;
    }

    public T get(int index){
        return (T)data[index];
    }

    public int size(){
        return size;
    }

    public void set(int index, T value){
        data[index] = value;
    }

    private boolean isFull(){
        return size == data.length;
    }

    private void resize(){
        Object[] temp = new Object[data.length * 2];

        // copy the current items in the new array
        for(int i=0; i < data.length; i++){
            temp[i] = data[i];
        }

        data = temp;

    }

    public String toString(){
        return "CustomGenericArrayList{" + "data = " + Arrays.toString(data) + ", size = " + size + "}";
    }

    public static void main(String[] args) {
        CustomGenericArrayList<Integer> list = new CustomGenericArrayList<>();
        for(int i=1; i<=14; i++){
            list.add(i);
        }

        System.out.println(list);

        CustomGenericArrayList<String> stringList = new CustomGenericArrayList<>();
        for(int i=1; i<=14; i++){
            stringList.add("String-" + i);
        }

        System.out.println(stringList);
    }





}
