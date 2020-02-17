/*Michael Romero
 * CS 1122
 * week 2 program
 * 1/25/19
 * */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

class ContactList {
    PrintWriter pwt = null;
    static Scanner in;
    ArrayList<ContactEntry> list = new ArrayList<ContactEntry>( );
    int entries = 0; // Actual number of entries in the list.

    public ContactList() {
        this.list = list;
        this.entries = entries;
    }

    void addEntry(String name, String email) {
        // Add a new item at the end of the list.
        ContactEntry entry = new ContactEntry(name,email);
        list.add( entry );
        entries++;
    }

    public String getEmail(String name) {
        // Return email associated with name,
        // or return null if the name does not occur in the list.
        for (int index = 0; index < entries; index++) {
            ContactEntry entry = list.get(index);
            if (name.equals( entry.name )) { // Found it!
                return list.get ( index ).email;
            }
        }
        return null; // Name wasn't found.
    }
    public void deleteEntery(int index,String file){
        //Deletes the entree at index of index
        //resets the contacts list
        list.remove(index);
        storeContacts(file);
    }
    public void ChangeEmail(int index,String file,String email){
        //changes the email and resets the contacts list
       list.get(index).email = email;
       storeContacts(file);
    }


    public ArrayList<ContactEntry> getList() {
        return list;
    }

    public void setList(ArrayList<ContactEntry> list) {
        this.list = list;
    }

    public int getEntries() {
        return entries;
    }

    public void setEntries(int entries) {
        this.entries = entries;
    }
    //This method stores a the list into a file
    //@param filepath is the path that needs to be printed to
    public void storeContacts( String filepath ){
        try {
            pwt = new PrintWriter(filepath);
            for (int i = 0; i < list.size(); i++) {
                pwt.print(getList().get(i).name + ": " + getList().get(i).email +"\n");
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }finally {
            if (pwt != null)  pwt.close();
        }
    }
    //This method loads a file and prints it into a new contacts list.
    //@param filepath is the path that needs to be loaded
    //@return loadFile witch is a new contacts list.
    public static ContactList loadContacts( String filepath ){
        File fileN = new File(filepath);
        try {
            in = new Scanner(fileN);
            ContactList loadFile = new ContactList();

            while (in.hasNext()) {
                String temp = in.next();//Name
                String temp2 = in.next();//Email
                if (temp.contains(":")){//this is to catch a possible error in  the loud method.
                    temp = temp.substring(0,temp.length()-1);
                }
                loadFile.addEntry(temp,temp2);//adds the names/emails to the list
            }
            return loadFile;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }


}