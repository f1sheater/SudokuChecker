import static org.junit.Assert.*;

import org.junit.Test;

public class SudokuVerifierTest {

//implement tests to test Sudokuverifier with boundary values.  Use templates from Task 1 to derive and document test cases.
	
// A correct Sudoku string: 417369825632158947958724316825437169791586432346912758289643571573291684164875293
// An incorrect Sudoku string: 123456789912345678891234567789123456678912345567891234456789123345678912234567891
String c = "417369825632158947958724316825437169791586432346912758289643571573291684164875293";
String i = "123456789912345678891234567789123456678912345567891234456789123345678912234567891";

String notNumber = "41736982563215894795872431682543716979158643234691275828964357157329168416487529e"; //last character e
String incorrect0 = "417369825632158947958724316825437169791586432346912758289643571573291684164875290"; //last digit 0
String incorrect10 = "4173698256321589479587243168254371697915864323469127582896435715732916841648752910"; //last digit 10
String incorrectCountSubgrid = "117369825632158947958724316825437169791586432346912758289643571573291684164875293"; //1 twice in first subgrid
String incorrectCountRow = "617369825432158947958724316825437169791586432346912758289643571573291684164875293"; //switched row of 2 numbers
String incorrectCountColumn = "147369825632158947958724316825437169791586432346912758289643571573291684164875293"; //switched column of 2 numbers

SudokuVerifier v = new SudokuVerifier();

	@Test //V2 V3 G2 R2 C2
	public void testCorrectString() {
		int a = v.verify(c);
		assertEquals("correct string", 0, a);
	}

	@Test
	public void testIncorrectString() {
		int a = v.verify(i);
		assertEquals("incorrect string", -2, a);
	}
	
	@Test //V1
	public void testIncorrectValue0() {
		int a = v.verify(incorrect0);
		assertEquals("incorrect string", -1, a);
	}
	
	@Test //V4
	public void testIncorrectValue10() {
		int a = v.verify(incorrect10);
		assertEquals("incorrect string", -1, a);
	}
	
	@Test //G1 G3
	public void testIncorrectCountSubgrid() {
		int a = v.verify(incorrectCountSubgrid);
		assertEquals("incorrect string", -2, a);
	}
	
	@Test //R1 R3
	public void testIncorrectCountRow() {
		int a = v.verify(incorrectCountRow);
		assertEquals("incorrect string", -3, a);
	}
	
	@Test //C1 C3
	public void testIncorrectCountColumn() {
		int a = v.verify(incorrectCountColumn);
		assertEquals("incorrect string", -4, a);
	}
	
	@Test //V5
	public void testNotNumber() {
		int a = v.verify(notNumber);
		assertEquals("incorrect string", 1, a);
	}
}
