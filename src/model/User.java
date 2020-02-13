package model;

public class User {
	private String name;
	private String lastName;
	private String documentType;
	private String documentNumber;
	private String locate;
	private String numberPhone;
	private Shift shift;
	public static final String CC = "citizenship card";
	public static final String CR = "civel registration";
	public static final String PS = "passport";
	public static final String FIC = "foreign identity card";
	public static final String UNKNOWN = "unknown";
	
	public User(String name,String lastName,String documentType,String documentNumber,String locate,String numberPhone,Shift shift) {
		this.name = name;
		this.lastName= lastName;
		this.documentType=documentType;
		this.documentNumber = documentNumber;
		this.locate = locate;
		this.numberPhone = numberPhone;
		this.shift = shift;
	}
	public String toString() {
		return "full: "+name+" "+lastName+"\ndocument type: "+documentType+"\nnumber Phone: "+numberPhone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDocumentType() {
		return documentType;
	}

	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}

	public String getDocumentNumber() {
		return documentNumber;
	}

	public void setDocumentNumber(String documentNumber) {
		this.documentNumber = documentNumber;
	}

	public String getLocate() {
		return locate;
	}

	public void setLocate(String locate) {
		this.locate = locate;
	}

	public String getNumberPhone() {
		return numberPhone;
	}

	public void setNumberPhone(String numberPhone) {
		this.numberPhone = numberPhone;
	}

	public Shift getShift() {
		return shift;
	}

	public void setShift(Shift shift) {
		this.shift = shift;
	}
	
}
