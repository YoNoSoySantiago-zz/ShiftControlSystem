package model;
import exceptions.*;

import java.util.ArrayList;

public class ShiftControler {
	private ArrayList<User> users;
	private ArrayList<User> userShift;
	private Shift shift;
	
	public ShiftControler() {
		users = new ArrayList<User>();
		userShift = new ArrayList<User>();
		shift = new Shift('A',0,"A00",false);
	}
	public void assignShift(String documentNumber) throws UserAlreadyHasShiftException {
		for(int j =0;j<userShift.size();j++) {
			int letterUser = (int)userShift.get(j).getShift().getLetter();
			int letterShift = (int)shift.getLetter();
			if(userShift.get(j).getDocumentNumber()==(documentNumber) && letterShift>= letterUser) {
				if(letterShift== letterUser) {
					if(shift.getNumber()>userShift.get(j).getShift().getNumber()) {
						Exception e = new UserAlreadyHasShiftException();
					}
				}else{
					throw new UserAlreadyHasShiftException();
				}
						
			}
		}
		for(int i = 0;i<users.size();i++) {
			if(users.get(i).getDocumentNumber()==(documentNumber)) {
				User user = users.get(i);
				user.setShift(generateNextShift());
				userShift.add(user);
			}
		}
	}
	//This method is to generate the next Shift in the list 
	public Shift generateNextShift() {
		Shift shift = userShift.get(userShift.size()-1).getShift();
		shift.setNumber(shift.getNumber()+1);
		if(shift.getNumber()>99) {
			shift.setNumber(0);
			shift.setLetter((char) (shift.getLetter()+1));
		}
		if(shift.getNumber()<10) {
			shift.setShift((char)(shift.getLetter())+ "0"+Integer.toString(shift.getNumber()).toUpperCase()); 
		}
		
		return shift;
	}
	
	public void registerUser(String name,String lastName,String documentType,String documentNumber,String locate) throws IdUserExistException {
		for(int i =0;i<users.size();i++) {
			if(users.get(i).getDocumentNumber() == documentNumber ) {
				throw new IdUserExistException();
			}
		}
	}
	
	
}

