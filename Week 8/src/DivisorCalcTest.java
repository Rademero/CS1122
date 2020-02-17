public class DivisorCalcTest {
    public static void main(String[] args) {
        DivisorCalc dv = new DivisorCalc();
        for (int i = 0; i <100 ; i++) {
                int n1 = (int)(Math.random() * 100);
                int n2 = (int)(Math.random() * 100);
                System.out.println("N1 = "+ n1 + " N2 = "+n2);
            System.out.println(dv.gcd(n1,n2));
        }

    }
}
