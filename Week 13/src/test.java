import java.util.Arrays;
public class test
{
    public static void findProduct(int[] A)
    {
        int n = A.length;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = 1;
        for (int i = 1; i < n; i++) {
            left[i] = A[i - 1] * left[i - 1];
        }
        right[n - 1] = 1;
        for (int j = n - 2; j >= 0; j--) {
            right[j] = A[j + 1] * right[j + 1];
        }
        for (int i = 0; i < n; i++) {
            A[i] = left[i] * right[i];
        }
    }
    public static void main(String[] args)
    {
        int[] A = { 5, 3, 4, 2, 6, 8 };
        findProduct(A);
        System.out.println(Arrays.toString(A));
    }
}
