package exercicio3.validations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneValidation {

	public PhoneValidation() {
	}
	
	public boolean validatePhone(String phone) {
		String validationExpressionCode = "^[1-9]{1,3}[0-9]{2,3}(?:[2-8]|9[1-9])[0-9]{3}[0-9]{4}$";
		Pattern pt = Pattern.compile(validationExpressionCode);
		Matcher match = pt.matcher(phone);
		
		boolean result = match.matches();
		if(!result) {
			System.out.println("It doesn't a valid phone number.");
			System.out.print("\nEnter your full phone number ");
			return false;
		}
		return true;
	}
	
	public void CountryOption(String phone) {
		String idPhone = null;
		
		// USA 
		if(phone.length() == 11) {
			idPhone = phone.substring(0, 1);
			formatUSA(idPhone, phone);
			switch (idPhone) {
				case "1":
					System.out.println("Country: USA");
					break;
				default:
					System.out.println("Country: undefined");
					break;
			}
		}
		
		// BRAZIL AND ARGENTINA
		if(phone.length() == 13 || phone.length() == 12) {
			idPhone = phone.substring(0, 2);
			formatBrazilArgentina(idPhone, phone);
			switch(idPhone) {
				case "54":
					System.out.println("Country: Argentina");
					break;
				case "55":
					System.out.println("Country: Brazil");
					break;
				default:
					System.out.println("Country: undefined");
					break;
			}
		}
	}

	private void formatUSA(String idPhone, String phone) {
		String parenthesisNumber = phone.substring(1, 4);
		String outParenthesisNumber = phone.substring(4);
		System.out.println("Phone: +" + idPhone + "("+parenthesisNumber+")" + outParenthesisNumber);
	}

	private void formatBrazilArgentina(String idPhone, String phone) {
		String parenthesisNumber = phone.substring(2, 4);
		String outParenthesisNumber = phone.substring(4);
		System.out.println("Phone: +" + idPhone + "("+parenthesisNumber+")" + outParenthesisNumber);
	}
}
