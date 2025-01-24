import java.util.HashMap;
import java.util.Scanner;

public class program 
{
    public static void main(String[] args)
    {
        Account selected_account = new Account("No account selected");
        HashMap<Integer, Account> accounts = new HashMap<>();
        Scanner scan = new Scanner(System.in);
        int choice;
        // double checking_balance = 0.00;
        // double saving_balance = 0.00;
        // String name;

        
        CheckingAccount checkingAccount = new CheckingAccount(0.00); // Initialize with a starting balance of 0.00
        saving savingAccount = new saving(0.00);

        do 
        {
            System.out.println("=======Menu=======");
            System.out.println("1. Select Profile");
            System.out.println("2. Print Account Information");
            System.out.println("3. Check Balance");
            System.out.println("4. Deposit");
            System.out.println("5. Withdraw");
            System.out.println("6. Make an account");
            System.out.println("7. Exit");
            System.out.print("Please enter a number: ");

            choice = scan.nextInt();

            switch(choice)
            {
                case 1:
                    accounts.forEach((key, value) -> System.out.println("Routing Number: " + key + ", Name: " + value.get_name()));
                    System.out.println("Enter Routing Number: ");
                    int selected_routing_number = scan.nextInt();
                    selected_account = accounts.get(selected_routing_number);
                    break;

                case 2:
                    System.out.println("Account info: ");
                    selected_account.print_account();
                    break;

                case 3:
                    System.out.println("Check Balance: ");
                    System.out.println(selected_account.get_checking_balance());
                    System.out.println(selected_account.get_saving_balance());
                    break;

                case 4: 
                    System.out.println("Deposit: ");
                    System.out.println("Which account do you want to deposit to?");
                    System.out.println("1. Checking\n2. Saving");

                    int account_choice = scan.nextInt();

                    if (account_choice == 1)
                    {
                         System.out.println("Enter deposit amount: ");
                         double amount = scan.nextDouble();
                         double balance = selected_account.get_checking_balance();
                         balance = checkingAccount.deposit(amount, balance);
                         selected_account.set_checking_balance(balance);
                     }
                     else if (account_choice == 2)
                     {
                         System.out.println("Enter deposit amount: ");
                         double amount = scan.nextDouble();
                         double balance = selected_account.get_saving_balance();
                         balance = savingAccount.deposit(amount, balance);
                         selected_account.set_saving_balance(balance);
                     }
                     break;

                case 5:
                    System.out.println("What account would you like to withdraw from? ");
                    System.out.println("1. Checking account");
                    System.out.println("2. Savings account");
                    int decision = scan.nextInt();
                    if (decision == 1)
                    {
                        System.out.println("Withdraw: ");
                        System.out.println("Enter the amount you would like to withdraw: ");
                        double withdraw_amount = scan.nextDouble();
                        double balance = selected_account.get_checking_balance();
                        balance = checkingAccount.withdraw(withdraw_amount, balance);
                        selected_account.set_checking_balance(balance);
                    }
                    else if (decision == 2) 
                    {
                        System.out.println("Withdraw: ");
                        System.out.println("Enter the amount you would like to withdraw: ");
                        double withdraw_amount = scan.nextDouble();
                        double balance = selected_account.get_saving_balance();
                        balance = savingAccount.withdraw(withdraw_amount, balance); // Error occurs here
                        selected_account.set_saving_balance(balance);
                    }
                    break;

                case 6:
                    Account new_account = new Account();
                    accounts.put(new_account.get_routing_number(), new_account);
                    break;

                case 7:
                    System.out.println("Exiting the bank, thank you!");
                    break;

                default:
                    System.out.println("Please enter a correct menu choice: ");
                    choice = scan.nextInt();
            }

        } while(choice != 7);
        
        scan.close();
    }
}