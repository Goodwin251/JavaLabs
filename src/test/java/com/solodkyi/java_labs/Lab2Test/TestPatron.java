package com.solodkyi.java_labs.Lab2Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.solodkyi.JavaLab2.LibrarySystem.Book;
import com.solodkyi.JavaLab2.LibrarySystem.Library;
import com.solodkyi.JavaLab2.LibrarySystem.Patron;

import static org.junit.jupiter.api.Assertions.assertTrue;
public class TestPatron 
{
	Patron patron;
	Book book;
	Library lib;
	@BeforeEach
	void Setup() 
	{
		patron = new Patron("TestPatron", "1");
		book = new Book("TestBook", "1", "TestAuthor");
		lib = new Library();
		
		lib.add(book);
		lib.registerPatron(patron);
	}
	@Test
	void PatronIsEqual() 
	{
		lib.lendItem(patron, book);
		Patron patron2 = patron;
		assertTrue(patron.equals(patron2));
	}
	@Test 
	void PatronIsUnEqual() 
	{
		Patron patron2 = new Patron("TestPatron2", "1");
		assertTrue(!patron.equals(patron2));
	}
}
