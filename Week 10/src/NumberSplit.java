import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class NumberSplit {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a number");
        int number = in.nextInt();
        Stack<Integer> stack = new Stack<>();
        while (number > 0) {
            stack.push( number % 10 );
            number = number / 10;
        }

        while (!stack.isEmpty()) {
            System.out.print("," +stack.pop()  + " ");
        }
    }
}
