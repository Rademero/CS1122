import java.util.ArrayList;


public class Polidrone {
    static <E> boolean isPalindrome(ArrayList<E> in)
    {
        int front  = 0;
        int back = in.size() - 1;
        while( front < back)
            if (!in.get(front +=1).equals(in.get(back-=1))) {
                return false;
            }
        return true;
    }


    public static void main(String[]args){
        ArrayList<String> strings = new ArrayList<>();
        strings.add("why");
        strings.add("why");
System.out.println(isPalindrome(strings));

ArrayList<Integer> integers = new ArrayList<>();
        integers.add(3);
        integers.add(3);
        System.out.println(isPalindrome(integers));
    }
}
