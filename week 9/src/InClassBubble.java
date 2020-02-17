import java.util.Arrays;

public class InClassBubble {
    public int[] bubblesort(int [] array){
        int [] results = new int [array.length];
        for (int i = 0; i < array.length; i++) {
            results[i] = array[i];
        }
        //Shorts the array

        for (int i = 0; i <results.length ; i++) {
            for (int j = 1; j < results.length; j++) {
                if (results[j-1] > results[j]){
                    int temp = results[j-1];
                    results[j-1] = results[j];
                    results[j] =temp;
                }

            }
//n^2 big o notaition
        }
        return results;
    }

    public static void main(String[] args) {
        InClassBubble sortsDemo = new InClassBubble();
        System.out.println(Arrays.toString(sortsDemo.bubblesort(new int [] { 9,6,7,8,3,4,6,1}))) ;
    }
}
