public class Account {
    
    private long accountNum;
    private double balance;
    private String ownerInfo;
    
    public Account(long accountNumber, double balance, String ownerInfo){
        this.accountNum = accountNumber;
        this.balance = balance;
        this.ownerInfo = ownerInfo;        
    }
    
    public long getAccountNumber()
    {
        return accountNum;
    }
    public double getBalance(){
        return balance;
    }
    public String getOwner(){
        return ownerInfo;
    }
    
    public boolean withdraw(double amt){
        if(amt < balance){
            balance = balance - amt;
            return true;
        }
        return false;
    }

    public void deposit(double amt){
        
           this.balance += amt;
       
    }
    public boolean transfer(Account a, double amt){
        if(withdraw(amt)){
            a.deposit(amt);
            return true;
        }
        return false;
    }
    
    public String toString(){ 
        return "\nAccount number: " + getAccountNumber() 
            + "\tBalance: " + getBalance() + "\tOwner:" + getOwner() + "\n";
    }
}
