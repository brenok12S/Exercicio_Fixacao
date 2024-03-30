package application;


import java.util.Locale;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;


import entitites.TaxPayer;
import entitites.Individual;
import entitites.Company;


public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<TaxPayer> list = new ArrayList<TaxPayer>();
		
		System.out.println("Enter the number of taxpayers : ");
		int n = sc.nextInt();
		
		for (int i = 0; i < n; i++) {
			System.out.println("Taxpayer #" + (i +1) + " data : ");
			System.out.print("Individual or company (i/c)? ");
			char ch = sc.next().charAt(0);
			System.out.print("Name : ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Anual income : ");
			Double anualIncome = sc.nextDouble();
			
			if(ch == 'i') {
				System.out.print("Health expeditures : ");
				Double healthExpeditures = sc.nextDouble();
				list.add(new Individual(name, anualIncome, healthExpeditures));
			} else {
				System.out.print("Number of employees: ");
				int numberOfEmployees = sc.nextInt();
				list.add(new Company(name, anualIncome, numberOfEmployees));
				}
		}
		
		System.out.println("");
		System.out.println("TAXES PAID : ");
		
		for (TaxPayer tp : list) {
			System.out.println(tp.getName() + ": $" + String.format("%.2f", tp.tax()));
			
		}
		
		sc.close();

	}

}
