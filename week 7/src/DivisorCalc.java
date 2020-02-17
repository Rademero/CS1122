public class DivisorCalc implements GCDable {
    @Override

//        gcd( num1, num2 ) is num2 if num2 <= num1 and num2 divides num1.
//        gcd( num1, num2 ) is gcd( num2, num1 ) if num1 < num2
//        gcd( num1, num2 ) is gcd( num2, num1 % num2 ) otherwise
    public int gcd(int num1, int num2) {
        if((num2 <= num1)&&(num1 % num2) == 0) {
            return num2;
        }else if (num1 < num2){
           return gcd( num2, num1 );
        }else{
            return gcd( num2, num1 % num2 );
        }
    }
}

