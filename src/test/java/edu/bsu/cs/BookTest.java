package edu.bsu.cs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BookTest {
	@Test
	public void bookPresent(){
		Book one = new Book("Fahrenheit 451","Ray Bradbury","Novel",1951);
		Assertions.assertNotEquals(null,one);
	}
}
