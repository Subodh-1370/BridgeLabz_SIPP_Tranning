import java.util.ArrayList;
import java.util.List;

// BankAccount class
class BankAccount {
    private static int nextAccountNumber = 1001;
    private int accountNumber;
    private double balance;
    private Bank bank;

    // Constructor
    public BankAccount(Bank bank, double initialDeposit) {
        this.accountNumber = nextAccountNumber++;
        this.bank = bank;
        this.balance = initialDeposit;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public Bank getBank() {
        return bank;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= balance)
            balance -= amount;
        else
            System.out.println("Insufficient funds!");
    }
}

// Customer class
class Customer {
    private String name;
    private List<BankAccount> accounts;

    public Customer(String name) {
        this.name = name;
        this.accounts = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    // Called when bank creates an account for this customer
    public void addAccount(BankAccount account) {
        accounts.add(account);
    }

    public void viewBalance() {
        System.out.println("Account details for " + name + ":");
        for (BankAccount account : accounts) {
            System.out.println("Bank: " + account.getBank().getBankName() +
                    ", Account No: " + account.getAccountNumber() +
                    ", Balance: ₹" + account.getBalance());
        }
        System.out.println();
    }
}

// Bank class
class Bank {
    private String bankName;
    private List<Customer> customers;

    public Bank(String bankName) {
        this.bankName = bankName;
        this.customers = new ArrayList<>();
    }

    public String getBankName() {
        return bankName;
    }

    public void openAccount(Customer customer, double initialDeposit) {
        BankAccount account = new BankAccount(this, initialDeposit);
        customer.addAccount(account);
        if (!customers.contains(customer)) {
            customers.add(customer);
        }
        System.out.println("Account opened for " + customer.getName() +
                " in " + bankName + " with Account No: " + account.getAccountNumber());
    }
}

// Main class
public class BankAndAccountHolders {
    public static void main(String[] args) {
        // Create banks
        Bank sbi = new Bank("SBI");
        Bank hdfc = new Bank("HDFC");

        // Create customers
        Customer alice = new Customer("Alice");
        Customer bob = new Customer("Bob");

        // Open accounts
        sbi.openAccount(alice, 5000);
        sbi.openAccount(bob, 3000);
        hdfc.openAccount(alice, 10000); // Alice has account in both banks

        // View balances
        alice.viewBalance();
        bob.viewBalance();
    }
}
