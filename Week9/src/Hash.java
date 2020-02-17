import java.util.HashMap;

public class Hash {
    public static void main(String[] args) {
        HashMap<String,String> contacts = new HashMap<>();
        contacts.put("Bob","gmail@gmail.com" );
        contacts.put("frank","frank@gmail.com" );
        contacts.put("other","stuff@gmail.com" );
        contacts.put("contact","infor@gmail.com" );

        System.out.println(contacts.get("Bob"));
        for (String name:contacts.keySet()){
            System.out.printf("%s : %s\n",name,contacts.get(name) );
        }
    }
}
