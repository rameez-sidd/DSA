package Queue;

public class CustomQueue {
    protected int[] data;
    private static final int DEFAULT_SIZE = 10;
    int end = 0;

    public CustomQueue(){
        this(DEFAULT_SIZE);
    }

    public CustomQueue(int size){
        this.data = new int[size];
    }

    public boolean insert(int item){
        if(isFull()){
            System.out.println("Queue is Full");
            return false;
        }
        data[end++] = item;
        return true;
    }

    public int remove() throws Exception{
        if(isEmpty()){
            throw new Exception("Empty Queue");
        }

        int removed = data[0];

        for(int i=1; i < end; i++){
            data[i-1] = data[i];
        }
        end--;

        return removed;
    }

    public int front() throws Exception{
        if(isEmpty()){
            throw new Exception("Empty Queue");
        }

        return data[0];
    }

    public void display(){
        for(int i=0; i<end; i++){
            System.out.print(data[i] + " <- ");
        }
        System.err.println("END");
    }

    public boolean isFull(){
        return end == data.length;
    }

    public boolean isEmpty(){
        return end == 0;
    }






    public static void main(String[] args) throws Exception {
        CustomQueue queue = new CustomQueue(5);
        queue.insert(12);
        queue.insert(34);
        queue.insert(9);
        queue.insert(54);
        queue.insert(89);

        queue.display();
        
        System.out.println(queue.remove());
        queue.display();
    }
}
