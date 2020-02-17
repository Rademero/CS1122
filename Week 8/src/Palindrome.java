public class Palindrome {
    public static void main(String[] args) {
        System.out.println(palin("aba"));
        System.out.println(palin("abab"));
    }


    public static boolean palin(String s){
        String temp = reverseIt(s);
        temp.toLowerCase();
        s.toLowerCase();
        if (s.equals(temp)){
            return true;
        }else {
            return false;
        }
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
