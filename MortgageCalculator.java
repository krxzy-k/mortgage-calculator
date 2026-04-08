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
