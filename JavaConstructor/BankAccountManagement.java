public class BankAccountManagement {
    public String accountNumber;
    protected String accountHolder;
    private double balance;

    public BankAccountManagement(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= balance)
            balance -= amount;
        else
            System.out.println("Insufficient Balance");
    }

    public double getBalance() {
        return balance;
    }
}

class SavingsAccount extends BankAccountManagement {
    public SavingsAccount(String accountNumber, String accountHolder, double balance) {
        super(accountNumber, accountHolder, balance);
    }

    public void showAccountDetails() {
        System.out.println("Account No: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
    }

    public static void main(String[] args) {
        SavingsAccount sa = new SavingsAccount("001", "Ravi", 10000);
        sa.showAccountDetails();
        sa.deposit(2000);
        sa.withdraw(500);
        System.out.println("Balance: ₹" + sa.getBalance());
    }
}