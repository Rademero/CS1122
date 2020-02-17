public class test {
    public static void main(String[] args) {
        BanckAccount myAccount = new BanckAccount(1000);
        myAccount.deposit(500);
        myAccount.withdraw(2000);
        myAccount.addInterest(1);
        System.out.printf("%.2f%n",myAccount.getBalance());
        System.out.println("Expected: 1504.90");
    }
}
