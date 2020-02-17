public class test<E>
{
    private MyNode first;
    public test(E e)
    {
        first = new MyNode();
        first.data = e;
        first.next = null;
    }

    public E getFirst() { return first.data; }

    private class MyNode
    {
        private E data;
        private MyNode next;
    }
    public static <T> void fun(T[] t){

    }
    public class SomeClass implements YourInterface<String, Double>{

    }
    public class SomeClass2 implements YourInterface{

    }
    public class SomeClass3 implements YourInterface<String>{

    }

    public static void main(String[] args)
    {
        test<String> list = new test<>("Hello");
        System.out.println("List first element = " + list.getFirst());
    }
}

