import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Queue <E extends Comparable> extends QueMain<E> implements QueueInterface<E> {
    private int sizeLimit;
    public Queue (int sizeLimit){
        this.sizeLimit = sizeLimit;
    }

    @Override
    /***  Adds one element to the rear of this queue.
     * *  @param element  the element to be added to the rear of the queue*/
    public void enqueue(E element) throws QueueFullException {
        if(isFull()){
            throw new QueueFullException();
        }
        add(element);
    }

    @Override
    /***  Removes and returns the element at the front of this queue.*
     * @return the element at the front of the queue*/
    public E dequeue() throws QueueEmptyException {
        if(isEmpty()){
            throw new QueueEmptyException();
        }
        E value = peek();
        remove(0);
        return value;
    }

    @Override
    /***  Returns without removing the element at the front of this queue.
     * *  @return the first element in the queue*/
    public E peek() throws QueueEmptyException {
        if(isEmpty()){
            throw new QueueEmptyException();
        }
        return get(0);
    }

    @Override
    /***  Returns true if this queue contains the maximum number of elements.
     * *  @return true if this queue is full*/
    public boolean isFull() {
        return size() >=sizeLimit;
    }

//    public static void main(String[] args) {
//        File file = new File("in.txt");
//        try(Scanner scanner = new Scanner(file)) {
//            scanner.useDelimiter("");
//            char in = scanner.next().charAt(0);
//        }catch (FileNotFoundException e){
//            e.printStackTrace();
//        }
//        Queue<Integer> queue = new Queue<>(10);
//        for (int i = 1; i <10 ; i++) {
//            try {
//                queue.enqueue(i);
//            } catch (QueueFullException e) {
//                e.printStackTrace();
//                break;
//            }
//        }
//        while (!queue.isEmpty()){
//            try {
//                System.out.println(queue.dequeue());
//            } catch (QueueEmptyException e) {
//                e.printStackTrace();
//                break;
//            }
//        }
//    }
}
