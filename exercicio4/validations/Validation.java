package exercicio4.validations;

public class Validation {

	public void invalidOperationMessage(Character operator) {
		if(operator != 'A' && operator != 'E' && operator != 'R' && operator != 'Q') {
			System.out.println("Invalid operation. Select 'A', 'E', 'R' or 'Q'");
		}
	}
	
	public void invalidOperationAddAndNextMessage(Character operatorAddAndNext) {
		if(operatorAddAndNext != 'A' && operatorAddAndNext != 'N') {
			System.out.println("Invalid operation. Select 'A' or 'N'");
		}
	}
	
	public boolean invalidFormatDescriptionMessage(String description) {
		if(description == null || description.length() > 40 || description.length() <= 0) {
			System.out.println("Description has at minimum 0 and at maximum 40 characters");
			System.out.print("\nDescription > ");
			return false;
		}
		return true;
	}
	
	public void invalidNumberMessage(int editNumber, int firstChildNumber, int lastChildNumber) {
			if(editNumber > lastChildNumber || editNumber < firstChildNumber ) {
				System.out.println("\nThis number doesn't exist in the file");
		}	
	}
}
