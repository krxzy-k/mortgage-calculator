import java.text.NumberFormat;
import java.util.Scanner;

public class MortgageCalculator {
    public static void main(String[] Args) {

        final int monthsInAYear = 12;
        final double percentage = 100;
        double principlaAmount = 0;
        double annuallIntrestRate = 0;
        double period = 0;

        System.out.println("===Mortgage Calculator===");
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.print("Enter principle amount(1K - 1M): ");
            principlaAmount = input.nextDouble();
            if (principlaAmount >= 1_000 && principlaAmount <= 1_000_000) {
                break;
            } else {
                System.out.println("Enter amount between 1K & 1M");
            }

        }

        while (true) {
            System.out.print("Enter annuall intrest rate(percentage value): ");
            annuallIntrestRate = input.nextDouble();
            if (annuallIntrestRate >=1 && annuallIntrestRate <= 30) {
                break;
            } else {
                System.out.println("Enter a percentage between 1 & 30");
            }
        }

        while (true) {
            System.out.print("Enter period(years): ");
            period = input.nextDouble();
            if (period >= 1 && period <= 30) {
                break;
            } else{
                System.out.println("Enter a period betweeen 1 & 30");
            }

        }
        input.close();

        // calculation

        double monthlyIntrestRate = (annuallIntrestRate/monthsInAYear)/percentage;

        int periodInMonths = (int) period*12;

        double exponentpart = Math.pow(1 + monthlyIntrestRate,periodInMonths);

        double topFraction  = principlaAmount * (monthlyIntrestRate * exponentpart);

        double bottomFraction = exponentpart - 1;

        double mortgage = topFraction/bottomFraction;
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        String mortgageString = currency.format(mortgage);
        System.out.print("Your mortgage is: " + mortgageString);
    }
}
