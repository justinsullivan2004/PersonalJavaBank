import java.util.Random;
import java.util.Scanner;

class Account {

    private static Random rand = new Random();
    Scanner scan = new Scanner(System.in);


    private String name;
    private int routing_number;
    private double checking_balance = 0.00;
    private double saving_balance = 0.00;

    //Getters
    public String get_name() { return name; }
    public int get_routing_number() { return routing_number; }
    public double get_checking_balance() { return checking_balance; }
    public double get_saving_balance() { return saving_balance; }

    //Setters
    public void set_checking_balance(double balance) { checking_balance = balance; }
    public void set_saving_balance(double balance) { saving_balance = balance; }

    public Account()
    {
        System.out.println("Enter your name: ");
        this.name = scan.nextLine();
        this.routing_number = 100000 + rand.nextInt(900000);

        // scan.close();
    }

    public Account(String name)
    {
        this.name = name;
        this.routing_number = 100000 + rand.nextInt(900000);
    }

    public Account(String name, int routing_number)
    {
        this.name = name;
        this.routing_number = routing_number;
    }

    public void print_account()
    {
        System.out.println("Account name: " + this.name);
        System.out.println("Checking balance: " + this.checking_balance);
        System.out.println("Savings balance: " + this.saving_balance);
        System.out.println("Routing number: " + this.routing_number);
    }

}
