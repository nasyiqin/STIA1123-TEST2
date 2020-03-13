import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String name;
        String id;
        String incomeType;
        double amount, tax, totalTax = 0, netIncome = 0;

        System.out.print("Enter Staff Name: ");
        name = input.nextLine();
        System.out.print("Enter Staff ID: ");
        id = input.nextLine();
        System.out.print("Enter Income Type: ");
        incomeType = input.nextLine();
        System.out.print("Enter Income Amount: ");
        amount = input.nextDouble();
        System.out.print("Enter Income Tax Percentage(%): ");
        tax = input.nextDouble();

        Income income = new Income( incomeType, amount, tax);
        Staff staff = new Staff(name, id, income);
        staff.displayStaffInfo();
        staff.displayIncomeInfo();
    }
}

 class Income{

    private String incomeType;
    private double amount;
    private double tax;
    private double totalTax;

    public Income(String incomeType, double amount, double tax){

        this.incomeType = incomeType;
        this.amount = amount;
        this. tax = tax;
    }

    public String getIncomeType(){
        return incomeType;
    }

    public double getAmount(){
        return amount;
    }

    public double getTax(){
        return tax;
    }

    public double getTotalTax(){
        double totalTax = (tax/100) * amount;
        return totalTax;
    }
}

 class Staff {

    private String name;
    private String id;
    private Income income;

    public Staff(String name, String id, Income income) {
        this.name = name;
        this.id = id;
        this.income = income;
    }

    public String getName(){
        return name;
    }

    public String getId(){
        return id;
    }

    public double calculateNetIncome(){
        double  netIncome = income.getAmount()- income.getTotalTax();
        return netIncome;
    }

    public void displayStaffInfo(){
        System.out.println("\n------------STAFF INFO------------");
        System.out.println("Staff name: " + getName());
        System.out.println("Staff ID: " + getId());

    }

    public void displayIncomeInfo(){
        System.out.println("\n------------INCOME INFO------------");
        System.out.println("Income Amount: " + income.getAmount());
        System.out.println("Income Type: " + income.getIncomeType());
        System.out.println("Income Tax Percentage(%): " + income.getTax());
        System.out.println("Total Tax Paid " + income.getTotalTax());
        System.out.println("Total Net Income: " + calculateNetIncome());
    }
}





