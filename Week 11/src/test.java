import java.util.LinkedList;

public class test {
    public static void main(String[] args) {

        LinkedList<String> words = new LinkedList<String>();
        words.addFirst("xyz");
        words.addLast("jkl");
        words.addLast("def");
        System.out.print(words.removeFirst());
        System.out.print(words.removeLast());
        System.out.print(words.removeLast());
    }
}
