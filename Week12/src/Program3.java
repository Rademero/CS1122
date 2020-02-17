import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Program3 {
    public static void main(String[] args) {
        String fristNext;
        String FileName = args[0];
        System.out.println(FileName);
        File file = new File(FileName);

        try(Scanner scanner = new Scanner(file)) {
            fristNext = scanner.next();
            int frist =Integer.parseInt(fristNext.substring(0,2));
            System.out.println((frist));
            Queue<Character> myQueue = new Queue(frist);
            while (scanner.hasNext()) {
                String next = scanner.next();
                for (int i = 0; i <next.length()-1 ; i++) {
                    if(!myQueue.isFull()){
                        myQueue.enqueue(next.charAt(i));
                    }else {
                        for (int j = myQueue.size-1; j >=0 ; j--) {
                            System.out.print( myQueue.dequeue());
                        }
                        System.out.println("");
                    }
                }

            }
            if (!myQueue.isEmpty()){
                for (int i = myQueue.size-1; i >=0 ; i--) {
                    myQueue.dequeue();
                }
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (QueueFullException e) {
            e.printStackTrace();
        } catch (QueueEmptyException e) {
            e.printStackTrace();
        }
    }
}
