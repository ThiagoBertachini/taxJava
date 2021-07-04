package application;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of taxpayers");
        int N = sc.nextInt();

        List<TaxPayer> taxPayerListist = new ArrayList<TaxPayer>();

        for (int i = 1; i < N; i++) {
            System.out.println("Tax payer #" + i + " data: ");
            System.out.println("Individual or Company? : (I/C)");
            char type = sc.next().charAt(0);
            System.out.println("Name: ");
            String name = sc.next();
            System.out.println("Anual Income: ");
            Double anualIncome = sc.nextDouble();
            if(type == 'I'){
                System.out.println("Health expenditures: ");
                double healthExpenditures = sc.nextDouble();
                Individual x = new Individual(name, anualIncome, healthExpenditures);
                taxPayerListist.add(x);
                } else{
            System.out.println("Number of employees: ");
            Integer numberOfEmployees = sc.nextInt();
            taxPayerListist.add(new Company(name, anualIncome, numberOfEmployees));
            }
        }

        System.out.println("");
        System.out.println("Tax payed: ");

        for (TaxPayer tp : taxPayerListist) {
            System.out.println(tp.getName() + ": $ " + String.format("%.2f", tp.tax()));
        }
        System.out.println("");
        double sum = 0.0;
        for (TaxPayer tp : taxPayerListist) {
            sum += tp.tax();
        }
        System.out.println("Total tax: " + String.format("%.2f", sum));

        sc.close();
    }
}
