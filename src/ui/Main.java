package ui;
import model.*;
import exceptions.*;
import java.util.Scanner;

public class Main {
	private ShiftControler shiftControler = new ShiftControler(); 
	public static void main(String[]args) throws IdUserExistException, ValueIsEmptyException {
		boolean continue1 = true;
		System.out.println("=============================\nWELCOME\n=============================");
		Main main = new Main();
		do {
			main.showMenu();
			continue1 = main.start();
		}while(continue1 == true);
		
		
	}
	public void showMenu() {
		System.out.println("1. Agregar usuar\n"+"2. Registrar turno\n"+"3. Atender Turno\n"+"0. Exit");
	}
	public boolean start() throws IdUserExistException, ValueIsEmptyException, UserAlreadyHasShiftException, NoMoreShiftException {
		Scanner s = new Scanner(System.in);
		boolean continue1= true;
		int optionAux=0;
		int option = s.nextInt();
		String name="",lastName="",documentNumber="",documentType="",locate="",numberPhone="";
		switch(option) {
		case 1:
			System.out.println("Type the name of the user");
			name=s.next();
			System.out.println("Type the lastName of the user");
			lastName=s.next();
			s.nextLine();
			System.out.println("Type the documentType of the user: "
					+ "\n1. citizenship card \n2. civel registration \n3. passport \n4. foreign identity card");
			optionAux=0;
			do {
				optionAux=s.nextInt();
				s.nextLine();
				
				switch(optionAux) {
				case 1:
					documentType = User.CC;
					break;
				case 2:
					documentType = User.CR;
					break;
				case 3:
					documentType = User.FIC;
					break;
				case 4:
					documentType = User.PS;
					break;
				default:
					System.out.println("Please type a correctly");
				}
			}while(optionAux!=1 &&optionAux!=2 &&optionAux!=3 &&optionAux!=4 );
			System.out.println("Type the documentNumber of the user");
			documentNumber=s.next();
			System.out.println("Want to share your location \n1.Yes \n0.No");
			optionAux = s.nextInt();
			
			if(optionAux ==1) {
				System.out.println("Type the locate of the user");
				locate=s.next();
			
			}else if(optionAux!=0){
				System.out.println("this option is not correct so it will become a not automatically");
			}
			System.out.println("Want to share your cell/telephone number \n1.Yes \n0.No");
			optionAux = s.nextInt();
			if(optionAux ==1) {
				System.out.println("Type the cell/telephone number of the user");
				numberPhone=s.next();
				
			}else if(optionAux!=0){
				System.out.println("this option is not correct so it will become a not automatically");
				
			}
			shiftControler.registerUser(name, lastName, documentType, documentNumber, locate, numberPhone);
			break;
		case 2:
			System.out.println("Type the documentType of the user: "
					+ "\n1. citizenship card \n2. civel registration \n3. passport \n4. foreign identity card");
			optionAux=0;
			do {
				optionAux=s.nextInt();
				
				switch(optionAux) {
				case 1:
					documentType = User.CC;
					break;
				case 2:
					documentType = User.CR;
					break;
				case 3:
					documentType = User.FIC;
					break;
				case 4:
					documentType = User.PS;
					break;
				default:
					System.out.println("Please type a correctly");
				}
			}while(optionAux!=1 &&optionAux!=2 &&optionAux!=3 &&optionAux!=4 );
			
			System.out.println("Type your document number");
			documentNumber = s.next();
			shiftControler.assignShift(documentNumber,documentType);
			break;
		case 3:
			shiftControler.advanceShift();
			
		}
		return continue1;
	}
}


