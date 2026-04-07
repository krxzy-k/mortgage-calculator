import java.text.NumberFormat;
import java.util.Scanner;

public class MortgageCalculator {
    public static void main(String[] Args) {

        System.out.println("===Mortgage Calculator===");
        Scanner input = new Scanner(System.in);

        System.out.print("Enter principle amount: ");
        double principlaAmount = input.nextDouble();

        System.out.print("Enter anuall intrest rate(percentage value: ");
        double anuallIntrestRate = input.nextDouble();

        System.out.print("Enter period(years): ");
        double period = input.nextDouble();

        // calculation

        double monthlyIntrestRate = (anuallIntrestRate/12)/100;

        int periodInMonths = (int) period*12;

        double exponentpart = Math.pow(1 + monthlyIntrestRate,periodInMonths);

        double topFraction  = principlaAmount * (monthlyIntrestRate * exponentpart);

        double bottomFraction = exponentpart - 1;

        double mortgage = topFraction/bottomFraction;
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        String mortgageString = currency.format(mortgage);
        System.out.println("Your mortgage is: " + mortgageString);

        input.close();

    }
}
