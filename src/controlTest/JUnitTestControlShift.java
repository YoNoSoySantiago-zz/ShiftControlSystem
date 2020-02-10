package controlTest;
import model.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import exceptions.IdUserExistException;
import exceptions.ValueIsEmptyException;

class JUnitTestControlShift {
	private ShiftControler sc = new ShiftControler();

	@Test
	void test() {
		fail("Not yet implemented");
	}
	public void setUp1() throws IdUserExistException, ValueIsEmptyException {
		sc.registerUser("Santiago", "Hurtado Solis", User.CC, "1192806566", "", "");
	}

}
