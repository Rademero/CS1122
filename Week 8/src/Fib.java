import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Fib {
    public int f(int n){
        if (n<2) return n;
        return f(n-1)+f(n-2);
    }

    public long fib(long n){
        ArrayList<Long> list = new ArrayList<>(Arrays.asList(0L,1L));
        return fib(n,list);
    }

    private long fib(long n, ArrayList<Long> list){
        if (list.size() > n){
            return list.get( (int) n);
        }
        long result = fib(n-1,list)+fib(n-2,list);
        list.add(result);
        return result;
    }

    public static void main(String[] args) {
        Fib obj = new Fib();

        for (int i = 0; i <50 ; i++) {


            long start = System.nanoTime();
            System.out.println(obj.fib(i));
            long end = System.nanoTime();
            long duration = end - start;
            System.out.println("fib " + duration);


            long start2 = System.nanoTime();
            System.out.println(obj.f(i));
            long end2 = System.nanoTime();
            long duration2 = end2 - start2;
            System.out.println("f " + duration2);
        }

    }
}
