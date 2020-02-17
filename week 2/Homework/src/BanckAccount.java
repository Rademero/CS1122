public class BanckAccount {
    private static double balance;

    public double getBalance(){
        return balance;
    }
    public void deposit (double amount){
        balance = balance + amount;
    }
    public void withdraw (double amount){
        final double Penalty = 10;
        if(amount > balance){
            balance = balance - Penalty;
        }else{
            balance = balance - amount;
        }
    }
    public void addInterest (double rate){
        Double amount = balance * rate / 100;
        balance = balance + amount;
    }
    public BanckAccount(){
        balance = 0;
    }
    public BanckAccount(double initialBalance){
        balance = initialBalance;
    }

}
