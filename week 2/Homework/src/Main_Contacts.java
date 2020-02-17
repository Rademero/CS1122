/*Michael Romero
 * CS 1122
 * week 2 program
 * 1/25/19
 * */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main_Contacts {
    static Scanner in;
    static Scanner nameIn;
    static ArrayList<String> name;
    public static void main(String[] args) {
        File file = new File("contactsList.dat");
        ContactList contacts = new ContactList().loadContacts("contactsList.dat");
        contacts.storeContacts("contactsList.dat");
        in = new Scanner(System.in);
        boolean wantRun = true;
        while (wantRun){
        System.out.println("Write the number of what you want to do" + "\n" + "1.Look up an email address.\n" +
                "2.Add an entry to the contacts list.\n" +
                "3.Delete an entry from the list.\n" +
                "4.Change someone's email.\n" +
                "5.Quit the program. ");
        int temp = in.nextInt();
            if (temp == 1){
                int count = 1;
                GetNames(file);
                System.out.println("Write the number of what you want to do");
                for (int i = 0; i < name.size(); i++) {
                    System.out.println(count + "." + name.get(i));
                    count++;
                }
                temp = in.nextInt();
                System.out.println(contacts.getEmail(name.get(temp - 1)));

            } else if (temp == 2){
                System.out.println("Enter a name, use _ as spaces");
                String nameIn = in.next();
                System.out.println("Enter the email");
                String emailIn = in.next();
                contacts.addEntry(nameIn,emailIn);
                contacts.storeContacts("contactsList.dat");
            }else if (temp == 3){
                int count = 1;
                GetNames(file);
                System.out.println("Write the number of what you want to do");
                for (int i = 0; i < name.size(); i++) {
                    System.out.println(count + "." + name.get(i));
                    count++;
                }
                temp = (in.nextInt() -1);
                contacts.deleteEntery(temp,"contactsList.dat");
                contacts.storeContacts("contactsList.dat");

            }else if (temp == 4){
                int count = 1;
                GetNames(file);
                System.out.println("Write the number of what you want to do");
                for (int i = 0; i < name.size(); i++) {
                    System.out.println(count + "." + name.get(i));
                    count++;
                }temp = (in.nextInt() -1);
                System.out.println("Enter an email without spaces");
                String et = in.next();
                contacts.ChangeEmail(temp,"contactsList.dat",et);
                contacts.storeContacts("contactsList.dat");

            }else if (temp == 5){
            wantRun = false;
            System.out.println("Program is closed");
        }

        }
    }

    private static void GetNames(File file) {
        //gets the names from the contacts list.
        try {
            name  = new ArrayList<String>();
            for (int i = 0; i < name.size() ; i++) {
                name.remove(i);
            }
            nameIn = new Scanner(file);
            while (nameIn.hasNext()) {
                String temps = nameIn.next();//Name
                if (temps.contains(":")) {//this is to catch a possible error in  the loud method.
                    temps = temps.substring(0, temps.length() - 1);
                    name.add(temps);
                }
            }
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
