/*Michael Romero
 * CS 1122
 * week 1 program
 * 1/20/19
 * */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

//This method takes a file the reverses the order of the word
//@param reversFile is the file to be reversed
public class wordReversal {
    public static void revers(String reversFile){
        PrintWriter pwt = null;
        ArrayList<String> list = new ArrayList<String>( );
        try {
            pwt = new PrintWriter(reversFile + ".out");
            Scanner in = new Scanner(new File(reversFile));
            while (in.hasNext()){
                list.add(in.next());
            }
            for (int i = list.size()-1; i >=0 ; i--) {
                pwt.print(list.get(i) + " ");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            if (pwt != null) pwt.close();
        }
    }



    public static void main(String[] args) {
        revers("test1.txt");
    }
}
