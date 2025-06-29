class CustomStack {
    protected int[] data;
    private static final int DEFAULT_SIZE = 10;
    int ptr = -1;

    public CustomStack(){
        this(DEFAULT_SIZE);
    }

    public CustomStack(int size){
        this.data = new int[size];
    }

    public boolean push(int item){
        if(isFull()){
            System.out.println("Stack Overflow");
            return false;
        }

        ptr++;
        data[ptr] = item;
        return true;
    }

    public int pop() throws StackException{
        if(isEmpty()){
            throw new StackException("Empty Stack");
        }
        // int removed = data[ptr];
        // ptr--;
        // return removed;

        return data[ptr--];
    }

    public int peek() throws StackException{
        if(isEmpty()){
            throw new StackException("Empty Stack");
        }
        return data[ptr];
    }

    public boolean isFull(){
        return ptr == data.length - 1;
    }

    public boolean isEmpty(){
        return ptr == -1;
    }

}


class StackException extends Exception{
    StackException(String message){
        super(message);
    }
    
}


public class DynamicStack extends CustomStack{

    public DynamicStack(){
        super();
    }

    public DynamicStack(int size){
        super(size);
    }

    @Override
    public boolean push(int item){

        if(this.isFull()){
            // double the array size
            int[] temp = new int[data.length * 2];

            // copy all previous items in new data
            for(int i=0; i<data.length; i++){
                temp[i] = data[i];
            }

            data = temp;
        
        }

        // at this point we know array is not full, So we can insert normally
        return super.push(item);
    }

    public static void main(String[] args) throws StackException {
        DynamicStack stack = new DynamicStack(5);
        stack.push(3);
        stack.push(5);
        stack.push(12);
        stack.push(78);
        stack.push(43);
        stack.push(90);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
