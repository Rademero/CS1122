import javax.swing.text.html.HTMLDocument;
import java.util.*;
import java.util.function.Consumer;

public class MyArray <E> implements Iterable<E> {
    private E[] array = (E[]) new Object[0];
   private int changeCount = 0;

    public MyArray(int initialSize) {
        array = (E[]) new Object[initialSize];
    }

   public void MyArray(){
       //Dose nothing
   }

    @Override
    public Iterator <E> iterator() {
       Iterator<E> iterator = new MyIterator();
        return iterator;
    }
    public class MyIterator implements Iterator<E>{
        int intialChangeCount = changeCount;
        int index = 0;
        @Override
        public boolean hasNext() {
            return index < size()-1;
        }

        @Override
        public E next() {
            if(intialChangeCount != changeCount){
                throw  new ConcurrentModificationException();
            }
            if(!hasNext()){
                throw new NoSuchElementException();
            }
                return array[++index];

        }
    }
    public E get(int index){
        if (index>=array.length){
            extandArray(index+1);
        }
        return array[index];
    }
    private void extandArray(int newLangth){
        E[] tempArray = (E[]) new Object[newLangth];
        for (int i = 0; i <array.length ; i++) {
          tempArray[i] = array[i];
        }
        array = tempArray;
        changeCount++;
    }
    public void set(int index, E element) {
        if (index>=array.length){
            extandArray(index+1);
        }
        array[index] = element;

    }
    public String toString(){
        return Arrays.toString(array);
    }
    public int size(){
        return array.length;
    }
    public boolean isEmpty(){
        return size() == 0;
    }
    public boolean equals(MyArray<E> anotherArray){
        if(this == anotherArray)return true;
        if (anotherArray == null)return false;

        for (int i = 0; i <size() ; i++) {
            if(!array[i].equals(anotherArray.get(i))){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        MyArray<Integer> theArray = new MyArray<>(10);
        MyArray<Integer> theArray2 = new MyArray<>(10);
        MyArray<Integer> theArray3 = new MyArray<>(10);
        for (int i = 0; i <16 ; i++) {
            theArray.set(i,new Integer(i));
            theArray2.set(i,new Integer(i));
            theArray3.set(i,new Integer(i-1));
        }

        System.out.println(theArray.toString());
        System.out.println(theArray3.toString());
        System.out.println(theArray.equals(theArray2));
        System.out.println(theArray.equals(theArray3));

    }
}
