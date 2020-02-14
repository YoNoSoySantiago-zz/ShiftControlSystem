package model;
import exceptions.*;

import java.util.ArrayList;

public class ShiftControler {
	private ArrayList<User> users;
	private ArrayList<User> userShift;
	private Shift shift;
	
	public ArrayList<User> getUserShift() {
		return userShift;
	}
	public ShiftControler() {
		users = new ArrayList<User>();
		userShift = new ArrayList<User>();
		shift = new Shift('A',-1,"---",false);
	}
	public String searchUser(String documentNumber,String documentType) throws UserNoExistException {
		String result="";
		for(int i = 0;i<users.size();i++) {
			if(users.get(i).getDocumentType()==documentType && users.get(i).getDocumentNumber()==documentNumber) {
				result = users.get(i).toString();
				break;
			}
		}
		if(result == "") {
			throw new UserNoExistException();
		}
		return result;
	}
	/**
	 *  <p> des:<p> this method allow assign a instance of Shift to a user through their identity document number
	 *  			(the turn is formed by a letter of the alphabet and a number from 0 to 99, 
	 *  			which go from lowest to highest always and once it goes from 99 it returns to 00 and the letter increases)
	 *  			taking into account if the user does not have any turn over the current shift.
	 *  <p> pre: <p>   
	 * @param documentNumber 
	 * @param documentType
	 * @throws UserAlreadyHasShiftException
	 */
	public void assignShift(String documentNumber,String documentType) throws UserAlreadyHasShiftException {
		if(userShift.size()==0) {
			for(int i =0;i<users.size();i++) {
				if(users.get(i).getDocumentNumber()==(documentNumber)&&users.get(i).getDocumentType()==documentType) {
					this.shift = new Shift('A',0,"A00",false);
					User user = users.get(i);
					user.setShift(shift);
					userShift.add(user);
				}
			}
		}else {
			for(int j =0;j<userShift.size();j++) {
				int letterUser = (int)userShift.get(j).getShift().getLetter();
				int letterShift = (int)shift.getLetter();
				if(userShift.get(j).getDocumentNumber()==(documentNumber) && letterShift>= letterUser && userShift.get(j).getDocumentType()==documentType) {
					if(letterShift== letterUser) {
						if(shift.getNumber()>userShift.get(j).getShift().getNumber()) {
							throw new UserAlreadyHasShiftException();
						}
					}else{
						throw new UserAlreadyHasShiftException();
					}
							
				}
			}
			for(int i = 0;i<users.size();i++) {
				if(users.get(i).getDocumentNumber()==(documentNumber)&&users.get(i).getDocumentType()==documentType) {
					User user = users.get(i);
					user.setShift(generateNextShift());
					userShift.add(user);
				}
			}
		}
		
		
		
	}
	//This method is to generate the next Shift in the list
	/**
	 * 
	 * @return
	 */
	public Shift generateNextShift() {
		if(userShift.size()>0) {
			Shift shift = userShift.get(userShift.size()-1).getShift();
			shift.setNumber(shift.getNumber()+1);
			if(shift.getNumber()>99) {
				if(shift.getLetter()=='Z') {
					shift.setLetter('A');
				}else shift.setLetter((char) (shift.getLetter()+1));
				
				shift.setNumber(0);
				
			}
			if(shift.getNumber()<10) {
				shift.setShift((char)(shift.getLetter())+ "0"+Integer.toString(shift.getNumber()).toUpperCase()); 
			}
			
			
			return shift;
		}else {
			return this.shift;
		}
		
	}
	/**
	 * 
	 * @param name
	 * @param lastName
	 * @param documentType
	 * @param documentNumber
	 * @param locate
	 * @param numberPhone
	 * @throws IdUserExistException
	 * @throws ValueIsEmptyException
	 */
	public void registerUser(String name,String lastName,String documentType,String documentNumber,String locate,String numberPhone) throws IdUserExistException,ValueIsEmptyException {
		for(int i =0;i<users.size();i++) {
			if(users.get(i).getDocumentNumber() == documentNumber && (users.get(i).getDocumentType() == documentType)){
				throw new IdUserExistException();
			}
		}
		if(name.isEmpty()||lastName.isEmpty()||documentType.isEmpty()||documentNumber.isEmpty()) {
			throw new ValueIsEmptyException();
		}
		if(locate.isEmpty()) {
			locate = User.UNKNOWN;
		}
		if(numberPhone.isEmpty()) {
			numberPhone = User.UNKNOWN;
		}
		users.add(new User(name,lastName,documentType,documentNumber,locate,numberPhone,null));
	}
	/**
	 * 
	 * @param attended
	 * @throws NoMoreShiftException
	 */
	public void advanceShift(boolean attended) throws NoMoreShiftException {	
		if(userShift.size()>0) {
			int letterUser = (int)userShift.get(userShift.size()-1).getShift().getLetter();
			int letterShift = (int)shift.getLetter();
			if(letterShift>= letterUser) {
				if(letterShift== letterUser) {
					if(shift.getNumber()==userShift.get(userShift.size()-1).getShift().getNumber()) {
						throw new NoMoreShiftException();
					}
				}			
			}
			for(int i =0;i<userShift.size();i++) {
				letterUser = (int)userShift.get(i).getShift().getLetter();
				if(shift.getNumber()==userShift.get(i).getShift().getNumber()&&letterUser == letterShift) {
					userShift.get(i).getShift().setAttended(attended);
				}
			}
		}else {
			throw new NoMoreShiftException();
		}	
		shift.setNumber(shift.getNumber()+1);
		if(shift.getNumber()>99) {
			shift.setNumber(0);
			shift.setLetter((char) (shift.getLetter()+1));
		}
		if(shift.getNumber()<10) {
			shift.setShift((char)(shift.getLetter())+ "0"+Integer.toString(shift.getNumber()).toUpperCase()); 
		}
	}
	public String getShift() {
		return shift.getShift();
	}
	///Methods for JUnitTest
	public ArrayList<User> getUserList(){
		return users;
	}
	
	
	
}

