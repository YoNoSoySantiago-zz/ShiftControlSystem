package controlTest;
import model.*;
import exceptions.*;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class JUnitTestControlShift {
	private ShiftControler sc = new ShiftControler();

	@Test
	void test() throws IdUserExistException, ValueIsEmptyException, UserNoExistException {
		assertThrows(UserNoExistException.class, () ->sc.searchUser("1192806566", User.CC));
		
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
		assertThrows(UserNoExistException.class, () ->sc.searchUser("45968419698", User.PS));
		setUp1();
		System.out.println(sc.searchUser("1192806566", User.CC));
		System.out.println("full: "+"Santiago"+" "+"Hurtado Solis"+"\ndocument type: "+User.CC+"\nnumber Phone: "+User.UNKNOWN);
		assertTrue(("full: "+"Santiago"+" "+"Hurtado Solis"+"\ndocument type: "+User.CC+"\nnumber Phone: "+User.UNKNOWN)==sc.searchUser("1192806566", User.CC));
		
	}
	@Test
	public void setUp1() throws IdUserExistException, ValueIsEmptyException {
		sc.registerUser("Santiago", "Hurtado Solis", User.CC, "1192806566","","");
	}
	
	void setUp2() throws IdUserExistException, ValueIsEmptyException {
		sc.registerUser("Cristian", "Ortiz Castro", User.CC, "1685334868", "SanAncho", "3216179944");
	}
	void setUp3() {
		
	}
	void setUp4() {
		
	}

}
