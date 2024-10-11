package payment_service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import Service.ContractService;
import Service.PayPalService;
import entities.Contract;
import entities.Installment;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		DateTimeFormatter fmt =  DateTimeFormatter.ofPattern("dd/MM/yyyy");

		System.out.println("Enter the data contracts: ");
		System.out.println("Number: ");
		Integer number = sc.nextInt();
		System.out.println("Date (dd/MM/yyyy): ");
		LocalDate date = LocalDate.parse(sc.next(), fmt);
		System.out.println("Contract value: ");
		Double totalValue = sc.nextDouble();
		System.out.println("Enter the installment number: ");
		Integer installment = sc.nextInt();

		Contract obj = new Contract(number, date, totalValue);
		ContractService service = new ContractService(new PayPalService());
		service.processContract(obj, installment);
		List<Installment> totalInstallment = obj.getInstallments();
		System.out.println(totalInstallment);
		sc.close();
	}

}
