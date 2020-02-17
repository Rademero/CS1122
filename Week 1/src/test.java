import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class test {

    public static void main(String[] args) {//Just to test my files
        ContactList test = new ContactList();
        test.addEntry("MichaelRomero","Romerom18.mr@gmail.com");
        test.addEntry("name","email");
        test.addEntry("name2","Stilltesting@wut.com");
        test.storeContacts("File.out");
        ContactList test2 = new ContactList().loadContacts("File.out");
        for (int i = 0; i < test2.list.size(); i++) {
                System.out.print(test2.list.get(i).name + ": " + test2.list.get(i).email + "\n");
        }
        test2.storeContacts("File.out.2");
        System.out.println(test.getEmail("MichaelRomero"));
    }

}
