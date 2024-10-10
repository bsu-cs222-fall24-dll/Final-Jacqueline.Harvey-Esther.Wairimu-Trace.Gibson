package edu.bsu.cs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BooksTest {
	@Test
	public void bookPresent(){
		Books one = new Books("Farenheight 451","Ray Bradbury","Novel",1951);
		Assertions.assertNotEquals(null,one);
	}
}
