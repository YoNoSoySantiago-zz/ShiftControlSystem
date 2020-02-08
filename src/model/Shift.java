package model;

public class Shift {
	private String shift;
	private boolean attended;
	
	public Shift(String shift,boolean attended) {
		this.shift = shift;
		this.attended = attended;
		
	}
	 public boolean isAttended() {
		return attended;
	}
	public void setAttended(boolean attended) {
		this.attended = attended;
	}
	public String getShift() {
		 return this.shift;
	 }
	 public String setShift() {
		 return this.shift;
	}
}
