package com.solodkyi.java_labs.Lab1Test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.solodkyi.java_labs.Lab1.Book;
import com.solodkyi.java_labs.Lab1.Library;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;


public class LibraryTest {
	private Library lib;
	private Book book;
	
	@BeforeEach
	public void setup() 
	{
		lib = new Library();
		book = new Book("TestName1","TestAuthor1","123456789",1990);
	}
	@Test
	void testAddToArray() 
	{
		assertTrue(lib.addBook("TestName2", "TestAuthor1", "123456788", 2000));
	}
	@Test
	void testDeleteExistByISBN() 
	{
		lib.addBook(book.getName(), book.getAuthor(), book.getISBN(), book.getYear());
		assertTrue(lib.removeBookByISBN("123456789"));
	}
	@Test
	void testDeleteNotExistByISBN() 
	{
		lib.addBook(book.getName(), book.getAuthor(), book.getISBN(), book.getYear());
		assertFalse(lib.removeBookByISBN("23"));
	}
	@Test
	void testSearchByCorrectName() 
	{
		lib.addBook(book.getName(), book.getAuthor(), book.getISBN(), book.getYear());		
		assertTrue(lib.searchBookByName("TestName1"));
	}
	@Test
	void testSearchByInCorrectName() 
	{
		lib.addBook(book.getName(), book.getAuthor(), book.getISBN(), book.getYear());		
		assertFalse(lib.searchBookByName("TestName2"));
	}
	@Test
	void testEmptyLibrary() 
	{
		assertFalse(lib.removeBookByISBN(""));
		assertFalse(lib.searchBookByName(""));
	}
}
