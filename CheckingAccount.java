import static java.lang.System.out;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
public class CheckingAccount {

    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";

    private double balance;

    public CheckingAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public double deposit(double amount, double balance) {
        if (amount > 0) {
            balance += amount;
            out.println("Deposited: "+ GREEN + "$" + amount + RESET);
            out.println("New Balance: $" + balance);
            UpdateHistory("Deposit", amount, balance);
        } else {
            out.println("Deposit amount must be positive.");
        }
        return balance;
    }

    public double withdraw(double amount, double balance) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            out.println("Withdrew: "+ RED + "$" + amount + RESET);
            out.println("New Balance: " + balance);
            UpdateHistory("Withdraw", amount, balance);
        } else if (amount > balance) {
            out.println("Insufficient funds.");
        } else {
            out.println("Withdrawal amount must be positive.");
        }
        return balance;
    }

    public void UpdateHistory(String TransactionType, double amount, double balance) {
        try {
            FileWriter writer = new FileWriter("Transaction_History.txt", true);
            writer.write(LocalDate.now() + ": " + TransactionType + ": $" + amount + "\tNew balance $" + balance + "\n");
            writer.close();
        } catch (IOException e) {
            out.println("An error occurred while updating the history.");
        }
    }

}
