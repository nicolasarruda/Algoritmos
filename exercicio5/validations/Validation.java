package exercicio5.validations;

import java.util.Scanner;

public class Validation {

	public int validateLinesMessage(int line, Scanner sc) {
		do {
			line = sc.nextInt();
			if(line <= 0) {
				System.out.println(" Enter a number higher than 0");
				System.out.print(" > ");
			}
		}while (line <= 0);
		return line;
	}
	
	public void validateNumberMinimumAndMaximumMessage(Integer minimumKeyboard, Integer maximumKeyboard) {
		if(minimumKeyboard >= maximumKeyboard) {
			System.out.println("\nEnter the minimum number less than maximum number");
		}
	}
}
