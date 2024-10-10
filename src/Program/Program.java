package Program;
import java.util.Scanner;

import model.Entities.Bank;
import model.Exception.DomainException;

public class Program {

	public static void main(String[] args) {
		try {	
			Scanner sc = new Scanner(System.in);
	
			System.out.println("Enter acount data: ");
			System.out.println("Number account: ");
			Number number = sc.nextDouble();
			System.out.println("Holder: ");
			String holder = sc.next();
			System.out.println("initial balance: ");
			Double initialBalance = sc.nextDouble();
			System.out.println("Withdraw limit: ");
			Double withdrawLimit = sc.nextDouble();
	
			Bank bank = new Bank(number, holder, initialBalance, withdrawLimit);
			System.out.println("Bank:" + bank.AccountData(number, holder, initialBalance, withdrawLimit));
	
			System.out.println("Enter amount for withdraw: ");
			Double withdraw = sc.nextDouble();
			bank.withdraw(withdraw);
			System.out.println("New balance:" + bank.getBalance());
			sc.close();
		} catch (DomainException e) {
			System.out.println("Withdraw error: " + e.getMessage());
		}
	}
}
