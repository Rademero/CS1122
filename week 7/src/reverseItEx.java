public class reverseItEx {
    public static void main(String[] args) {
        System.out.println(reverseIt("Hello!"));
    }
    public static String reverseIt(String s)
    {
        if (s.length() <= 1)
        {

            return s;
        }
        else
        {
            return reverseIt(s.substring(1)) + s.charAt(0);

        }
    }
}
