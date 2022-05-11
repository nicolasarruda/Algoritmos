package exercicio5.views;

import java.util.Random;

public class Grid {

	private Integer rows;
	private Integer columns;
	private Integer minimum;
	private Integer maximum;
	
	public Grid() {
	}

	public Grid(Integer rows, Integer columns, Integer minimum, Integer maximum) {
		this.rows = rows;
		this.columns = columns;
		this.minimum = minimum;
		this.maximum = maximum;
	}

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	public Integer getColumns() {
		return columns;
	}

	public void setColumns(Integer columns) {
		this.columns = columns;
	}

	public Integer getMinimum() {
		return minimum;
	}

	public void setMinimum(Integer minimum) {
		this.minimum = minimum;
	}

	public Integer getMaximum() {
		return maximum;
	}

	public void setMaximum(Integer maximum) {
		this.maximum = maximum;
	}
	
	public void drawGrid() {
		
		Random rd = new Random();
		
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < columns; j++) {
				int randomNumber = rd.nextInt(maximum - minimum) + minimum;
				System.out.print("\t" + randomNumber + "  ");
			}
			System.out.println("\n");
		}
	}
}
