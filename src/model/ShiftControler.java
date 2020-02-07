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
		shift = new Shift(0,'A',"A00",false,true);
	}
	public void assignShift(String documentNumber) throws UserAlreadyHasShiftException {
		for(int j =0;j<userShift.size();j++) {
			if(userShift.get(j).getDocumentNumber()==(documentNumber)) {
				Exception e = new UserAlreadyHasShiftException();
			}
		}
		for(int i = 0;i<users.size();i++) {
			if(users.get(i).getDocumentNumber()==(documentNumber)) {
				userShift.add(users.get(i))
			}
		}
	}
}
