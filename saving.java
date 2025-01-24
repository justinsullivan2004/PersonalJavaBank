import static java.lang.System.out;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

public class saving {
    private double balance;

    // Constructor to initialize a savings account with a balance
    public saving(double initialBalance) {
        if (initialBalance >= 0) {
            this.balance = initialBalance;
        } else {
            out.println("Initial balance cannot be negative. Setting balance to 0.");
            this.balance = 0;
        }
    }

    // Method to get the current balance
    public double getBalance() {
        return balance;
    }

    // Method to deposit money into the account
    public double deposit(double amount, double balance) {
        if (amount > 0) {
            balance += amount;
            out.println("Deposited: $" + amount);
            out.println("New Balance: $" + balance);
            updateHistory("Deposit", amount, balance);
        } else {
            out.println("Deposit amount must be positive.");
        }
        return balance;
    }

    // Method to withdraw money from the account
    public double withdraw(double amount, double balance) {
        if (amount > 0) {
            if (amount <= balance) {
                balance -= amount;
                out.println("Withdrew: $" + amount);
                out.println("New Balance: $" + balance);
                updateHistory("Withdraw", amount, balance);
            } else {
                out.println("Insufficient funds. Withdrawal denied.");
            }
        } else {
            out.println("Withdrawal amount must be positive.");
        }
        return balance;
    }

    // Method to update the transaction history
    private void updateHistory(String transactionType, double amount, double balance) {
        try {
            FileWriter writer = new FileWriter("Saving_Transaction_History.txt", true);
            writer.write(LocalDate.now() + ": " + transactionType + ": $" + amount + "\tNew Balance: $" + balance + "\n");
            writer.close();
        } catch (IOException e) {
            out.println("An error occurred while updating the transaction history.");
        }
    }
}
