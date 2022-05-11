package exercicio2.application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import exercicio2.format.Format;


public class Exercise2 {

	public static void main(String[] args) {
		
		String fileName = "C:\\temp\\ws-eclipse\\ExercicioLogicaSummitBra\\src\\exercicio2\\html\\index.html";
		File file = new File(fileName);
	
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line = br.readLine();
			while (line != null) {
				Format f = new Format();
				line = f.pattern(line);
				line = f.withoutPattern(line);
				line = line.replaceAll("=", " =");
				System.out.println(line);
				line = br.readLine();
			}
			br.close();
		}
		catch(IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}
