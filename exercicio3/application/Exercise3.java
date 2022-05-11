package exercicio3.application;

import java.util.Scanner;

import exercicio3.validations.PhoneValidation;

public class Exercise3 {
	
	// USA
	// +1(505)8843591
	
	// BRAZIL:
	// +55(11)975364673
	// +55(11)46727426
	
	// ARGENTINA
	// +54(11)975364673
	// +54(11)46727426

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter your full phone number ");
		String phone = null;
		PhoneValidation pv = null;
		do {
			phone = sc.nextLine();
		    pv = new PhoneValidation();
		} while (!pv.validatePhone(phone));
		
		pv.CountryOption(phone);
		sc.close();
	}
}
