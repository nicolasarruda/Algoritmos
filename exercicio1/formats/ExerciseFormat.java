package exercicio1.formats;

import java.util.Scanner;

public class ExerciseFormat {

	private final String pathLst = "C:\\Users\\Nícolas\\Desktop\\";
	
	public ExerciseFormat() {
	}
	
	public String formatURL(String url) {
		String https = "";
		
		if(url.length() >= 8) {
			https = url.substring(0, 8);
		}
		
		if (https.compareTo("https://") == 0) {
			return "    " + url;
		}
		return "    https://" + url;
	}
	
	private String dots(String description) {
		String dots = "";
		for(int i = 0; i < 40; i++) {
			if(i > description.length()) {
				dots += "."; 
			}
		}
		return dots;
	}
	
	public String formatDescription(String sequenceNumber, String description) {
		String dots = dots(description);
		
		// For 99 digits 
		if(sequenceNumber.length() == 2) {
			return "(" + sequenceNumber + ")    " + description + dots; 
		}
		
		// For 999 digits
		if(sequenceNumber.length() == 3) {
			return "(" + sequenceNumber + ")   " + description + dots; 
		}
		
		return "(" + sequenceNumber + ")     " + description + dots;
	}
	
	public String formatDescription(Integer sequenceNumber, String description) {
		String dots = dots(description);
		return "(" + sequenceNumber + ")   " + description + dots;
	}
	
	public void skipLine(Scanner sc) {
		sc.skip("\\R");
	}

	public String formatLstArchive(String fileName) {
		return fileName + ".lst";
	}
	
	public String formatPathAndLstArchive(String fileName) {
		return pathLst + fileName + ".lst";
	}
}
