
public class ArraySort {
   public static int[] anArray;

    //@param array is an array of ints
    //@param n is the total length of the array

    public static void NumaricalOrder(int[] array,int n) {
        if (n == 1) {
            return;
        }
        for (int i = 0; i < n - 1; i++) {
            if (array[i] > array[i + 1]) {
                int temp = array[i+1];
                array[i + 1] = array[i];
                array[i] = temp;
            }
        }
        NumaricalOrder(array, n - 1);
    }

    }
