package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.println("Enter account data");
			System.out.print("Number: ");
			Integer number = sc.nextInt();
			System.out.print("Holder: ");
			String holder = sc.next();
			System.out.print("Initial balance: ");
			Double iniBalance = sc.nextDouble();
			System.out.print("Withdraw Limit: ");
			Double iniLimit = sc.nextDouble();

			Account account = new Account(number, holder, iniBalance, iniLimit);
			
			System.out.println("");
			System.out.print("Enter amount for withdraw: ");
			Double withDraw = sc.nextDouble();
			
			account.withdraw(withDraw);
			System.out.println(account);
		}
		catch (DomainException e) {
			System.out.println("Withdraw error: " + e.getMessage());
		}
		catch (RuntimeException e) {
			System.out.println("Unexpected error");
		}
				
			
	
		
		sc.close();
	}

}
