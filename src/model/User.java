package model;

public class User {
	private String name;
	private String lastName;
	private String documentType;
	private String documentNumer;
	private String locate;
	private Shift shift;
	public static final String CC = "citizenship card";
	public static final String CR = "civel registration";
	public static final String PS = "passport";
	public static final String FIC = "foreign identity card";
	public static final String UNKNOWN = "unknoown";
	
	public User(String name,String lastName,String documentType,String documentNumber,String locate,Shift shift) {
		this.name = name;
		this.lastName= lastName;
		this.documentType=documentType;
		this.locate = locate;
		this.shift = shift;
	}
	public String getDocumentNumber() {
		return  this.documentNumer;
	}
	public String toString() {
		return "name: "+name+"\nlastName: "+lastName+"\ndocumentType: "+documentType+"\ndocumentNumber: "+documentNumer+"\nlocate: "+locate;
	}
	public Shift getShift() {
		return shift;
	}
	public void setShift(Shift shift) {
		this.shift = shift;
	}
}
