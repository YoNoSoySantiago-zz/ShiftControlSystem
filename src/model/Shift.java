package model;

public class Shift {
	private int number;
	private char letter;
	private String shift;
	private boolean assigned;
	private boolean actual;
	
	public Shift(int number,char letter,String shift,boolean assigned,boolean actual) {
		this.number = number;
		this.letter = letter;
		this.shift = shift;
		this.assigned = assigned;
		this.actual = actual;
	}
	 public String getShift() {
		 return this.shift;
	 }
}
