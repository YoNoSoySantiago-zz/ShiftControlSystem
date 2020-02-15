package controlTest;
import model.*;
import exceptions.*;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class JUnitTestControlShift {
	private ShiftControler sc = new ShiftControler();

	@Test
	void test() throws IdUserExistException, ValueIsEmptyException, UserNoExistException {
		
		
	}
	@Test
	public void addUserTest() throws IdUserExistException, ValueIsEmptyException {
		setUp1();
		assertTrue("Santiago"==sc.getUserList().get(sc.getUserList().size()-1).getName());
		assertTrue("1192806566"==sc.getUserList().get(sc.getUserList().size()-1).getDocumentNumber());
		assertThrows(IdUserExistException.class, () ->setUp1());
		setUp2();
		assertTrue("Cristian"==sc.getUserList().get(sc.getUserList().size()-1).getName());
		assertTrue("1685334868"==sc.getUserList().get(sc.getUserList().size()-1).getDocumentNumber());
		
	}
	@Test
	public void searchUserTest() throws UserNoExistException, IdUserExistException, ValueIsEmptyException {
		assertThrows(UserNoExistException.class, () ->sc.searchUser("1192806566", User.CC));
		assertThrows(UserNoExistException.class, () ->sc.searchUser("45968419698", User.PS));
		setUp1();
		assertTrue(("full: "+"Santiago"+" "+"Hurtado Solis"+"\ndocument type: "+User.CC+"\nnumber Phone: "+User.UNKNOWN)==sc.searchUser("1192806566", User.CC));
		
	}
	@Test
	public void assingShiftUserTest() throws IdUserExistException, ValueIsEmptyException, UserAlreadyHasShiftException {
		setUp1();
		setUp2();
		setUp3();
		setUp4();
		setUp5();
		setUp6();
		System.out.println(sc.getUserShift().get(0).getShift().getNumber());
		System.out.println(sc.getUserShift().get(0).getName());
		System.out.println(sc.getUserShift().get(1).getShift().getNumber());
		System.out.println(sc.getUserShift().get(1).getName());
		System.out.println(sc.getUserShift().get(2).getShift().getNumber());
		System.out.println(sc.getUserShift().get(2).getName());
		assertTrue(sc.getUserShift().get(0).getShift().getShift()=="A00");
		assertThrows(UserAlreadyHasShiftException.class, () -> setUp6());
		assertTrue(sc.getUserShift().get(1).getShift().getShift()=="A01");
	}
	public void setUp1() throws IdUserExistException, ValueIsEmptyException {
		sc.registerUser("Santiago", "Hurtado Solis", User.CC, "1192806566","","");
	}
	
	void setUp2() throws IdUserExistException, ValueIsEmptyException {
		sc.registerUser("Cristian", "Ortiz Castro", User.PS, "1685334868", "SanAncho", "3216179944");
	}
	
	void setUp3() throws UserAlreadyHasShiftException, IdUserExistException, ValueIsEmptyException {
		sc.registerUser("Sebastian", "Moreno Solis", User.CR, "123456789","","");
	}
	
	void setUp4() throws UserAlreadyHasShiftException {
		sc.assignShift("1685334868", User.PS);
	}
	
	void setUp5() throws UserAlreadyHasShiftException {
		sc.assignShift("123456789", User.CR);
	}
	
	void setUp6() throws UserAlreadyHasShiftException {
		sc.assignShift("1192806566", User.CC);
	}

}
