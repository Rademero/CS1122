import java.util.Random;

import static java.lang.Math.sqrt;

public class InClass implements FindPi {
    public static int count;
    public static void main(String[] args) {
        InClass inClass = new InClass();
        count = 0;
        System.out.println(inClass.calculatePi(100000000,10000000));
    }

   @Override
    public long gcd(long num1, long num2) {
        if((num2 <= num1)&&(num1 % num2) == 0) {
            return num2;
        }else if (num1 < num2){
            return gcd( num2, num1 );
        }else{
            return gcd( num2, num1 % num2 );
        }
    }

    @Override
    public double calculatePi(long max, int range) {
        for (int i = 0; i < range; i++) {
            Random tepRand = new Random();
            int num1 = tepRand.nextInt((int) max)+1;
            int num2 = tepRand.nextInt((int) max)+1;
            int test = (int) gcd(num1, num2);
            if (test == 1) {
                count++;
            }

        }

        return sqrt( 6/((double) count/(double) range));
    }
}
