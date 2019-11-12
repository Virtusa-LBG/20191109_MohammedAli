package tictactoe;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TicTacToeTest {
	private TicTacToe ticTacToe;
	
	@Before
	public void setUp() {
		ticTacToe = new TicTacToe();
	}
	
	@Test
	public void testPutSignInvalidPosition() {
		String expectedMessage = "Invalid board position";
		ticTacToe.putSign(10);
		
		assertEquals("error in position", ticTacToe.getMessage(), expectedMessage);
	}
}
