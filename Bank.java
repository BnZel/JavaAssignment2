package javafxapplication1;

public class Bank {

    private Account[] accountList;
    private int numAccounts;
    private int maxAccounts;

    public Bank(int max) {

        maxAccounts = max;
        numAccounts = 0;
        accountList = new Account[maxAccounts];

    }

    //PROBLEM?
    public boolean addAccount(long accNum, double bal, String own) {
        if (numAccounts >= maxAccounts) {
        return false;
        }   
        
         Account a = new Account(accNum, bal, own);
            accountList[numAccounts] = a;
            numAccounts++;
            return true;
        
    }
    public int findAccount(long accNum) {
        for (int i = 0; i < numAccounts; i++) {

            if (accountList[i].getAccountNumber() == accNum) 
            {
                return i;
                
            }
        }
        return -1;
    }

    //PROBLEM
    public String printAccounts() {
        
        String tostring = "Account List:";
        for (int i = 0; i < numAccounts; i++) {
            
            tostring += accountList[i].toString(); 
            
        }
        return tostring;
    }

    public void depositAccount(long accNum, double amt) {
        int loc = findAccount(accNum);

        if (loc != -1) {
            accountList[loc].deposit(amt);
        }
       else {
            System.out.println("Cannot find account or Balance invalid");
        }
    }
    public boolean withdrawAccount(long accNum, double amt) {
        int loc = findAccount(accNum);

        if (loc == -1) {
            return false;
        }
        else{

        accountList[loc].withdraw(amt);
        return true;
        }
    }
    
    public boolean transfer(long accNumFrom, long accNumTo, double amt) {
        int loc1 = findAccount(accNumFrom);
        int loc2 = findAccount(accNumTo);

        if (loc1 == -1 || loc2 == -1) {
            return false;
        }
        return (accountList[loc1].transfer(accountList[loc2], amt));

    }

}
