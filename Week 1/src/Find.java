/*
* Michael Romero
* CS 1122
* Exercise 1 question 4
* 1/18/2019 last day of work
* */


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

//Reads in several arguments and selects one word, than prints every line with that word.
public class Find {
    public static void main(String[] args) {
        PrintWriter pwt = null;
        Scanner in;
        if (args!= null) {
            String seek = args[0];
            File file;


                try {
                    pwt = new PrintWriter("Out.dat");
                    for (int i = 1; i < args.length ; i++) {
                        file = new File(args[i]);
                        in = new Scanner(file);
                        while (in.hasNext()) {
                            String temp = in.nextLine();
                            if (temp.contains(seek)) {
                                pwt.print(args[i] + ": " + temp + "\n");
                            }
                        }
                    }
                }catch (FileNotFoundException e){
                   e.printStackTrace();
                }finally {
                  if (pwt != null)  pwt.close();
                }
        }else {
            System.out.println("You need some arguments to pass in");
        }


    }
}
