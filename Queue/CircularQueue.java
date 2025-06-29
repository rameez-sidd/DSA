package Queue;

public class CircularQueue {
    protected int[] data;
    private static final int DEFAULT_SIZE = 10;

    protected int front = 0;
    protected int end = 0;

    private int size = 0;

    public CircularQueue(){
        this(DEFAULT_SIZE);
    }

    public CircularQueue(int size){
        this.data = new int[size];
    }

    public boolean insert(int item){
        if(isFull()){
            System.out.println("Queue is Full");
            return false;
        }
        data[end++] = item;
        end = end % data.length;
        size++;
        return true;
    }

    public int remove() throws Exception{
        if(isEmpty()){
            throw new Exception("Empty Queue");
        }

        int removed = data[front++];
        front = front % data.length;
        size--;
        return removed;
    }

    public int front() throws Exception{
        if(isEmpty()){
            throw new Exception("Empty Queue");
        }

        return data[front];
    }

    public void display(){
        if(isEmpty()){
            System.out.println("Empty Stack");
            return;
        }
        int i = front;
        do{
            System.out.print(data[i] + " <- ");
            i++;
            i = i % data.length;

        }while(i != end);
        System.err.println("END");
    }

    public boolean isFull(){
        return size == data.length;
    }

    public boolean isEmpty(){
        return size == 0;
    }



    
    public static void main(String[] args) throws Exception {
        CircularQueue queue = new CircularQueue(5);
        queue.insert(12);
        queue.insert(34);
        queue.insert(9);
        queue.insert(54);
        queue.insert(89);
        queue.display();
        
        queue.remove();
        queue.display();

        queue.insert(23);

        queue.display();

        
    }
}
