import java.util.ArrayList;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class MyList<E extends Comparable> {
    private class Node{
        E value;
        Node nextNode;
        public Node(E value){
            this.value = value;
        }
    }
    Node fristNode = null;
    Node lastNode = null;
    int size =0;

    public E get(int index){
        if (index < 0 || index >= size){
            throw new ArrayIndexOutOfBoundsException(index);
        }
        int count =0;
        Node current = fristNode;
        while (count != index){
            current = current.nextNode;
            count++;
        }
        return current.value;
    }
    public void add(E value){
        Node newNode = new Node(value);
        if(isEmpty()){
            fristNode = newNode;
            lastNode = newNode;
        }else {
            lastNode.nextNode = newNode;
            lastNode = newNode;
        }
        size++;
    }
    public void add(int index, E value) {
        if (index < 0 || index > size()) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        int count = 0;
        Node current = fristNode;
        Node pre = null;
        while (count != index) {
            pre = current;
            current = current.nextNode;
            count++;
        }
        Node newNode = new Node(value);
        if (pre == null) {
            newNode.nextNode = fristNode;
            fristNode = newNode;
        } else if (current == null) {
            newNode.nextNode = null;
            pre.nextNode = newNode;
            lastNode = newNode;
        } else {
            newNode.nextNode = pre.nextNode;
            pre.nextNode = newNode;
        }
        size++;

    }

    public void remove(E value){
      Node current = fristNode;
      Node pre = null;
       while (current !=null&& !value.equals(current.value)){
           pre = current;
           current = current.nextNode;
       }
       if ( current == null){
           throw  new NoSuchElementException();
       }
       if ((pre == null)){
           fristNode = current.nextNode;
       }else {
           pre.nextNode = current.nextNode;
       }
       current.nextNode = null;
       size--;
    }
    public boolean isEmpty(){

        return size == 0;
    }
    public int size(){

        return size;
    }

    public static void main(String[] args) {
        MyList<Integer> list = new MyList<>();
        list.add(10);
        list.add(5);
        list.add(6);
        list.remove(10);
        for (int i = 0; i < list.size() ; i++) {
            System.out.println(list.get(i));

        }
        list.add(1,100);
        list.add(0,100);
        list.add(list.size,100);
        for (int i = 0; i < list.size() ; i++) {
            System.out.println(list.get(i));

        }
    }


}
