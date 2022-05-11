package exercicio5.application;
 
import java.util.InputMismatchException;
import java.util.Scanner;

import exercicio5.validations.Validation;
import exercicio5.views.Grid;

public class Exercise5 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println(" Generate_grid");
		Validation validation = new Validation();
		int rows = 0;
		int columns = 0;
		
		try {
			
			System.out.print("\n rows > ");
			rows = validation.validateLinesMessage(rows, sc);
			sc.skip("\\R");
			
			System.out.print("\n columns > ");
			columns = validation.validateLinesMessage(columns, sc);
			sc.skip("\\R");
			
		} catch(InputMismatchException e) {
			System.out.println("\n Invalid number. Please enter a number");
			return;
		} 
		
		String minimumKeyboard = null;
		int minimum = 0;
		
		String maximumKeyboard = null;
		int maximum = 0;
		
		do {
			
			System.out.print("\n minimum (or Enter for 0) > ");
			minimumKeyboard = sc.nextLine();
			
			minimumKeyboard = minimumKeyboard.isBlank() ? "0" : minimumKeyboard;
			
			try {
				minimum = Integer.parseInt(minimumKeyboard);
			} catch(NumberFormatException e) {
				System.out.println("\n Enter a number or click on button 'Enter'");
				return;
			}	

			System.out.print("\n maximum (or Enter for 1000) > ");
			maximumKeyboard = sc.nextLine();
			
			maximumKeyboard = maximumKeyboard.isBlank() ? "1000" : maximumKeyboard;
			
			try {
				maximum = Integer.parseInt(maximumKeyboard);
			} catch(NumberFormatException e) {
				System.out.println("\n Enter a number or click on button 'Enter'");
				return;
			}	

			validation.validateNumberMinimumAndMaximumMessage(minimum, maximum);
			
		} while(minimum >= maximum);
		
		System.out.println("\n Grid:");
		Grid grid = new Grid(rows, columns, minimum, maximum);
		grid.drawGrid();
		sc.close();
	}
}
