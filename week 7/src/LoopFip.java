import java.util.Scanner;

public class LoopFip {
    public static int fibCount = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter n: ");
        int n = in.nextInt();

        for (int i = 1; i <= n ; i++) {
            long f = fip(i);
            System.out.println("fip(" + i + ") = "+f);
        }
        System.out.println("Fib Cout: " + fibCount);
    }

    public static long fip(int n){
        if (n<=2){
            return 1;
        }else {
            fibCount+=1;
            return fip(n-1)+fip(n-2);
        }
    }
}
